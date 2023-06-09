package com.example.tonyrouhana.Repository;

import com.example.tonyrouhana.data.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

        List<Book> findByTitle(String title);
        List<Book> findByAuthor(String author);

}