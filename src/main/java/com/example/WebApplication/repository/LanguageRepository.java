package com.example.WebApplication.repository;

import com.example.WebApplication.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByLanguageName(String language);

    Boolean existsByLanguageName(String languageName);

}
