package project.shortenurl.repository;

import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;

public interface MainRepository {

    boolean isSameUrl(Url url);
    Long save(Url url);
    Url findByShortenUrl(ShortenUrl shortenUrl);
    Url findById(Long id);
}
