package com.multi.datasource.repository.dbSecond;

import org.springframework.data.repository.CrudRepository;

import com.multi.datasource.model.dbSecond.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{

}
