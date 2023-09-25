package com.example.todolist.repo;

import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepo extends JpaRepository<Task, Long> {
    @Query(value = "select * from task where is_done = true", nativeQuery = true)
    Iterable<Task> getAllFav();
}
