package com.example.WebApplication.service;

import com.example.WebApplication.entity.Language;
import com.example.WebApplication.repository.LanguageRepository;
import com.example.WebApplication.service.exception.LanguageNotFoundException;
import com.example.WebApplication.service.exception.WrongDataEntryException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public Language findByLanguage(String language) {
        log.info("findByLanguage method was called");
        var languageName = languageRepository.findByLanguageName(language);
        if (languageName.isEmpty()) {
            log.error("Error language with name " + language +
                    " is not present in database or must start with Uppercase letter");
            throw new LanguageNotFoundException("Language with name " + language +
                    " is not present in database or must start with Uppercase letter");
        }
        return languageName.get();
    }

    public Language createLanguage(Language language) {
        log.info("createLanguage method was called");
        if (languageRepository.existsByLanguageName(language.getLanguageName())) {
            log.error("Error in getting language with name " + language.getLanguageName());
            throw new WrongDataEntryException("Language with name " + language.getLanguageName()
                    + " is already in database");
        }
        return languageRepository.save(language);
    }

}
