package project.shortenurl.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import project.shortenurl.domain.Url;
import project.shortenurl.repository.MainRepository;
import java.util.Locale;


@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final MainRepository mainRepository;

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public Long join(Url url) {
        isExist();
        this.create(url);
        Long id = mainRepository.save(url);
        return id;
    }

    @Override
    public Url create(Url url) {
        String randomURl = RandomStringUtils.random(12,0,'Z', true,true);
        url.setShortenUrl(randomURl.toLowerCase(Locale.ROOT));
        return url;
    }

    @Override
    public Url findShortenUrl(Long urlId) {
        return null;
    }
}
