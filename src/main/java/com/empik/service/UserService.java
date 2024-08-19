package com.empik.service;

import com.empik.exception.CannotRunCalculationsException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public float runCalculations(int followers, int publicRepos) {
    if (followers == 0) {
      throw new CannotRunCalculationsException();
    }

    return (float) 6 / followers * (2 + publicRepos);
  }

}
