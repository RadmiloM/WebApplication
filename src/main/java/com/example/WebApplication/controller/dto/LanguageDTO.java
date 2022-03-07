package com.example.WebApplication.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class LanguageDTO {

    @NotBlank
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z\\s+]+", message = "languageName must " +
            "contain only letters")
    private String languageName;
    @NotBlank
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z\\s+]+", message = "languageTranslation " +
            "must contain only letters")
    private String languageTranslation;

}
