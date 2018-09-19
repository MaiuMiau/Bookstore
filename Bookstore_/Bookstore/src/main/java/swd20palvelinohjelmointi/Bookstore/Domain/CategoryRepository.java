package swd20palvelinohjelmointi.Bookstore.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;





public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	 List<Category> findByCateName(String cateName);

}
