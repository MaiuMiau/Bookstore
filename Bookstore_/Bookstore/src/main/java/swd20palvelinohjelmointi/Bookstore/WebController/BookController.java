package swd20palvelinohjelmointi.Bookstore.WebController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20palvelinohjelmointi.Bookstore.Domain.Book;
import swd20palvelinohjelmointi.Bookstore.Domain.BookRepository;
import swd20palvelinohjelmointi.Bookstore.Domain.CategoryRepository;

@Controller
public class BookController {
	
	/**  tuodaan bookRepository controllerin käyttöön**/
	@Autowired
	private BookRepository bookRepository;
	/**  tuodaan categoryRepository controllerin käyttöön**/
	@Autowired
	private CategoryRepository categoryRepository;
	
	/** login form **/
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	/** returns a list of books **/
	 @RequestMapping(value="/booklist")
	    public String bookList(Model model) {	
	        model.addAttribute("books", bookRepository.findAll());
	        return "booklist";
	    }
	 
	 /** RESTful service to get all books **/
	    @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> studentListRest() {	
	        return (List<Book>) bookRepository.findAll();
	    } 
	    
	  /** RESTful service to get book by id **/
	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	return bookRepository.findById(bookId);
	    }  
	    
	    /** RESTful service to add book **/
	    @RequestMapping(value="/books", method =  RequestMethod.POST )// REST metodi joka lisää JSONnina saadun kirjan tietokantaan.ur
	    public @ResponseBody Book saveNewBook(@RequestBody Book book){
	    	bookRepository.save(book);
	    	return book;
	    }
	    
	 /** returns a empty form for adding books **/
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categoryes", categoryRepository.findAll());
	    	
	        return "addbook";
	    }    
	 /** saves the book that was posted from the bookform **/
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        bookRepository.save(book);
	        return "redirect:booklist"; // ettei tulisi selaimen virkistyksen jälkeen tahttomia uudelleen postauksia
	    }  
	 /** daletes a book based on id **/
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	bookRepository.deleteById(bookId);
	        return "redirect:../booklist"; 
	    }    
	 /** edits a book based on id **/
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	 public String editBook(@PathVariable("id") Long bookId, Model model){
	 model.addAttribute("book", bookRepository.findById(bookId));
	 model.addAttribute("categoryes", categoryRepository.findAll());
	
	 return "editbook";
	 }
	
	
	
}
