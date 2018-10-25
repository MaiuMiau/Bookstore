package swd20palvelinohjelmointi.Bookstore.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;




@RepositoryRestResource
public interface BookRepository extends CrudRepository <Book, Long> {
	//List<Book> findAll();
	List<Book> findByBookTitle( @Param(value="bookTitle") String bookTitle);
	
	//esimerkiksi http://localhost:8080/api/books/search/findByBookTitle?bookTitle=Tuntematon sotilas

}