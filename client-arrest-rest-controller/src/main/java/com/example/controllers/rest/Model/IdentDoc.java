package com.example.controllers.rest.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IdentDoc {

    private Integer type;
    private String numberSeries;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;

    public IdentDoc() {
    }

    public IdentDoc(Integer type, String numberSeries, Date issueDate) {
        this.type = type;
        this.numberSeries = numberSeries;
        this.issueDate = issueDate;
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
}
