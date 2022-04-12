package project.shortenurl.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import project.shortenurl.domain.Url;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
@RequiredArgsConstructor
public class HashMapUrlRepository implements UrlRepository {

    private final ConcurrentHashMap<Long, Url> database = new ConcurrentHashMap<>();

    @Override
    public boolean isNotExist(String originUrl) {
        if(database.size() == 0) return true;

        for (Url tempUrl: database.values()) {
            String tempOriginUrl =  tempUrl.getOriginUrl();

            if (tempOriginUrl.equals(originUrl)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Long save(Url url) {
        Long currentId = url.getId();
        database.put(currentId, url);

        log.info("Find Url's info : id={}, originUrl={}, shortenUrl={}, accessCount={}",
                url.getId(), url.getOriginUrl(), url.getShortenUrl(), url.getAccessCount());

        return currentId;
    }

    @Override
    public Url findById(Long id){
        Url findUrl = database.get(id);
        return findUrl;
    }

    @Override
    public Url findByOriginUrl(String originUrl){

        for (Url tempUrl : database.values()) {
            if(originUrl.equals(tempUrl.getOriginUrl())){

                log.info("Find Url's info : id={}, originUrl={}, shortenUrl={}, accessCount={}",
                        tempUrl.getId(), tempUrl.getOriginUrl(), tempUrl.getShortenUrl(), tempUrl.getAccessCount()
                );

                return tempUrl;
            }
        }
        throw new NullPointerException("동일한 URL이 존재하지 않습니다.");
    }

    @Override
    public Url findByShortenUrl(String shortenUrl) {

        for (Url tempUrl : database.values()) {
            if(shortenUrl.equals(tempUrl.getShortenUrl())){
                log.info("Find Url's info : id={}, originUrl={}, shortenUrl={}, accessCount={}",
                        tempUrl.getId(), tempUrl.getOriginUrl(), tempUrl.getShortenUrl(), tempUrl.getAccessCount()
                );

                return tempUrl;
            }
        }
        throw new NullPointerException("동일한 URL이 존재하지 않습니다.");
    }

    @Override
    public Long plusAccessCount(Url url){
        return url.getAccessCount() + 1;
    }
}

