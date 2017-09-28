package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.HashSet;
import java.util.Set;

public class AuditoriumRepositoryImpl implements AuditoriumRepository{

  private static Set<Auditorium> auditoriumSet = new HashSet<>();

  @Override
  public Set<Auditorium> getAll() {
    return auditoriumSet;
  }

  @Override
  public Auditorium getByName(String name) {

    if(name == null)
      return null;

    for (Auditorium auditorium : auditoriumSet) {
      if (name.equals(auditorium.getName()))
        return auditorium;
    }

    return null;
  }
}
