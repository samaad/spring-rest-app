package org.rest.webservice.dao;

import org.rest.webservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDao {
  private static List<User> users = new ArrayList<>();
  private static int COUNTER = 3;
  static {
    users.add(new User(1,"Adam", new Date(), new ArrayList<>()));
    users.add(new User(2,"Eve", new Date(), new ArrayList<>()));
    users.add(new User(3,"Jack", new Date(), new ArrayList<>()));
  }

  public List<User> findAll() {
    return users;
  }

  public User save(User user){
    if(user.getId() == null){
      user.setId(++COUNTER);
    }
    users.add(user);
    return user;
  }

  public User findOne(int id) {
    for(User user: users){
      if(user.getId() == id){
        return user;
      }
    }
    return null;
  }

  public User deleteById(int id) {
    Iterator<User> iterator = users.iterator();
    while (iterator.hasNext()){
      User user = iterator.next();
      if(user.getId()== id){
        iterator.remove();
        return user;
      }
    }
    return null;
  }
}
