package project.shortenurl.repository;

import org.springframework.ui.Model;
import project.shortenurl.domain.Url;

public interface UrlRepository {

    boolean isNotExist(String originUrl);
    Long save(Url url);
    Url findById(Long id);
    Url findByOriginUrl(String originUrl);
    Url findByShortenUrl(String shortenUrl);
    Long plusAccessCount(Url url);
}
