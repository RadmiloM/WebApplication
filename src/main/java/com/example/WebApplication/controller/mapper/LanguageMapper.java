package com.example.WebApplication.controller.mapper;

import com.example.WebApplication.controller.dto.LanguageDTO;
import com.example.WebApplication.entity.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {

    public LanguageDTO mapToDTO(Language language) {
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setLanguageName(language.getLanguageName());
        languageDTO.setLanguageTranslation(language.getLanguageTranslation());
        return languageDTO;
    }

    public Language mapToEntity(LanguageDTO languageDTO) {
        Language language = new Language();
        language.setLanguageName(languageDTO.getLanguageName());
        language.setLanguageTranslation(languageDTO.getLanguageTranslation());
        return language;
    }

}
