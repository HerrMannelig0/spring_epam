package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.Set;

public class BookingServiceImpl implements BookingService {

  private static final double REGULAR_SEAT_RATE = 1.0;
  private static final double VIP_SEAT_RATE = 2.0;

  private DiscountService discountService;
  private UserService userService;
  private EventService eventService;

  public BookingServiceImpl(DiscountService discountService, UserService userService, EventService eventService) {
    this.discountService = discountService;
    this.userService = userService;
    this.eventService = eventService;
  }

  @Override
  public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
    double basePrice = event.getBasePrice();
    EventRating rating = event.getRating();

    NavigableMap<LocalDateTime, Auditorium> auditoriums = event.getAuditoriums();
    Auditorium auditorium = auditoriums.get(dateTime);

    Set<Long> vipSeats = auditorium.getVipSeats();

    double totalPrice = 0.0;

    for (Long seat : seats) {
      double price = basePrice;
      price *= rating.getRate();
      price *= calculateVipSeatRate(seat, vipSeats);

      totalPrice += price;
    }
    byte discount = discountService.getDiscount(user, event, dateTime, seats.size());

    return discount * totalPrice;
  }

  private double calculateVipSeatRate(Long seat, Set<Long> vipSeats) {
    if (vipSeats.contains(seat)) {
      return VIP_SEAT_RATE;
    }
    return REGULAR_SEAT_RATE;
  }

  @Override
  public void bookTickets(@Nonnull Set<Ticket> tickets) {
    for (Ticket ticket : tickets) {
      appendTicketToUser(ticket);
      eventService.updateEventBySoldTicket(ticket);
    }
  }

  private void appendTicketToUser(Ticket ticket) {
    User userFromTicket = ticket.getUser();
    if (userFromTicket != null) {
      User user = userService.getById(userFromTicket.getId());
      if (user == null){
        userFromTicket.addTicket(ticket);
        userService.save(userFromTicket);
      } else {
        user.addTicket(ticket);
      }
    }
  }

  @Nonnull
  @Override
  public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
    return event.getSoldTickets().get(dateTime);
  }
}
