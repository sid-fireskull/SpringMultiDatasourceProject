package com.multi.datasource.repository.dbSecond;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.datasource.model.dbSecond.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
