package com.example.services;

import com.example.entities.Person;
import com.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> findByFirstName(String firstName) {

        return personRepository.findByFirstName(firstName);
    }

    @Override
    public List<Person> findByLastName(String lastName) {

        return personRepository.findByLastName(lastName);
    }
}
