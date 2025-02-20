package com.spring.web.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;

    @NotNull(message = " Student name should not be null")
    private String name;

    @Email(message = "Email address not valid")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Mobile phone is not valid")
    private String mobile;

    @NotNull(message = "Gender should not be null")
    private String gender;

    @Min(10)
    @Max(80)
    private int age;

    @NotBlank
    private String nationality;
}
