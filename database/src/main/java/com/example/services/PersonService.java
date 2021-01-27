package com.example.services;

import com.example.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    public Optional<Person> findById(Long id);

    public void deleteById(Long id);

    public List<Person> findByFirstName(String firstName);

    public List<Person> findByLastName(String lastName);


}
