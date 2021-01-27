package com.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Arrest extends AbstractItem {

    @Column
    private Date docDate;

    @Column(length = 30)
    private String docNum;

    @Column(length = 1000)
    private String purpose;

    @Column
    private Long amount;

    @Column
    private String refDocNum;

    @Column
    private Integer operation;

    @Column
    private String status;

    @ManyToOne
    private BudjetDepartament budjetDepartament;

    public Arrest() {
    }

    public Arrest(Date docDate, String docNum, String purpose, Long amount, String refDocNum, Integer operation, String status, BudjetDepartament budjetDepartament) {
        this.docDate = docDate;
        this.docNum = docNum;
        this.purpose = purpose;
        this.amount = amount;
        this.refDocNum = refDocNum;
        this.operation = operation;
        this.status = status;
        this.budjetDepartament = budjetDepartament;
    }

    public Arrest(Date docDate, String docNum, String purpose, Long amount, String refDocNum, Integer operation) {
        this.docDate = docDate;
        this.docNum = docNum;
        this.purpose = purpose;
        this.amount = amount;
        this.refDocNum = refDocNum;
        this.operation = operation;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRefDocNum() {
        return refDocNum;
    }

    public void setRefDocNum(String refDocNum) {
        this.refDocNum = refDocNum;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BudjetDepartament getBudjetDepartament() {
        return budjetDepartament;
    }

    public void setBudjetDepartament(BudjetDepartament budjetDepartament) {
        this.budjetDepartament = budjetDepartament;
    }
}
