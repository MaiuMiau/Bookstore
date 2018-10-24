package swd20palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20palvelinohjelmointi.Bookstore.WebController.BookController;



/**
 * Testing that your Bookcontroller is created
 * 
 * @author Maiju
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired// alusta luo olion. ilman autowirea olio on null
    private BookController controller; 

	@Test// tarkistaa ettei controller ole null
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull(); //import static org.assertj.core.api.Assertions.assertThat;
    }	// kun importoidaan static muodossa voidaan metodeja käyttää

	
	
}
