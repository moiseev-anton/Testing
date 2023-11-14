import homework04.book.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TestBookService {
    private BookRepository mockBookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp(){
        mockBookRepository = mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
    }

    @Test
    void testFindBookById() {
        when(mockBookRepository.findById("1")).thenReturn(new Book("1","Title1","Author1"));

        Book result = bookService.findBookById("1");
        assertThat(result.getId()).isEqualTo("1");
        assertThat(result.getTitle()).isEqualTo("Title1");
        assertThat(result.getAuthor()).isEqualTo("Author1");

        verify(mockBookRepository, times(1)).findById("1");
    }

    @Test
    void testFindAllBooks() {
        Book book1 = new Book("1");
        Book book2 = new Book("2");

        when(mockBookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> result = bookService.findAllBooks();
        assertThat(result).hasSize(2).contains(book1, book2);

        verify(mockBookRepository, times(1)).findAll();
    }
}
