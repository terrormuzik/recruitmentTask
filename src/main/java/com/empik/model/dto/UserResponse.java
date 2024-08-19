package com.empik.model.dto;

import java.time.Instant;

public record UserResponse(
    String id,
    String login,
    String name,
    String type,
    String avatarUrl,
    Instant createdAt,
    float calculations) {

  public UserResponse(GithubUserResponse githubUserResponse, float calculations) {
    this(githubUserResponse.id(),
        githubUserResponse.login(),
        githubUserResponse.name(),
        githubUserResponse.type(),
        githubUserResponse.avatar_url(),
        githubUserResponse.created_at(),
        calculations);
  }
}
