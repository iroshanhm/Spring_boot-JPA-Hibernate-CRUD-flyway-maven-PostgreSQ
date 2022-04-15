package com.iroshan.library.returnbook.web;

import com.iroshan.library.lending.Lending;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


public class ReturnBookBaseReq {
    private long id;
    private long lending_id;
    private Date returnDate;
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

    public long getLending_id() {
        return lending_id;
    }

    public void setLending_id(long lending_id) {
        this.lending_id = lending_id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
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

    public Date getRemoveOn() {
        return removeOn;
    }

    public void setRemoveOn(Date removeOn) {
        this.removeOn = removeOn;
    }

    @Override
    public String toString() {
        return "ReturnBookBaseReq{" +
                "id=" + id +
                ", lending_id=" + lending_id +
                ", returnDate=" + returnDate +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedOn=" + updatedOn +
                ", isRemove=" + isRemove +
                ", removeBy='" + removeBy + '\'' +
                ", removeOn=" + removeOn +
                '}';
    }
}
