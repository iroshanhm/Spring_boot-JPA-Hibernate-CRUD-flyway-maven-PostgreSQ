package com.iroshan.library.publisher;

import com.iroshan.library.book.Book;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="publisher")
public class Publisher {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "publisher_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "publisher_id_seq"),
                    @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
                    @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_id_seq")
    private long id;

    @NotEmpty(message = "Please provide a publisher name")
    @Column(name = "publisher_name",unique = true, nullable=false)
    private String publisher_name;

    @Column(name = "publisher_description", nullable=false)
    private String publisher_description;


    @ManyToMany(mappedBy = "publishers")
    private List<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getPublisher_description() {
        return publisher_description;
    }

    public void setPublisher_description(String publisher_description) {
        this.publisher_description = publisher_description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
