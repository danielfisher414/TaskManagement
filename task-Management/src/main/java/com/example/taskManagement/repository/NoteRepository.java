package com.example.taskManagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.taskManagement.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    // Additional custom methods can be defined here

    public Note findByName(String name);

    public List<Note> findByCategory(String category);

}
