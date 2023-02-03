package com.digitalfilingcabinet.demo.models.data;

import com.digitalfilingcabinet.demo.models.UserList;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserListRepository extends CrudRepository<UserList, Integer> {


}
