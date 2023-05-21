package com.example.examm.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    @NotNull(message = "ID should not be empty!")
    private String id;
    @NotNull(message = "name should not be empty!")
    private String name;
    @NotNull(message = "age should not be empty!")
    private String age;
    @NotNull(message = "major should not be empty!")
    private String major;




}
