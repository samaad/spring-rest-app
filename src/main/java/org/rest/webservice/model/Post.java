package org.rest.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;
}
