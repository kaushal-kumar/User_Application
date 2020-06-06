package com.userservice.repository;

import com.userservice.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,String> {
    UserModel findByName(final String name);
    UserModel findByPhn(final String phn);
}
