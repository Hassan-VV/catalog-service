package com.cloup.data.repository;

import com.cloup.config.DataConfig;
import com.cloup.data.entities.Book;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;


@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findByIsbn() {
        final var isbn = "1234561235";
        final var book = Book.of(isbn, "Spring Security", "Lonsh goash", 11.9);
        jdbcAggregateTemplate.insert(book);
        final var actualBook = bookRepository.findByIsbn(isbn);
        assertThat(actualBook).isPresent();
        assertThat(actualBook.get().isbn()).isEqualTo(isbn);
    }

    @Test
    void existsByIsbn() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteByIsbn() {
    }
}
