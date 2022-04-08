package project.shortenurl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.controller.MainController;
import project.shortenurl.repository.MainRepository;
import project.shortenurl.service.MainService;

import javax.annotation.PostConstruct;

@SpringBootTest
class ShortenUrlApplicationTests {
    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void totalTest(){
        MainController mainController = ac.getBean("mainController", MainController.class);
        MainService mainService = ac.getBean("mainService", MainService.class);
        MainRepository mainRepository = ac.getBean("mainRepository", MainRepository.class);


    }

}
