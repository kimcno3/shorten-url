package project.shortenurl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.MainConfig;

class MainRepositoryImplTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    void acSample() {
        MainRepository mainRepository1 = ac.getBean(MainRepositoryImpl.class);
        MainRepository mainRepository2 = ac.getBean(MainRepositoryImpl.class);

        Assertions.assertThat(mainRepository2).isEqualTo(mainRepository1);
    }

    @Test
    void save() {
        MainRepository mainRepository = ac.getBean(MainRepositoryImpl.class);
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