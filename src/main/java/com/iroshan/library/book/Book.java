package com.iroshan.library.book;

import com.iroshan.library.author.Author;
import com.iroshan.library.publisher.Publisher;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "book_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "book_id_seq"),
                    @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
                    @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    private long id;


    @Column(name = "book_isbn", unique = true, nullable=false)
    private long isbn;

    @NotEmpty(message = "Please provide a name")
    @Column(name = "book_name", unique = true, nullable=false)
    private String book_name;

    @Column(name = "book_description", nullable=false)
    private String book_description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
//            CascadeType.ALL
    })
    @JoinTable(
            name = "BOOK_AUTHOR",
            joinColumns = { @JoinColumn(name = "BOOK_ID") },
            inverseJoinColumns = { @JoinColumn(name = "AUTHOR_ID")}
    )
//    @JoinColumn(name = "id")
    private List<Author> authors;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "BOOK_PUBLISHER",
            joinColumns = { @JoinColumn(name = "BOOK_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PUBLISHER_ID")}
    )
    private List<Publisher> publishers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }


    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }
}
