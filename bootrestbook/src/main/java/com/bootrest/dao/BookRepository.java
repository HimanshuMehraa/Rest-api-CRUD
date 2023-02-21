package com.bootrest.dao;

import org.springframework.data.repository.CrudRepository;


import com.bootrest.entities.Book;


public interface BookRepository extends CrudRepository<Book,Integer> {
   public Book findById(int id);
}
