package com.example.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class IdentityDocument extends AbstractItem{

    @Column
    private Integer type;

    @Column
    private String numberSeries;

    @Column
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Column
    private String format;

    @Column
    private String title;


    public IdentityDocument() {
    }

    public IdentityDocument(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNumberSeries() {
        return numberSeries;
    }

    public void setNumberSeries(String numberSeries) {
        this.numberSeries = numberSeries;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityDocument that = (IdentityDocument) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
