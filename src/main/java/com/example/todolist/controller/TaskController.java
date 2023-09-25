package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/todos")
public class TaskController {
    @Autowired
    private ITaskService taskService;


    //get all tasks
    @GetMapping({"/",""})
    public ResponseEntity<Iterable<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }


    //get all tasks that are done
    @GetMapping("/is-done")
    public ResponseEntity<Iterable<Task>> findAllDone() {
        return ResponseEntity.ok(taskService.getAllFav());
    }


    //create new task
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }


    //update task to done
    @PutMapping("/{id}")
    public ResponseEntity<?> done(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.done(id));
    }


    //delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        taskService.remove(id);
        return ResponseEntity.ok().build();
    }
}
