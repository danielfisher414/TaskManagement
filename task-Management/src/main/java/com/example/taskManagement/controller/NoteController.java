package com.example.taskManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.taskManagement.model.Note;
import com.example.taskManagement.service.NoteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello test User";
    }

    // test
    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    // example http://localhost:8080/get/1

    // @GetMapping("/get/{id}")
    // public ResponseEntity<Note> getNoteById(@PathVariable int id) {
    // Note note = noteService.getNoteById(id);
    // if (note != null) {
    // return new ResponseEntity<>(note, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // example http://localhost:8080/get?id=1

    // @GetMapping("/get")
    // public ResponseEntity<Note> getNoteById(@RequestParam int id) {
    // Note note = noteService.getNoteById(id);
    // if (note != null) {
    // return new ResponseEntity<>(note, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllNotes() {
        noteService.deleteAllNotes();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/notes/category/{category}")
    public ResponseEntity<List<Note>> getNotesByCategory(@PathVariable String category) {
        List<Note> notes = noteService.getNotesByCategory(category);
        if (notes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(notes);
        }
    }

}
