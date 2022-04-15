package com.iroshan.library.lending.web;

import com.iroshan.library.lending.LendingBooks;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class LendingBaseReq {
//    private Long id;

//    @NotEmpty(message = "Please provide a name")
//    @NotNull
//    private String name;
    private long id;
    private Set<LendingBooksBaseReq> lendingBooks;
    private long member_id;
    private Date lendingDate;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
    private int isRemove;
    private String removeBy;
    private Date removeOn;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<LendingBooksBaseReq> getLendingBooks() {
        return lendingBooks;
    }

    public void setLendingBooks(Set<LendingBooksBaseReq> lendingBooks) {
        this.lendingBooks = lendingBooks;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public Date getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(Date lendingDate) {
        this.lendingDate = lendingDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(int isRemove) {
        this.isRemove = isRemove;
    }

    public String getRemoveBy() {
        return removeBy;
    }

    public void setRemoveBy(String removeBy) {
        this.removeBy = removeBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Date getRemoveOn() {
        return removeOn;
    }

    public void setRemoveOn(Date removeOn) {
        this.removeOn = removeOn;
    }
}
