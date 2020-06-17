package org.rest.webservice.exception;

import lombok.*;

import java.util.Date;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;
}
