package swd20palvelinohjelmointi.Bookstore.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	public Book() {} //ei voi laittaa jos on parametriton konsturktori, esimerkeissä ei sitä ole

	// parametriton konstruktori, alustaa olion atribuutin arvot nulliksi ja
	// nolliksi
	
	/*public Book() {
		super();

		this.bookTitle = "";
		this.author = "";
		this.year = 0;
		this.isbn = 0;
		this.price = 0;
	}*/

	// parametrillinen konstruktori
	public Book(String bookTitle, String author, long year, long isbn, double price) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + ", year=" + year + ", isbn="
				+ isbn + ", price=" + price + "]";
	}

}
