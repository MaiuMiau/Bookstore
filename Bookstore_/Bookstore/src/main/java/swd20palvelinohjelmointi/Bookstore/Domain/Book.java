package swd20palvelinohjelmointi.Bookstore.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity // tästä pitää luoda tietokantaan taulu saa nimen suoraan luokasta
public class Book {
	@Id // tietokannan sarake on primary key tyyppinen
	@GeneratedValue(strategy = GenerationType.AUTO) // jos ei halua itse antaa id arvoa tämä luo ne
	private Long id;
	private String bookTitle;
	private String author;
	private long year;
	private long isbn;
	private double price;
	
	 @ManyToOne
	    @JoinColumn(name = "categoryid")
	    private Category category;

	public Book() {} 

	

	// parametrillinen konstruktori
	public Book(String bookTitle, String author, long year, long isbn, double price, Category category) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + ", year=" + year + ", isbn="
				+ isbn + ", price=" + price + ", category=" +  this.getCategory() + "]";
		else return "Book [id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + ", year=" + year + ", isbn="
		+ isbn + ", price=" + price +  "]";
	}
	

	
}
