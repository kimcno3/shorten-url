package project.shortenurl.service;

import org.springframework.ui.Model;
import project.shortenurl.domain.Url;

public interface UrlService {
    boolean isNotExist(String originUrl);
    Long save(String originUrl);
    String makeRandomUrl();
    Url findOne(Long id);
    String findOriginUrl(String shortenUrl);
    String findShortenUrl(String originUrl);
}
