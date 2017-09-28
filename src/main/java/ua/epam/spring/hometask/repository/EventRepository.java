package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public interface EventRepository {

  Event getByName(String name);

  Event save(Event object);

  void remove(Event object);

  Event getById(Long id);

  Collection<Event> getAll();

  void updateEventBySoldTicket(Ticket ticket);

  Set<Event> getForRange(LocalDate from, LocalDate to);

  Set<Event> getNextEvents(LocalDateTime to);
}
