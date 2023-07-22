package com.bridgelabz.mysqldatabase.dto;
// DTO => transfer the data between the controller layer and the service layer


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class MyDatabaseDTO {
    // NotNull for int, NotEmpty and NotBlank for String , NotBlank for collection data type also .

    @Pattern(regexp = "^[A-Z][a-zA-Z]*(?: [a-zA-Z]+)*$", message = "First letter should be capital and At least three character")
    @NotEmpty(message = "Title Cannot be Empty")
    public String title;
    @Pattern(regexp = "^[A-Z][a-zA-Z]*(?: [a-zA-Z]+)*$", message = "Start from capital letter and At least three character")
    @NotEmpty(message = "This field Cannot be Empty")
    public String description;
    public LocalDate dueDate;

    public Boolean completed;
}