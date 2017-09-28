package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.repository.AuditoriumRepository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class AuditoriumServiceImpl implements AuditoriumService{

  private AuditoriumRepository repository;

  public AuditoriumServiceImpl(AuditoriumRepository repository) {
    this.repository = repository;
  }

  @Nonnull
  @Override
  public Set<Auditorium> getAll() {
    return repository.getAll();
  }

  @Nullable
  @Override
  public Auditorium getByName(@Nonnull String name) {
    return repository.getByName(name);
  }
}
