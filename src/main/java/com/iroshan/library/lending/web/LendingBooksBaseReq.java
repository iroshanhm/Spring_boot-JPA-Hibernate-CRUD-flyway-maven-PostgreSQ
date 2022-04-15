package com.iroshan.library.lending.web;

import com.iroshan.library.lending.LendingBooks;

import javax.persistence.Column;
import java.util.Set;

public class LendingBooksBaseReq {
    private long id;
    private long book_ISBN;
    private long book_tag;
    private long lending_id;

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

    public long getLending_id() {
        return lending_id;
    }

    public void setLending_id(long lending_id) {
        this.lending_id = lending_id;
    }
}
