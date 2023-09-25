package com.example.todolist.service;
import java.util.Optional;

public interface IGeneralService<T> {
    Optional<T> findById(Long id);

    T save(T e);

    void remove(Long id);

    Iterable<T> findAll();
}
