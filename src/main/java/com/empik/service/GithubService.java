package com.empik.service;

import com.empik.model.dto.GithubUserResponse;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class GithubService {

  private final RestTemplate restTemplate;
  private Environment env;

  public GithubUserResponse getUser(String userLogin) {
    return Objects.requireNonNull(restTemplate.getForObject(
        env.getProperty("github.getUser.url") + userLogin, GithubUserResponse.class));
  }
}
