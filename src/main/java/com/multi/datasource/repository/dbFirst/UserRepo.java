package com.multi.datasource.repository.dbFirst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.multi.datasource.model.dbFirst.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
