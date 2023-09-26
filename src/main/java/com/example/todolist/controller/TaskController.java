package com.example.todolist.controller;

import com.example.todolist.model.Tasks;
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
    public ResponseEntity<Iterable<Tasks>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }


    //get all tasks that are done
    @GetMapping("/is-done")
    public ResponseEntity<Iterable<Tasks>> findAllDone() {
        return ResponseEntity.ok(taskService.getAllFav());
    }


    //create new task
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Tasks tasks) {
        return ResponseEntity.ok(taskService.save(tasks));
    }


    //update task to done
    @PatchMapping("/{id}")
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
