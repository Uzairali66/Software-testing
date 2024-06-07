package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        IBookRepository bookRepository = new BookRepository(); // Replace with your actual implementation
        bookService = new BookService(bookRepository);
    }

    // ** findBooksByAuthor Tests **

    @Test
    public void testFindBooksByAuthor_ValidAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testFindBooksByAuthor_AuthorNotFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthor_EmptyAuthor() {
        List<Book> books = bookService.getBooksByAuthor("");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthor_NullAuthor() {
        List<Book> books = bookService.getBooksByAuthor(null);
        Assertions.assertEquals(0, books.size());
    }

    // ** findBooksByTitle Tests **

    @Test
    public void testFindBooksByTitle_ValidTitle() {
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testFindBooksByTitle_TitleNotFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByTitle_EmptyTitle() {
        List<Book> books = bookService.getBooksByTitle("");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByTitle_NullTitle() {
        List<Book> books = bookService.getBooksByTitle(null);
        Assertions.assertEquals(0, books.size());
    }

    // ** findBooksByAuthorAndTitle Tests **

    @Test
    public void testFindBooksByAuthorAndTitle_ValidAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testFindBooksByAuthorAndTitle_AuthorAndTitleNotFound() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthorAndTitle_ValidAuthor_TitleNotFound() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthorAndTitle_AuthorNotFound_ValidTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Clean Code");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthorAndTitle_NullAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle(null, null);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthorAndTitle_ValidAuthor_NullTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", null);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testFindBooksByAuthorAndTitle_NullAuthor_ValidTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle(null, "Clean Code");
        Assertions.assertEquals(0, books.size());
    }
}
