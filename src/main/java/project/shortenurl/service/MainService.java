package project.shortenurl.service;

import org.springframework.ui.Model;

public interface MainService {
    boolean isNotExist(String origin);
    Model create(Model model);
    void createShortenUrl(Model model);
    String makeRandomUrl();
    String findOriginUrl(Model model);
    String findShortenUrl(Model model);
}
