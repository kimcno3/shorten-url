package project.shortenurl.repository;

import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;

public interface MainRepository {

    Long save(Url url);
    boolean isSameUrl(Url url);
    ShortenUrl findById(Long id);
    ShortenUrl findByOriginUrl(Url url);
}
