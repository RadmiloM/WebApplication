package com.example.WebApplication.controller;


import com.example.WebApplication.controller.dto.LanguageDTO;
import com.example.WebApplication.controller.mapper.LanguageMapper;
import com.example.WebApplication.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class LanguageController {

    private final LanguageService languageService;
    private final LanguageMapper languageMapper;

    @GetMapping("/hello-rest")
    public String getData() {
        return "Hello World";
    }

    @GetMapping("/hello/name")
    public ResponseEntity<LanguageDTO> getLanguageTranslation(@RequestParam("language") String language) {
        var languageTranslation = languageService.findByLanguage(language);
        var languageDTO = languageMapper.mapToDTO(languageTranslation);
        return ResponseEntity.ok(languageDTO);
    }

    @GetMapping("/secure/hello")
    public String getUserLogin() {
        return "Congratulations you manage to enter here";
    }

    @PostMapping("/Admin")
    public ResponseEntity<Void> createLanguage(@Valid @RequestBody LanguageDTO languageDTO) {
        var language = languageMapper.mapToEntity(languageDTO);
        languageService.createLanguage(language);
        return ResponseEntity.ok().build();
    }

}
