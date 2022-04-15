package com.iroshan.library.lending;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "lending_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "lending_id_seq"),
                    @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
                    @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lending_id_seq")
    private long id;


    @JsonManagedReference
    @OneToMany(mappedBy="lending", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<LendingBooks> lendingBooks;

    @Column(name = "member_id")
    private long member_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lending_date")
    private Date lendingDate;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;


    @Column(name = "updated_by")
    private String updatedBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "is_remove")
    @ColumnDefault("0")
    private int isRemove;

    @Column(name = "remove_by")
    private String removeBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "remove_on")
    private Date removeOn;



    public Lending() {
        this.id = id;
    }

    public Lending(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<LendingBooks> getLendingBooks() {
        return lendingBooks;
    }

    public void setLendingBooks(List<LendingBooks> lendingBooks) {
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
        return "Lending{" +
                "id=" + id +
                ", lendingBooks=" + lendingBooks +
                ", member_id=" + member_id +
                ", lendingDate=" + lendingDate +
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
