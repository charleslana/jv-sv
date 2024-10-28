package com.example.jv_sv.model.dto;

import com.example.jv_sv.annotation.NoWhitespace;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private Long userId;

    @NotNull
    @NoWhitespace
    @Size(min = 1, max = 20)
    private String name;
}
