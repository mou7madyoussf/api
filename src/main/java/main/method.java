package main;

import com.example.tonyrouhana.data.Book;

public interface method {
    public  void getAllBooks() ;
    public void getBookById(String id);
    public  void getBooksByTitle(String title);
    public  void getBooksBysorted();
    public  void createBook(Book book);
    public  void deleteBookById(String id);
    public  void getBooksByAuther(String name);
    public  void editBookById(String id, Book updatedBook);
}
