package swd20palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20palvelinohjelmointi.Bookstore.Domain.Book;
import swd20palvelinohjelmointi.Bookstore.Domain.BookRepository;
import swd20palvelinohjelmointi.Bookstore.Domain.Category;
import swd20palvelinohjelmointi.Bookstore.Domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest

public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository caterepository;


	@Test
	public void createNewBook() {

		Book book = new Book("Maameren tarinat", "Ursula LeQuin", 1987, 567890543, 16.95, new Category("Fantasy"));
		repository.save(book);
		System.out.println(  "TÄÄLLÄÄ MAAAMEREN TARINAT" +book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void shouldFindBooksIfRepositoryNotempty() {
		List<Book> books = repository.findAll();
		assertThat(books).isNotEmpty();
	}
	
	

	@Test
	public void canDeleteAllBooks() {
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}

	
	@Test
	public void bookCanBeDeleted() {

		Book book = new Book("Maameren tarinat", "Ursula LeQuin", 1987, 567890543, 16.95, new Category("Fantasy"));
		repository.save(book);
		
		Long id = book.getId();
		
		repository.deleteById(id);
		Optional<Book> newbook = repository.findById(id);
		
		assertThat(newbook).isEmpty();
	}
	
	@Test
	public void canFinfBookByTitle() {
		// toimii kun bookTitle otetaan kirjalta joka luodaan jo CommandLineRunnerilla
		//ei toimi jos luodaan ensin uusi kirja. Valittaa categorysta. Katso alempi testi.
		
		List<Book> books = repository.findByBookTitle("Tuntematon sotilas");
		
		assertThat(books).isNotEmpty();
	}
	
	/*@Test
    public void canFindByTitle() {
		Book book = new Book("Maameren tarinat", "Ursula LeQuin", 1987, 567890543, 16.95, new Category("Fantasy"));
		repository.save(book);
        List<Book> books = repository.findByBookTitle("Maameren tarinat");
       
        assertThat(books).hasSize(1);
    }*/

}
