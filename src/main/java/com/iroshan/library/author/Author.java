//package com.iroshan.library.author;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//
//public class Author {
//}

package com.iroshan.library.author;

import com.iroshan.library.book.Book;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "author_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "author_id_seq"),
                    @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
                    @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private long id;

    @NotEmpty(message = "Please provide a author name")
    @Column(name = "author_name",unique = true, nullable=false)
    private String author_name;

    @Column(name = "author_description", nullable=false)
    private String author_description;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_description() {
        return author_description;
    }

    public void setAuthor_description(String author_description) {
        this.author_description = author_description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
