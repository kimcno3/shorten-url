package project.shortenurl.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.shortenurl.domain.OriginUrl;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class MainRepositoryImpl implements MainRepository {

    /*
    * 개선 사항
        * findByShortenUrl의 코드를 더 작게 나눠볼 수 없을지
        * 위 메서드의 로직을 Mainservice로 뺄 수는 없을지
        *
    *
    */



    private ConcurrentHashMap<Long, Url> database = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    @Override
    public boolean isSameUrl(Url url) {
        return false;
    }

    @Override
    public Long save(Url url) {
        url.setId(++sequence);
        database.put(url.getId(), url);
        return url.getId();
    }

    @Override
    public Url findByShortenUrl(ShortenUrl shortenUrl) {
        String shortenUrlString = shortenUrl.getShortenUrl();
        for(Url tempUrl : database.values()){
            if(tempUrl.getShortenUrl().equals(shortenUrlString)){
                return tempUrl;
            }
        }
        return null;
    }

    @Override
    public Url findById(Long id) {
        return database.get(id);
    }
}
