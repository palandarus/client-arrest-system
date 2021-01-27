package com.example.services;

import com.example.entities.Arrest;
import com.example.repositories.ArrestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ArrestServiceImpl implements ArrestService{

    private ArrestRepository arrestRepository;

    public ArrestServiceImpl(ArrestRepository arrestRepository) {
        this.arrestRepository = arrestRepository;
    }

    @Override
    public Optional<Arrest> findById(Long id) {
        return Optional.empty();
    }
}
