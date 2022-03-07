package com.example.WebApplication.repository;

import com.example.WebApplication.entity.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository testRepository;

    @AfterEach
    void tearDown() {
        testRepository.deleteAll();
    }

    @Test
    void testIfExistsByLanguageName() {
        // given the input
        String languageName = "France";
        Language language = new Language(
                3l,
                languageName,
                "Bonjour le monde"
        );

        testRepository.save(language);

        //when this happened
        boolean expected = testRepository.existsByLanguageName(languageName);

        //then this is expected
        assertThat(expected).isTrue();
    }

    @Test
    void testIfLanguageNameDoesNotExists() {
        // given the input
        String languageName = "Hungary";

        //when this happend
        boolean expected = testRepository.existsByLanguageName(languageName);

        //then this is expected
        assertThat(expected).isFalse();
    }

}