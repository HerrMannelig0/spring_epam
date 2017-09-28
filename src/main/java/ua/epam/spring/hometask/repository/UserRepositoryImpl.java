package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.User;

import java.util.*;

public class UserRepositoryImpl implements UserRepository{

  private static Map<Long, User> users = new HashMap<>();

  @Override
  public Collection<User> getAllUsers() {
    return users.values();
  }

  @Override
  public User save(User user) {
    return users.put(user.getId(), user);
  }

  @Override
  public void remove(Long id){
    users.remove(id);
  }

  @Override
  public User getById(Long id) {
    return users.get(id);
  }

  @Override
  public User getByEMail(String email){

    if(email == null)
      return null;

    for (Map.Entry<Long, User> userEntry : users.entrySet()) {
      String userEMail = userEntry.getValue().getEmail();
      if(email.equals(userEMail))
        return users.get(userEntry.getKey());
    }

    return null;
  }

  @Override
  public void remove(User user) {
    users.remove(user.getId());
  }

}
