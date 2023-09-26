package com.example.todolist.service.impl;

import com.example.todolist.model.Tasks;
import com.example.todolist.repo.ITaskRepo;
import com.example.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepo taskRepo;

    @Override
    public Optional<Tasks> findById(Long id) {
        return taskRepo.findById(id);
    }

    @Override
    public Tasks save(Tasks e) {
        return taskRepo.save(e);
    }

    @Override
    public void remove(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Iterable<Tasks> findAll() {
        List<Tasks> tasks = taskRepo.findAll();
        if (tasks.isEmpty()) {
            return null;
        }
        return tasks;
    }

    @Override
    public Optional<Tasks> done(Long id) {
        Optional<Tasks> optionalTask = taskRepo.findById(id);
        if (optionalTask.isPresent()) {
            Tasks tasks = optionalTask.get();
            tasks.setDone(!tasks.isDone());
            taskRepo.save(tasks);
            return Optional.of(tasks);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Tasks> getAllFav() {
        return taskRepo.getAllFav();
    }
}
