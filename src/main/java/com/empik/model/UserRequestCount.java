package com.empik.model.dto;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class UserRequestCount {
  private String login;
  private int loginCount;
}
