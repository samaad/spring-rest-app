package org.rest.webservice.dao;

import org.rest.webservice.model.Post;
import org.rest.webservice.model.User;
import org.rest.webservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostDao {

  @Autowired
  PostRepository postsRepository;
  @Autowired
  UserJpaDao userJpaDao;

  public List<Post> findAll() {
    return postsRepository.findAll();
  }

  public Post save(Post post, int userId){
    Optional<User> users = userJpaDao.findOne(userId);
    if(users.get() == null){
      return null;
    }
    User user = users.get();
    post.setUser(user);
    postsRepository.save(post);
    return post;
  }

  public List<Post> findByUserId(int userId) {
    Optional<User> users = userJpaDao.findOne(userId);
    List<Post> postlist = new ArrayList<>();
    postlist = users.map(User::getPosts).orElse(postlist);
    return postlist;
  }

  public Post findOne(int useId, int postid) {
    Optional<Post> post = postsRepository.findById(postid);
    return post.map(Optional::of).orElse(null).get();

  }

}
