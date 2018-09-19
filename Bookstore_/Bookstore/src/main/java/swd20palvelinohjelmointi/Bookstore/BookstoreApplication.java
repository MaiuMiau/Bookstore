package swd20palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import swd20palvelinohjelmointi.Bookstore.Domain.Book;
import swd20palvelinohjelmointi.Bookstore.Domain.BookRepository;
import swd20palvelinohjelmointi.Bookstore.Domain.Category;
import swd20palvelinohjelmointi.Bookstore.Domain.CategoryRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			crepository.save(new Category("Draama"));
			crepository.save(new Category("Seikkailu"));
			crepository.save(new Category("Ruuanlaitto"));
			
			repository.save(new Book("Tuntematon sotilas", "Väinö Linna", 1954, 97895104, 11.95, crepository.findByCateName("Draama").get(0)));
			repository.save(new Book("Kesäkirja ", "Tove Jansson",  2018, 97895189, 14.85, crepository.findByCateName("Seikkailu").get(0)));	
			repository.save(new Book("Brunon keittiössä", "Bruno Lösönen",  2009, 978679, 19.85,crepository.findByCateName("Ruuanlaitto").get(0)));
			
			log.info("fetch all students");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
