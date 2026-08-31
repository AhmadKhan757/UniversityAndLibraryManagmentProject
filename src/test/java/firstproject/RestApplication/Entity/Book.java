package firstproject.RestApplication.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {


    @OneToMany(mappedBy = "book")
    private List<BorrowRecord> borrowRecord = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
    )
    private Long id;

    @Column(
            name = "title",
            nullable = false
    )
    String title;
    @Column(
            name = "author",
            nullable = false
    )
    String author;
    @Column(
            name = "publisher",
            nullable = false
    )
    String publisher;

    @Column(
            name = "catagory",
            nullable = false
    )
    String category;

    @Column(
            name = "totalCopies",
            nullable = false
    )
    private int totalCopies;

    @Column(
            name = "available copies",
            nullable = false
    )
    private int availableCopies;

    public Book(Long id, String title, String author,
                String publisher, String category,
                int totalCopies,int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Book() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public int getTotalCopies() {return totalCopies;}

    public int getAvailableCopies() {return availableCopies;}



    public void setId(Long id) {this.id = id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
