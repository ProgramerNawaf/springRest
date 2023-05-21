package com.example.examm.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {
    @NotNull(message = "ID should not be empty!")
    private String id;
    @NotNull(message = "name should not be empty!")
    private String name;
    @NotNull(message = "salary should not be empty!")
    private double salary;
}
