package com.empik.controller;

import com.empik.model.dto.GithubUserResponse;
import com.empik.model.dto.UserResponse;
import com.empik.service.GithubService;
import com.empik.service.UserRequestCountService;
import com.empik.service.UserCalculationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@Slf4j
@AllArgsConstructor
public class UserController {

  private final GithubService githubService;
  private final UserRequestCountService userRequestCountService;
  private final UserCalculationService userCalculationService;

  @GetMapping(value = "/{userLogin}")
  public UserResponse getUser(@PathVariable String userLogin) {
    log.info("[GET] getUser endpoint called with param: {}", userLogin);
    userRequestCountService.incrementRequestCount(userLogin);
    GithubUserResponse githubUserResponse = githubService.getUser(userLogin);
    float calculations = userCalculationService.runCalculations(githubUserResponse.followers(),
        githubUserResponse.public_repos());
    return new UserResponse(githubUserResponse, calculations);
  }
}
