package project.shortenurl.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;
import project.shortenurl.repository.MainRepository;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final MainRepository mainRepository;

    /*
    * 코드설명
        * makeRandomUrl : RandomStringUtils 클래스를 활용해서 랜덤 문자열 생성, 소문자로 변경

    * 개선 사항
      * findOriginUrl : shorenUrl로 OriginUrl을 찾는데, id로 찾을 수 있는 방법은 없을지 고민해봐야 한다.
    * */

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
   public Long join(Url url) {
        createShortenUrl(url);
        Long id = mainRepository.save(url);
        return id;
    }

    @Override
    public void createShortenUrl(Url url) {
        url.setShortenUrl(makeRandomUrl());
    }

    public String makeRandomUrl(){
        return RandomStringUtils
                .random(12,0,'Z', true,true)
                .toLowerCase(Locale.ROOT);
    }

    @Override
    public Url findOriginUrl(ShortenUrl shortenUrl) {
        return mainRepository.findByShortenUrl(shortenUrl);
    }
}
