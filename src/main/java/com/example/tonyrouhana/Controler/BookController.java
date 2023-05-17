package com.example.tonyrouhana.Controler;



import com.example.tonyrouhana.EXCEPTION.BookNotFoundException;
import com.example.tonyrouhana.Repository.BookRepository;
import com.example.tonyrouhana.Service.BookService;
import com.example.tonyrouhana.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
private  BookRepository bookRepository;
    //done
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    //done
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
    //done
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    //done
    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id) {
        boolean deleted = bookService.deleteBookById(id);
        if (deleted) {
            return ResponseEntity.ok("Book with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable String id, @RequestBody Book book) {
                try {
                    bookService.updateBook(id, book);
                    return ResponseEntity.ok().body(book);
                } catch (BookNotFoundException e) {
                    return ResponseEntity.notFound().build();
                }
            }
    //done
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBooksByTitle(title);
        if (!books.isEmpty()) {
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //done
    @GetMapping("/book/author")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@RequestParam String authorName) {
        List<Book> books = bookService.getBooksByAuthor(authorName);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(books);
        }
    }
    //done
    @GetMapping("/books/sort")
    public ResponseEntity<List<Book>> getBookSortedByTitle (@RequestParam(required = false, defaultValue = "title") String sort) {


        List<Book> books = bookRepository.findAll(Sort.by(sort));
        return ResponseEntity.ok().body(books);
    }
    @GetMapping("/page")
    public Page<Book> listbookpage(Pageable p){
        return  bookRepository.findAll(p);
    }
}
