package project.shortenurl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.shortenurl.repository.UrlRepository;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Override
    public boolean isExist(String originUrl) {
        return urlRepository.isSameUrl(originUrl);
    }

    @Override
   public Long save(Model model) {
        createShortenUrl(model);
        return urlRepository.save(model);
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
        return urlRepository.findByShortenUrl(model);
    }

    @Override
    public String findShortenUrl(Model model) {
        return urlRepository.findByOriginUrl(model);
    }
}
