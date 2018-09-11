package swd20palvelinohjelmointi.Bookstore.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;





public interface BookRepository extends CrudRepository <Book, Long> {
	
	List<Book> findByBookTitle(String bookTitle);
}
