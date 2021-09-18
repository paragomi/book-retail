package com.example.bookretail.model;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateRequest {
    @NotBlank(message = "First name is mandatory")
    @NotNull(message = "First name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    @NotNull(message = "Last name cannot be empty")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email cannot be empty")
    @Email
    private String email;
}
