package com.example.todolist.service;

import com.example.todolist.model.Tasks;

import java.util.Optional;

public interface ITaskService extends IGeneralService<Tasks>{
    Optional<Tasks> done(Long id);

    Iterable<Tasks> getAllFav();
}
