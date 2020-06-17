package org.rest.webservice.dao;

import org.rest.webservice.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostDao {
  private static List<Post> posts = new ArrayList<>();
  private static int COUNTER = 3;
  static {
    posts.add(new Post(1,1,"Adam", "",new Date()));
    posts.add(new Post(2,1,"Adam", "",new Date()));
    posts.add(new Post(3,2,"Eve", "",new Date()));
    posts.add(new Post(3,3,"Jack", "",new Date()));
    posts.add(new Post(3,3,"Jack", "",new Date()));
  }

  public List<Post> findAll() {
    return posts;
  }

  public Post save(Post post){
    if(post.getId() == null){
      post.setId(++COUNTER);
    }
    posts.add(post);
    return post;
  }

  public List<Post> findByUserId(int userId) {
    List<Post> postlist = new ArrayList<>();
    for(Post post: posts){
      if(post.getUserId() == userId){
        postlist.add(post);
      }
    }
    return postlist;
  }

  public Post findOne(int postid) {
    for(Post post: posts){
      if(post.getId() == postid){
        return post;
      }
    }
    return null;
  }

}
