package com.example.todolist.service.impl;

import com.example.todolist.model.Task;
import com.example.todolist.repo.ITaskRepo;
import com.example.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepo taskRepo;

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepo.findById(id);
    }

    @Override
    public Task save(Task e) {
        return taskRepo.save(e);
    }

    @Override
    public void remove(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> done(Long id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDone(!task.isDone());
            taskRepo.save(task);
            return Optional.of(task);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Task> getAllFav() {
        return taskRepo.getAllFav();
    }
}
