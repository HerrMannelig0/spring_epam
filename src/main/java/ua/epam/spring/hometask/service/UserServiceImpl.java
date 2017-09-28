package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepositoryImpl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class UserServiceImpl implements UserService {

  private UserRepositoryImpl repository;

  public UserServiceImpl(UserRepositoryImpl repository) {
    this.repository = repository;
  }

  @Nullable
  @Override
  public User getUserByEmail(@Nonnull String email) {
    return repository.getByEMail(email);
  }

  @Override
  public User save(@Nonnull User object) {
    return repository.save(object);
  }

  @Override
  public void remove(@Nonnull User object) {
    repository.remove(object);
  }

  @Override
  public User getById(@Nonnull Long id) {
    return repository.getById(id);
  }

  @Nonnull
  @Override
  public Collection<User> getAll() {
    return repository.getAllUsers();
  }
}
