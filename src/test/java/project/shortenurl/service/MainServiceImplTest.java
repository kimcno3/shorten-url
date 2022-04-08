package project.shortenurl.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.MainConfig;
import project.shortenurl.repository.MainRepository;
import project.shortenurl.repository.MainRepositoryImpl;

class MainServiceImplTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    void acSample() {
        MainRepository mainRepository1 = ac.getBean(MainRepositoryImpl.class);
        MainRepository mainRepository2 = ac.getBean(MainRepositoryImpl.class);

        Assertions.assertThat(mainRepository2).isEqualTo(mainRepository1);
    }

    @Test
    void create() {
        MainService mainService = ac.getBean("mainServiceImpl", MainService.class);
        for(int i=0; i<20; i++){
        }
    }
}