package org.rest.webservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "All details about the user")
public class User {
  private Integer id;

  @Size(min = 2, message = "Name should have at least 2 Char")
  @ApiModelProperty(notes = "Name should have 2 char")
  private String name;

  @Past
  @ApiModelProperty(notes = "Birth date should be in the past")
  private Date birthDate;
}
