package com.empik.repository;

import com.empik.model.UserRequestCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestCountRepository extends CrudRepository<UserRequestCount, String> {

}
