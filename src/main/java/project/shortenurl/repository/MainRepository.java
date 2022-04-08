package project.shortenurl.repository;

import org.springframework.ui.Model;

public interface MainRepository {

    boolean isSameUrl(String originUrl);
    Model save(Model model);
    String findByOriginUrl(Model model);
    String findByShortenUrl(Model model);
    int plusAccessCount(Model tempModel);
}
