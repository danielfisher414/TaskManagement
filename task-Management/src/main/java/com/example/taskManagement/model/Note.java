package com.example.taskManagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
// @Entity(name = "NOTE")
@Document(collection = "collection")
public class Note {

    // @GeneratedValue(strategy = GenerationType.IDENTITY) // this relies on a
    // database to auto-increment and generate and id

    // private static int nextId = 1; // Static field to track the next available ID

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    // private int noteNumber;
    private String name;
    private String description;
    private boolean completed;
    private LocalDateTime deadline;
    private ArrayList<Tag> tags;
    private String category;
    private int priority;

    // below is used without a databased
    // public Note() {
    // this.id = nextId++; // Assign the next available ID and increment the counter
    // this.tags = new ArrayList<>();
    // }

}
