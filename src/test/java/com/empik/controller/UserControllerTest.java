package com.empik.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.empik.model.dto.GithubUserResponse;
import com.empik.service.GithubService;
import com.empik.service.UserRequestCountService;
import com.empik.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @Mock
  private GithubService githubService;

  @Mock
  private UserRequestCountService userRequestCountService;

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController uut;

  private static final String LOGIN = "some_login";
  private final static int FOLLOWERS = 4;
  private final static int PUBLIC_REPOS = 7;

  @BeforeEach
  void setUp() {
    when(githubService.getUser(LOGIN)).thenReturn(
        GithubUserResponse.builder()
            .followers(FOLLOWERS)
            .public_repos(PUBLIC_REPOS)
            .build());
  }

  @Test
  void shouldCallCounterService() {
    //given

    //when
    uut.getUser(LOGIN);

    //then
    verify(userRequestCountService).incrementRequestCount(LOGIN);
  }

  @Test
  void shouldCallGithubService() {
    //given

    //when
    uut.getUser(LOGIN);

    //then
    verify(githubService).getUser(LOGIN);
  }

  @Test
  void shouldCallUserService() {
    //given

    //when
    uut.getUser(LOGIN);

    //then
    verify(userService).runCalculations(FOLLOWERS, PUBLIC_REPOS);
  }
}