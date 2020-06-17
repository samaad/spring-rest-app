package org.rest.webservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "All details about the user")
public class User {
  @Id
  @GeneratedValue
  private Integer id;

  @Size(min = 2, message = "Name should have at least 2 Char")
  @ApiModelProperty(notes = "Name should have 2 char")
  private String name;

  @Past
  @ApiModelProperty(notes = "Birth date should be in the past")
  private Date birthDate;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;
}
