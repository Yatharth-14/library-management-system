package entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int  quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void showDetails() {
        System.out.println("Title: " + title + ", Author: " + author +
                           ", ISBN: " + isbn + ", Quantity: " + quantity);
    }
}
