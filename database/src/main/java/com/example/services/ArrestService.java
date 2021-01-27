package com.example.services;

import com.example.entities.Arrest;

import java.util.Optional;

public interface ArrestService {
    public Optional<Arrest> findById(Long id);
}
