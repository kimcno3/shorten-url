package project.shortenurl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.controller.UrlController;
import project.shortenurl.repository.UrlRepository;
import project.shortenurl.service.UrlService;

@SpringBootTest
class ShortenUrlApplicationTests {
    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void totalTest(){
        UrlController urlController = ac.getBean("mainController", UrlController.class);
        UrlService urlService = ac.getBean("mainService", UrlService.class);
        UrlRepository urlRepository = ac.getBean("mainRepository", UrlRepository.class);


    }

}
