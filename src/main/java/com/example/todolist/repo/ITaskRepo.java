package com.example.todolist.repo;

import com.example.todolist.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepo extends JpaRepository<Tasks, Long> {

//    @Query(value = "select * from tasks where is_done=false", nativeQuery = true)
//    List<Tasks> findAll();

    @Query(value = "select * from tasks where is_done = true", nativeQuery = true)
    Iterable<Tasks> getAllFav();
}
