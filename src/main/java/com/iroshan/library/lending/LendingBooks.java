package com.iroshan.library.lending;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "lending_book")
public class LendingBooks {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "lending_book_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "lending_book_id_seq"),
                    @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
                    @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lending_book_id_seq")
    private long id;

    @Column(name = "book_ISBN")
    private long book_ISBN;

    @Column(name = "book_tag")
    private long book_tag;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lending_id", nullable=false)
    private Lending lending;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBook_ISBN() {
        return book_ISBN;
    }

    public void setBook_ISBN(long book_ISBN) {
        this.book_ISBN = book_ISBN;
    }

    public long getBook_tag() {
        return book_tag;
    }

    public void setBook_tag(long book_tag) {
        this.book_tag = book_tag;
    }

    public Lending getLending() {
        return lending;
    }

    public void setLending(Lending lending) {
        this.lending = lending;
    }



}
