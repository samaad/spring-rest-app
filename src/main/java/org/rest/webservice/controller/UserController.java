package org.rest.webservice.controller;

import org.rest.webservice.dao.UserDao;
import org.rest.webservice.exception.UserNotFoundException;
import org.rest.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private MessageSource messageSource;

  UserDao userDao;
  public UserController(UserDao userDao){
    this.userDao = userDao;
  }

  @GetMapping("/")
  public List<User> retriveAllUsers(){
      return userDao.findAll();
  }

  @PostMapping("/")
  public ResponseEntity createUser(@Valid @RequestBody User user){
    User responsUser = userDao.save(user);
    URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
        .buildAndExpand(responsUser.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

//  HETEOAS Example
  @GetMapping("/{userId}")
  public EntityModel<User> retriveUser(@PathVariable("userId") int userId){
    User user = userDao.findOne(userId);
    if(user == null){
      throw new UserNotFoundException("User Not Found for "+ userId);
    }

    EntityModel<User> entityModel = EntityModel.of(user);
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
    entityModel.add(linkTo.withRel("all-users"));
    return entityModel;
  }

  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable("userId") int userId){
    User user = userDao.deleteById(userId);
    if(user == null){
      throw new UserNotFoundException("User Not Found for "+ userId);
    }
  }

  @GetMapping("/international")
  public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale local){
//    return messageSource.getMessage( "good.morning.message", null,local);
    return messageSource.getMessage( "good.morning.message", null, LocaleContextHolder.getLocale());
  }


}
