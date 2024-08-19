package com.empik.service;

import com.empik.repository.UserRequestCountRepository;
import com.empik.model.UserRequestCount;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserRequestCountService {

  private final UserRequestCountRepository userRequestCountRepository;

  @Transactional
  public void incrementRequestCount(String login) {
    Optional<UserRequestCount> count = userRequestCountRepository.findById(login);

    count.ifPresentOrElse(userRequestCount -> {
          userRequestCount.incrementLoginCountByOne();
          log.info("User request counter incremented to {} for login: {}",
              userRequestCount.getLoginCount(),
              login);
          userRequestCountRepository.save(userRequestCount);
        },
        () -> {
          log.info("User request counter created for user: {}", login);
          userRequestCountRepository.save(new UserRequestCount(login, 1));
        });

  }

}
