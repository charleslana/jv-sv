package com.example.jv_sv.model.dto;

import com.example.jv_sv.annotation.Lowercase;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO {
    private String id;
    private Long userId;
    private String name;

    @NotBlank
    @Email
    @Size(max = 50)
    @Lowercase
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String password;
}
