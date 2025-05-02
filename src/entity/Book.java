package entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int  quantity;
    private double rating;

    public Book(String title, String author, String isbn, int quantity, double rating) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
        this.rating=rating;
    }

    // public Book(String title2, String author2, String isbn2, String publisher2) {
    //     //TODO Auto-generated constructor stub
    // }

    public String getTitle() {
        return title;
    }


    public void increaseQuantity(int quantity) {
        this.quantity = quantity+1;
    }


    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getRating() {
        return rating;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private String issuedTo = null; // userId of the person who issued the book

public String getIssuedTo() {
    return issuedTo;
}

public void setIssuedTo(String issuedTo) {
    this.issuedTo = issuedTo;
}


public void showDetails() {
    System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn
             + ", Quantity: " + quantity + ", Rating: " + rating +
            (issuedTo != null ? ", Issued To: " + issuedTo : ""));
}

}
