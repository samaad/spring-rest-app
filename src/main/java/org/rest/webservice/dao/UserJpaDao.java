package org.rest.webservice.dao;

import org.rest.webservice.model.User;
import org.rest.webservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJpaDao {

  UserRepository userRepository;

  public UserJpaDao(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User save(User user){
    if(user.getId() != null){
      userRepository.save(user);
      return user;
    }
    return null;
  }

  public Optional<User> findOne(int id) {
    Optional<User> user = userRepository.findById(id);
    return user.map(Optional::of).orElse(null);
  }
}
