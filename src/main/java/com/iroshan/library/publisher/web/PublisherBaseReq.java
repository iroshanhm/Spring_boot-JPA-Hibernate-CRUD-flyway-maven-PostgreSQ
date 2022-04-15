package com.iroshan.library.publisher.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PublisherBaseReq {
    private Long id;

    @NotEmpty(message = "Please provide a name")
    @NotNull
    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
