package main;

import com.example.tonyrouhana.data.Book;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class methodmp implements method {
    public   void getAllBooks() {
        try {
            String apiUrl =  "http://localhost:8080/api/books";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Book[] books = objectMapper.readValue(responseJson, Book[].class);
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author : " + book.getAuthor());
                System.out.println("pages : " + book.getPages());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void getBookById(String id) {
        try {
            String apiUrl = "http://localhost:8080/api/books/" + id;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Book book = objectMapper.readValue(responseJson, Book.class);
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Pages: " + book.getPages());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void getBooksByTitle(String title) {
        try {
            String formattedAuthor = title.replace(" ", "%20");
            String apiUrl = "http://localhost:8080/api/title/" + formattedAuthor;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Book[] books = objectMapper.readValue(responseJson, Book[].class);
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Pages: " + book.getPages());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void getBooksByAuther(String name){
        try {
            String formattedAuthor = name.replace(" ", "%20");
            String apiUrl = "http://localhost:8080/api/book/author?authorName=" + formattedAuthor;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Book[] books = objectMapper.readValue(responseJson, Book[].class);
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Pages: " + book.getPages());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void getBooksBysorted(){
    try {
        String apiUrl = "http://localhost:8080/api/books/sort?sort=title" ;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
        reader.close();
        String responseJson = responseBuilder.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Book[] books = objectMapper.readValue(responseJson, Book[].class);
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Pages: " + book.getPages());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public  void createBook(Book book) {
        try {
            String apiUrl = "http://localhost:8080/api/books";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            ObjectMapper objectMapper = new ObjectMapper();
            String requestJson = objectMapper.writeValueAsString(book);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestJson.getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Book created successfully");
            } else {
                System.out.println("Failed to create book.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void deleteBookById(String id) {
        try {
            String apiUrl = "http://localhost:8080/api/books/" + id;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                System.out.println("Book with ID " + id + " deleted successfully");
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Book with ID " + id + " not found");
            } else {
                System.out.println("Failed to delete book. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void editBookById(String id, Book updatedBook) {
        try {
            String apiUrl = "http://localhost:8080/api/" + id;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestJson = objectMapper.writeValueAsString(updatedBook);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestJson.getBytes());
            outputStream.flush();
            outputStream.close();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Book with ID " + id + " updated successfully");
            } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println("Book with ID " + id + " not found");
            } else {
                System.out.println("Failed to update book. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
