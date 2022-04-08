package project.shortenurl.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
    public boolean isNotExist(String originUrl) {
        return mainRepository.isSameUrl(originUrl);
    }

    @Override
   public Model create(Model model) {
        createShortenUrl(model);
        return mainRepository.save(model);
    }

    @Override
    public void createShortenUrl(Model model) {
        model.addAttribute("shortenUrl", makeRandomUrl());
    }

    @Override
    public String makeRandomUrl(){
        return RandomStringUtils
                .random(12,0,'Z', true,true)
                .toLowerCase(Locale.ROOT);
    }

    @Override
    public String findOriginUrl(Model model) {
        return mainRepository.findByShortenUrl(model);
    }

    @Override
    public String findShortenUrl(Model model) {
        return mainRepository.findByOriginUrl(model);
    }
}
