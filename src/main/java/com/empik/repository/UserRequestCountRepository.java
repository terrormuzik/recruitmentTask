package com.empik.dao;

import com.empik.model.UserRequestCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestCountDao extends CrudRepository<UserRequestCount, String> {

}
