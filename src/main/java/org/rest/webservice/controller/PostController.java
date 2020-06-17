package org.rest.webservice.controller;

import org.rest.webservice.dao.PostDao;
import org.rest.webservice.dao.UserDao;
import org.rest.webservice.model.Post;
import org.rest.webservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/{userId}/post")
  public List<Post> retriveByUserId(@PathVariable("userId") int userId){
    return postDao.findByUserId(userId);
  }

  @GetMapping("/{userId}/post/{postId}")
  public Post retriveByPostId(@PathVariable("userId") int userId, @PathVariable("postId") int postId){
    return postDao.findOne(postId);
  }

}
