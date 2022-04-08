package project.shortenurl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import project.shortenurl.MainConfig;
import project.shortenurl.domain.ShortenUrlDTO;


class MainRepositoryImplTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);


    static class ModelSample{
        private Object shortenUrl;
        private Object originUrl;
        private Long sequence;
        private int AccessCount;
    }

    @Test
    void acSample() {
        MainRepository mainRepository1 = ac.getBean(MainRepositoryImpl.class);
        MainRepository mainRepository2 = ac.getBean(MainRepositoryImpl.class);

        Assertions.assertThat(mainRepository2).isEqualTo(mainRepository1);
    }

    @Test
    void save() {

    }

    @Test
    void isSameUrl() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByOriginUrl() {
    }
}