package swd20palvelinohjelmointi.Bookstore.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import swd20palvelinohjelmointi.Bookstore.Domain.Book;
import swd20palvelinohjelmointi.Bookstore.Domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	 @RequestMapping(value="/booklist")
	    public String bookList(Model model) {	
	        model.addAttribute("books", repository.findAll());// modelin kautta palauttaa listan kirjoista
	        return "booklist";
	    }
	 
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	
	    	
	        return "addbook";
	    }    
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist"; // ettei tulisi selaimen virkistyksen jälkeen tahttomia uudelleen postauksia
	    }  
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../booklist"; // .. tarkoittaa ett siirrytään urlissa
	    }    
	
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	 public String editBook(@PathVariable("id") Long bookId, Model model){
	 model.addAttribute("book", repository.findById(bookId));
	 
	 return "editbook";
	 }
	
	
	//git kokeilu kommentti
}
