package project.shortenurl.service;

import org.springframework.ui.Model;

public interface MainService {
    boolean isExist();
    Model create(Model model);
    void createShortenUrl(Model model);
    String makeRandomUrl();
    Model findOriginUrl(Model model);
}
