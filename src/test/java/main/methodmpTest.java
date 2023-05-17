package main;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.tonyrouhana.data.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class methodmpTest {

    @Test
    void testCreateBook() {

        methodmp methodmp = new methodmp();

        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setCountry("GB");
        book.setId("42");
        book.setImageLink("Image Link");
        book.setLanguage("en");
        book.setLink("Link");
        book.setPages(1);
        book.setTitle("Dr");
        book.setYear(1);
        methodmp.createBook(book);
    }


    @Test
    void testCreateBook2() {
        methodmp methodmp = new methodmp();
        Book book = mock(Book.class);
        when(book.getPages()).thenReturn(1);
        when(book.getYear()).thenReturn(1);
        when(book.getAuthor()).thenReturn("JaneDoe");
        when(book.getCountry()).thenReturn("GB");
        when(book.getId()).thenReturn("42");
        when(book.getImageLink()).thenReturn("Image Link");
        when(book.getLanguage()).thenReturn("en");
        when(book.getLink()).thenReturn("Link");
        when(book.getTitle()).thenReturn("Dr");
        doNothing().when(book).setAuthor(Mockito.<String>any());
        doNothing().when(book).setCountry(Mockito.<String>any());
        doNothing().when(book).setId(Mockito.<String>any());
        doNothing().when(book).setImageLink(Mockito.<String>any());
        doNothing().when(book).setLanguage(Mockito.<String>any());
        doNothing().when(book).setLink(Mockito.<String>any());
        doNothing().when(book).setPages(anyInt());
        doNothing().when(book).setTitle(Mockito.<String>any());
        doNothing().when(book).setYear(anyInt());
        book.setAuthor("JaneDoe");
        book.setCountry("GB");
        book.setId("42");
        book.setImageLink("Image Link");
        book.setLanguage("en");
        book.setLink("Link");
        book.setPages(1);
        book.setTitle("Dr");
        book.setYear(1);
        methodmp.createBook(book);
        verify(book).getPages();
        verify(book).getYear();
        verify(book).getAuthor();
        verify(book).getCountry();
        verify(book).getId();
        verify(book).getImageLink();
        verify(book).getLanguage();
        verify(book).getLink();
        verify(book).getTitle();
        verify(book).setAuthor(Mockito.<String>any());
        verify(book).setCountry(Mockito.<String>any());
        verify(book).setId(Mockito.<String>any());
        verify(book).setImageLink(Mockito.<String>any());
        verify(book).setLanguage(Mockito.<String>any());
        verify(book).setLink(Mockito.<String>any());
        verify(book).setPages(anyInt());
        verify(book).setTitle(Mockito.<String>any());
        verify(book).setYear(anyInt());
    }

    /**
     * Method under test: {@link methodmp#deleteBookById(String)}
     */
    @Test
    void testDeleteBookById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new methodmp()).deleteBookById("42");
    }
}

