package project.shortenurl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.shortenurl.domain.Url;
import project.shortenurl.repository.UrlRepository;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private Long sequence = 0L;

    @Override
    public boolean isNotExist(String originUrl) {
        return urlRepository.isNotExist(originUrl);
    }

    @Override
   public Long save(String originUrl) {
        Url url = Url.builder()
                .id(++sequence)
                .originUrl(originUrl)
                .shortenUrl(makeRandomUrl())
                .accessCount(0L)
                .build();

        return urlRepository.save(url);
    }

    @Override
    public String makeRandomUrl(){
        return RandomStringUtils
                .random(12,0,'Z', true,true)
                .toLowerCase(Locale.ROOT);
    }

    @Override
    public Url findOne(Long id){
        Url findUrl = urlRepository.findById(id);
        findUrl.plusAccessCount(); // 내부 메소드로 접근횟수 Count
        return findUrl;
    }

    @Override
    public String findShortenUrl(String originUrl){
        Url findUrl = urlRepository.findByOriginUrl(originUrl);
        findUrl.plusAccessCount(); // 내부 메소드로 접근횟수 Count
        return findUrl.getShortenUrl();
    }

    @Override
    public String findOriginUrl(String shortenUrl){
        Url findUrl = urlRepository.findByShortenUrl(shortenUrl);
        findUrl.plusAccessCount(); // 내부 메소드로 접근횟수 Count
        return findUrl.getOriginUrl();
    }
}
