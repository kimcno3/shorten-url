package project.shortenurl.service;

import org.springframework.ui.Model;

public interface UrlService {
    boolean isExist(String originUrl);
    Long save(Model model);
    void createShortenUrl(Model model);
    String makeRandomUrl();
    String findOriginUrl(Model model);
    String findShortenUrl(Model model);
}
