package com.multi.datasource.repository.dbFirst;

import org.springframework.data.repository.CrudRepository;

import com.multi.datasource.model.dbFirst.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
