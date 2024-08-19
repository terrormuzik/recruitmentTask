package com.empik.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.empik.model.UserRequestCount;
import com.empik.repository.UserRequestCountRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRequestCountServiceTest {

  @Mock
  private UserRequestCountRepository userRequestCountRepository;

  @InjectMocks
  private UserRequestCountService uut;

  @Captor
  private ArgumentCaptor<UserRequestCount> captor;

  private static final String LOGIN = "some_login";

  @Test
  void shouldIncrementCounter() {
    //given
    int count = 5;
    UserRequestCount counter = new UserRequestCount(LOGIN, count);
    when(userRequestCountRepository.findById(LOGIN)).thenReturn(Optional.of(counter));

    //when
    uut.incrementRequestCount(LOGIN);

    //then
    verify(userRequestCountRepository).save(captor.capture());
    assertEquals(LOGIN, captor.getValue().getLogin());
    assertEquals(count + 1, captor.getValue().getLoginCount());
  }

  @Test
  void shouldCreateCounter() {
    //given
    when(userRequestCountRepository.findById(LOGIN)).thenReturn(Optional.empty());

    //when
    uut.incrementRequestCount(LOGIN);

    //then
    verify(userRequestCountRepository).save(captor.capture());
    assertEquals(LOGIN, captor.getValue().getLogin());
    assertEquals(1, captor.getValue().getLoginCount());
  }
}