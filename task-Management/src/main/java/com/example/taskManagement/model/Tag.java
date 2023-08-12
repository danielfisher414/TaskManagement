package com.example.taskManagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@Entity
public class Tag {

    private String name;
    private String description;
}
