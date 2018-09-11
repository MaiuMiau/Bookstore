package swd20palvelinohjelmointi.Bookstore.Domain;

public class Book {
	
	private String bookTitle;
	private String author;
	private long year;
	private long isbn;
	private double price;
	
				// parametriton konstruktori, alustaa olion atribuutin arvot nulliksi ja nolliksi
				public Book(){
					super();
					
					this.bookTitle = "";
					this.author = "";
					this.year = 0;
					this.setIsbn(0);
					this.price = 0;
				}
				
				//parametrillinen konstruktori
				public Book(String nimi, String bookTitle, String author, long year, long isbn, double price){
					super();
					this.bookTitle = bookTitle;
					this.author = author;
					this.year = year;
					this.setIsbn(isbn);
					this.price = price;
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
		return "Book [bookTitle=" + bookTitle + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price="
				+ price + "]";
	}
	
	
	 
}
