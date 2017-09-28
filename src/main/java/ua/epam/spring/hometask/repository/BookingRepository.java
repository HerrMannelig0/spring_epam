package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.Set;

public interface BookingRepository {

  double getTicketPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats);

  void bookTickets(Set<Ticket> tickets);

  Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);
}
