package com.example.taskManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskManagement.model.Note;
import com.example.taskManagement.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    private final List<Note> notes = new ArrayList<>();

    public void deleteAllNotes() {
        noteRepository.deleteAll();
        // return true;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> getNotesByCategory(String category) {
        return noteRepository.findByCategory(category);
    }

    // public Note getNoteById(int id) {
    // // Find the note by ID and return it
    // // ...

    // for (Note note : notes) {
    // if (note.getId() == id) {
    // return note;
    // }
    // }

    // return null;
    // }

    // below is used for adding notes onto the list, this is used without a database

    // public Note createNote(Note note) {
    // // Perform validation or business logic
    // // Save the note to the database or perform other operations
    // // ...
    // notes.add(note);
    // return note;
    // }

    // save will save to the mongodb database
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }
}
