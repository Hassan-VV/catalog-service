package com.cloup.api.v1;

import com.cloup.api.mapper.BookMapper;
import com.cloup.exception.BookNotFoundException;
import com.cloup.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private BookMapper bookMapper;

    @Test
    void delete() {
    }

    @Test
    void getBook() {
    }

    @Test
    void getByIsbn_with_isbn_not_exist() throws Exception{
        String isbn = "1231231231";
        given(bookService.viewBookDetails(isbn))
                .willThrow(BookNotFoundException.class);
        mockMvc
                .perform(get("/api/v1/books/"+isbn))
                .andExpect(status().isNotFound());
    }

//    @Test
//    void post() {
//        final var expectedBook = new Book("1231231231", "Title", "Author", 9.90);
//        webTestClient
//                .post()
//                .uri("/api/v1/books")
//                .bodyValue(bookMapper.map(expectedBook))
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody(com.cloup.api.v1.resources.Book.class).value(actualBook -> {
//                   assertThat(actualBook).isNotNull();
//                   assertThat(actualBook.getIsbn())
//                           .isEqualTo(expectedBook.isbn());
//                });
//    }

    @Test
    void put() {
    }
}
