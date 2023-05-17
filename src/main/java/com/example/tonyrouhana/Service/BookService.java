package com.example.tonyrouhana.Service;

import com.example.tonyrouhana.EXCEPTION.BookNotFoundException;
import com.example.tonyrouhana.Repository.BookRepository;
import com.example.tonyrouhana.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(String id) {return bookRepository.findById(id);}
    public Book saveBook(Book book) {return bookRepository.save(book);}
    public boolean deleteBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return true;
        } else {
            return false;
        }
    }
    public BookService(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    public void updateBook(String id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();


            if (updatedBook.getTitle() != null) {
                book.setTitle(updatedBook.getTitle());
            }

            if (updatedBook.getAuthor() != null) {
                book.setAuthor(updatedBook.getAuthor());
            }

            if (updatedBook.getCountry() != null) {
                book.setCountry(updatedBook.getCountry());
            }

            if (updatedBook.getImageLink() != null) {
                book.setImageLink(updatedBook.getImageLink());
            }

            if (updatedBook.getLanguage() != null) {
                book.setLanguage(updatedBook.getLanguage());
            }

            if (updatedBook.getLink() != null) {
                book.setLink(updatedBook.getLink());
            }

            if (updatedBook.getPages() != 0) {
                book.setPages(updatedBook.getPages());
            }

            if (updatedBook.getYear() != 0) {
                book.setYear(updatedBook.getYear());
            }

            bookRepository.save(book);
        } else {
            throw new BookNotFoundException("Book not found with id " + id);
        }
    }
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    public List<Book> getBooksByAuthor(String author) {return bookRepository.findByAuthor(author);}
}
