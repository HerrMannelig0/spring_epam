package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.User;

import java.util.Collection;
import java.util.Map;

public interface UserRepository {

  Collection<User> getAllUsers();

  User save(User user);

  void remove(Long id);

  User getById(Long id);

  User getByEMail(String email);

  void remove(User object);
}
