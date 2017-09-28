package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.repository.EventRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class EventServiceImpl implements EventService{

  private EventRepository repository;

  public EventServiceImpl(EventRepository repository) {
    this.repository = repository;
  }

  @Nullable
  @Override
  public Event getByName(@Nonnull String name) {
    return repository.getByName(name);
  }

  @Override
  public void updateEventBySoldTicket(Ticket ticket) {
    repository.updateEventBySoldTicket(ticket);
  }

  @Nonnull
  @Override
  public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
    return repository.getForRange(from, to);
  }

  @Nonnull
  @Override
  public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
    return repository.getNextEvents(to);
  }

  @Override
  public Event save(@Nonnull Event object) {
    return repository.save(object);
  }

  @Override
  public void remove(@Nonnull Event object) {
    repository.remove(object);
  }

  @Override
  public Event getById(@Nonnull Long id) {
    return repository.getById(id);
  }

  @Nonnull
  @Override
  public Collection<Event> getAll() {
    return repository.getAll();
  }
}
