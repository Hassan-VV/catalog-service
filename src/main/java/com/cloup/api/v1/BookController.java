package com.cloup.api.v1;

import com.cloup.api.mapper.BookMapper;
import com.cloup.api.v1.resources.Book;
import com.cloup.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController extends AbstractController implements BooksApi {

    private final BookMapper bookMapper;
    private final BookService bookService;

    public BookController(BookMapper bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<Void> delete(String isbn) {
        bookService.removeBookFromCatalog(isbn);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Book>> get() {
        final var books = bookService.viewBookList();
        return ResponseEntity.ok(bookMapper.map(books));
    }

    @Override
    public ResponseEntity<Book> getByIsbn(String isbn) {
        final var book = bookService.viewBookDetails(isbn);
        return ResponseEntity.ok(bookMapper.map((book)));
    }

    @Override
    public ResponseEntity<Book> post(Book book) {
        final var savedBook = bookService.addBookToCatalog(bookMapper.mapToEntity((book)));
        return ResponseEntity.status(HttpStatus.CREATED).body(bookMapper.map(savedBook));
    }

    @Override
    public ResponseEntity<Book> put(String isbn, Book book) {
        final var updatedBook = bookService.editBookDetails(isbn, bookMapper.mapToEntity(book));
        return ResponseEntity.ok().body(bookMapper.map(updatedBook));
    }
}
