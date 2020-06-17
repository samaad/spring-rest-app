package org.rest.webservice.controller;

import org.rest.webservice.dao.PostDao;
import org.rest.webservice.dao.UserDao;
import org.rest.webservice.model.Post;
import org.rest.webservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class PostController {

  PostDao postDao;

  public PostController(PostDao postDao){
    this.postDao = postDao;
  }

//  @GetMapping("/{userId}/post")
//  public List<Post> retriveAllUsers(@PathVariable("userId") int userId){
//    return postDao.findAll();
//  }

  @PostMapping("/{userId}/post")
  public ResponseEntity createUser(@Valid @RequestBody Post post, @PathVariable("userId") int userId){
    Post responsUser = postDao.save(post, userId);
    URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
        .buildAndExpand(responsUser.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @GetMapping("/{userId}/post")
  public List<Post> retriveByUserId(@PathVariable("userId") int userId){
    return postDao.findByUserId(userId);
  }

  @GetMapping("/{userId}/post/{postId}")
  public Post retriveByPostId(@PathVariable("userId") int userId, @PathVariable("postId") int postId){
    return postDao.findOne(userId, postId);
  }

}
