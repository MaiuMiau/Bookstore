package swd20palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import swd20palvelinohjelmointi.Bookstore.Domain.Category;
import swd20palvelinohjelmointi.Bookstore.Domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository caterepository;
	
	@Test
	public void createNewCategory() {
		
		Category category = new Category("Science");
		caterepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void shouldFindCategoryesIfRepositoryNotempty() {
		List<Category> categoryes = caterepository.findAll();
		assertThat(categoryes).isNotEmpty();
	}
	
	@Test
	public void canDeleteAllCategoryes() {
		caterepository.deleteAll();
		assertThat(caterepository.findAll()).isEmpty();
	}
	
	@Test
	public void categoryCanBeDeleted() {

		Category category = new Category("Science");
		caterepository.save(category);
		
		Long id = category.getCategoryid();
		
		caterepository.deleteById(id);
		Optional<Category> deletedCategory = caterepository.findById(id);
		
		assertThat(deletedCategory).isEmpty();
	}
	
	@Test
    public void canFindCategoryByName() {
		Category category = new Category("Science");
		caterepository.save(category);
		List<Category> categoryes = caterepository.findByCateName("Science");
       
        assertThat(categoryes).hasSize(1);
    }

}
