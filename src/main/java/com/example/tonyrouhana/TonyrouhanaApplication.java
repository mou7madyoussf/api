package com.example.tonyrouhana;

import com.example.tonyrouhana.data.Book;
import main.methodmp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
@SpringBootApplication
public class TonyrouhanaApplication {


        public static void main (String[]args){
        SpringApplication.run(TonyrouhanaApplication.class, args);
        methodmp mp = new methodmp();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do

        {
        System.out.println("1. Get all books");
        System.out.println("2. Get book by ID");
        System.out.println("3. Get books by title");
        System.out.println("4. Get books by author");
        System.out.println("5. Get books sorted by title");
        System.out.println("6. Create a book");
        System.out.println("7. Delete book by ID");
        System.out.println("8. Edit book by ID");
        System.out.println("9. for quit");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                mp.getAllBooks();
                break;
            case 2:
                System.out.println("Enter the book ID:");
                String id = scanner.next();
                mp.getBookById(id);
                break;
            case 3:
                System.out.println("Enter the book title:");
                String title = scanner.nextLine();
                mp.getBooksByTitle(title);
                break;
            case 4:
                System.out.println("Enter the author name:");
                String author = scanner.nextLine();
                mp.getBooksByAuther(author);
                break;
            case 5:
                mp.getBooksBysorted();
                break;
            case 6:
           System.out.println("Enter the book details:");

            System.out.println("Author:");
            String auuthor = scanner.nextLine();
            System.out.println("Country:");
            String country = scanner.nextLine();
            System.out.println("Image Link:");
            String imageLink = scanner.nextLine();
            System.out.println("Language:");
            String language = scanner.nextLine();
            System.out.println("Link:");
            String link = scanner.nextLine();
            System.out.println("Pages:");
            int pages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Title:");
            String ttitle = scanner.nextLine();
            System.out.println("Year:");
            int year = scanner.nextInt();
            scanner.nextLine();

            Book newBook = new Book( auuthor, country, imageLink, language, link, pages, ttitle, year);
            mp.createBook(newBook);
            break;
            case 7:
                System.out.println("Enter the book ID to delete:");
                String deleteId = scanner.next();
                mp.deleteBookById(deleteId);
                break;
            case 8:
                System.out.println("Enter the book ID to edit:");
                String editId = scanner.nextLine();
                System.out.println("Enter the updated book details:");
                System.out.println("Title:");
                String updatedTitle = scanner.nextLine();
                System.out.println("Author:");
                String updatedAuthor = scanner.nextLine();
                System.out.println("Pages:");
                int updatedPages = scanner.nextInt();
                Book updatedBook = new Book(updatedTitle, updatedAuthor, updatedPages);
                mp.editBookById(editId, updatedBook);
                break;

            case 9:
                // Exit the loop when choice is 9
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    } while (choice != 9);

        scanner.close();
            scanner.close();
            System.out.println("Quit the program");
    }
}




