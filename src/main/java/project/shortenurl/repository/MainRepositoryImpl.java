package project.shortenurl.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;

import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class MainRepositoryImpl implements MainRepository {

    /*
    * DB 대신 ConcurrentHashMap 활용 , 동시성 이슈를 고려
    * DI 위반 해결방법 생각해야 됨
    * */

    private ConcurrentHashMap<Long, Url> database = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    @Override
    public Long save(Url url) {
        url.setId(++sequence);
        database.put(url.getId(), url);
    return url.getId();
    }

    @Override
    public boolean isSameUrl(Url url) {
        return false;
    }

    @Override
    public ShortenUrl findById(Long id) {
        return null;
    }

    @Override
    public ShortenUrl findByOriginUrl(Url url) {
        return null;
    }
}
