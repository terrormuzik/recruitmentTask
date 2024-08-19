package com.empik.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestCount {

  @Id
  @Column(name = "LOGIN", nullable = false)
  private String login;

  @Column(name = "REQUEST_COUNT")
  private int loginCount;

  public void incrementLoginCountByOne() {
    this.loginCount++;
  }

}
