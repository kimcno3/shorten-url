package project.shortenurl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.MainConfig;


class UrlRepositoryImplTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);


    static class ModelSample{
        private Object shortenUrl;
        private Object originUrl;
        private Long sequence;
        private int AccessCount;
    }

    @Test
    void acSample() {
        UrlRepository urlRepository1 = ac.getBean(HashMapUrlRepository.class);
        UrlRepository urlRepository2 = ac.getBean(HashMapUrlRepository.class);

        Assertions.assertThat(urlRepository2).isEqualTo(urlRepository1);
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