package org.rest.webservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

  @Id
  @GeneratedValue
  private Integer id;
  private Integer userId;
  private String postTitle;
  private String postDescription;
  private Date postDate;
}
