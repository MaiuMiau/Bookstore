package swd20palvelinohjelmointi.Bookstore.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	
	/** returns a list of books **/
	 @RequestMapping(value="/booklist")
	    public String bookList(Model model) {	
	        model.addAttribute("books", bookRepository.findAll());
	        return "booklist";
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
