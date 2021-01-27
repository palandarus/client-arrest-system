package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Person extends AbstractItem {

    @Column(name = "lastname", unique = true, length = 100)
    private String lastName;

    @Column(name = "firstname", unique = true, length = 100)
    private String firstName;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "placeofbirth", length = 250)
    private String placeOfBirth;

    @ManyToMany
    @JoinTable(
            name = "users_arrests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "arrest_id"))
    private Collection<Arrest> arrests = new ArrayList<>();

    @OneToMany
    private Collection<IdentityDocument> IdentDocList=new ArrayList<>();


    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Collection<Arrest> getArrests() {
        return arrests;
    }

    public void setArrests(Collection<Arrest> arrests) {
        this.arrests = arrests;
    }

    public Collection<IdentityDocument> getIdentDocList() {
        return IdentDocList;
    }

    public void setIdentDocList(Collection<IdentityDocument> identDocList) {
        IdentDocList = identDocList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return lastName.equals(person.lastName) &&
                firstName.equals(person.firstName) &&
                IdentDocList.equals(person.IdentDocList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
