package project.shortenurl.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.MainConfig;
import project.shortenurl.repository.UrlRepository;
import project.shortenurl.repository.HashMapUrlRepository;

class UrlServiceImplTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    void acSample() {
        UrlRepository urlRepository1 = ac.getBean(HashMapUrlRepository.class);
        UrlRepository urlRepository2 = ac.getBean(HashMapUrlRepository.class);

        Assertions.assertThat(urlRepository2).isEqualTo(urlRepository1);
    }

    @Test
    void create() {
        UrlService urlService = ac.getBean("mainServiceImpl", UrlService.class);
        for(int i=0; i<20; i++){
        }
    }
}