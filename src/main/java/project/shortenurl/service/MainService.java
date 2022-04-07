package project.shortenurl.service;

import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;

public interface MainService {
    boolean isExist();
    Long join(Url url); // id받아서 create에서 사용
    void createShortenUrl(Url url);
    Url findOriginUrl(ShortenUrl shortenUrl);
}
