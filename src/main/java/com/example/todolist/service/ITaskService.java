package com.example.todolist.service;

import com.example.todolist.model.Task;

import java.util.Optional;

public interface ITaskService extends IGeneralService<Task>{
    Optional<Task> done(Long id);

    Iterable<Task> getAllFav();
}
