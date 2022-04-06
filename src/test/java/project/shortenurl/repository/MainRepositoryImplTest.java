package project.shortenurl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.shortenurl.MainConfig;
import project.shortenurl.domain.Url;

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

        Url url1 = new Url("originUrl", "shortenUrl");
        Url url2 = new Url("originUrl2", "shortenUrl2");

        Long id1 = mainRepository.save(url1);
        Long id2 = mainRepository.save(url2);

        Assertions.assertThat(id1).isEqualTo(1L);
        Assertions.assertThat(id2).isEqualTo(2L);
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