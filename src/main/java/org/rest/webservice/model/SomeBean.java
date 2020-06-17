package org.rest.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"field3","field2"})
public class SomeBean {
  private String field1;
  private String field2;
  @JsonIgnore
  private String field3;
  private String field4;
}
