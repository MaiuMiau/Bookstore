package swd20palvelinohjelmointi.Bookstore.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	 List<Category> findByCateName(@Param(value="cateName")String cateName);

	 //http://localhost:8080/api/categories/search/findByCateName?catename=Draama
	  
}
