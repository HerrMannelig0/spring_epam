package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.Set;

public class BookingRepositoryImpl implements BookingRepository {

  @Override
  public double getTicketPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {


    return 0;
  }

  @Override
  public void bookTickets(Set<Ticket> tickets) {

  }

  @Override
  public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
    return null;
  }
}
