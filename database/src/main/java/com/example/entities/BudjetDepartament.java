package com.example.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class BudjetDepartament extends AbstractItem{

    @Column
    private String title;

    @Column(unique = true)
    private Integer code;

    @ManyToMany
    private List<IdentityDocument> identityDocuments = new ArrayList<>();

    public BudjetDepartament() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }
}
