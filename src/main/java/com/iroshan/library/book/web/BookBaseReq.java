package com.iroshan.library.book.web;

import com.iroshan.library.author.web.AuthorBaseReq;
import com.iroshan.library.publisher.web.PublisherBaseReq;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class BookBaseReq{
    private Long id;

    @NotEmpty(message = "Please provide a name")
    @NotNull
    private String name;

    @NotNull
    private Long isbn;

    private List<AuthorBaseReq> authors;

    private List<PublisherBaseReq> publishers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorBaseReq> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorBaseReq> authors) {
        this.authors = authors;
    }

    public List<PublisherBaseReq> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<PublisherBaseReq> publishers) {
        this.publishers = publishers;
    }
}
