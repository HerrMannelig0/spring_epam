package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class EventRepositoryImpl implements EventRepository {

  private List<Event> eventList = new ArrayList<>();

  @Override
  public Event getByName(String name) {
    if (name == null)
      return null;

    for (Event event : eventList) {
      if (name.equals(event.getName()))
        return event;
    }

    return null;
  }

  @Override
  public Event save(Event event) {
    eventList.add(event);
    return event;
  }

  @Override
  public void remove(Event event) {
    eventList.remove(event);
  }

  @Override
  public Event getById(Long id) {

    for (Event event : eventList) {
      if (id.equals(event.getId())) {
        return event;
      }
    }
    return null;
  }

  @Override
  public Collection<Event> getAll() {
    return eventList;
  }

  @Override
  public void updateEventBySoldTicket(Ticket ticket) {

    Event event = getById(ticket.getEvent().getId());

    if(event == null) {
      return;
    }

    event.addSoldTicket(ticket.getDateTime(), ticket);
  }

  @Override
  public Set<Event> getForRange(LocalDate from, LocalDate to) {
    Set<Event> result = new HashSet<>();

    for (Event event : eventList) {
      if(isEventInRange(event, from, to)) {
        result.add(event);
      }
    }
    return result;
  }

  @Override
  public Set<Event> getNextEvents(LocalDateTime to) {
    return getForRange(LocalDate.now(), to.toLocalDate());
  }

  private boolean isEventInRange(Event event, LocalDate from, LocalDate to) {

    NavigableSet<LocalDateTime> airDates = event.getAirDates();

    for (LocalDateTime airDate : airDates) {
      boolean isAfterStart = airDate.toLocalDate().isAfter(from);
      boolean isBeforeEnd = airDate.toLocalDate().isBefore(to);
      if(isAfterStart && isBeforeEnd){
        return true;
      }
    }
    return false;
  }

}
