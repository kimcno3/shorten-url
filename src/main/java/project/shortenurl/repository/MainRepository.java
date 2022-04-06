package project.shortenurl.repository;

import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;

public interface MainRepository {

    Long save(Url url);
    boolean isSameUrl(OriginUrl originUrl);
    ShortenUrl findById(Long id);
    ShortenUrl findByOriginUrl(OriginUrl originUrl);
}
