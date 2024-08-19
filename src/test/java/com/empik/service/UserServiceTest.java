package com.empik.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.empik.exception.CannotRunCalculationsException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserServiceTest {

  private static final UserService uut = new UserService();

  @ParameterizedTest()
  @MethodSource("provideTestData")
  void shouldRunCalculations(int followers, int publicRepos, float expectedResult) {
    //given

    //when
    float actualResult = uut.runCalculations(followers, publicRepos);

    //then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void shouldThrowException() {
    //given

    //when

    //then
    CannotRunCalculationsException exception = assertThrows(CannotRunCalculationsException.class, () -> {
      uut.runCalculations(0, 0);
    });
  }

  private static Stream<Arguments> provideTestData() {
    return Stream.of(
        Arguments.of(1, 1, 18),
        Arguments.of(2, 2, 12),
        Arguments.of(1, 2, 24),
        Arguments.of(2, 1, 9),
        Arguments.of(3, 3, 10)
    );
  }
}