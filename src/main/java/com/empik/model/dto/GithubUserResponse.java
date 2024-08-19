package com.empik.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubUserResponse(
    String id,
    String login,
    String name,
    String type,
    String avatar_url,
    int public_repos,
    int followers,
    Instant created_at) {}
