package project.shortenurl.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MainRepositoryImpl implements MainRepository {

    private final ConcurrentHashMap<Long, Model> database = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    @Override
    public boolean isSameUrl(String originUrl) {
        if(database.size() == 0) return true;

        for (Model tempModel: database.values()) {
            String tempOriginUrl = (String) tempModel.getAttribute("originUrl");

            if (tempOriginUrl.equals(originUrl)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Model save(Model model) {

        model.addAttribute("id", ++sequence);
        model.addAttribute("accessCount", 0);

        Long currentId = (Long) model.getAttribute("id");
        return database.put(currentId, model);
    }

    @Override
    public String findByOriginUrl(Model model){
        Object requestOriginUrl = model.getAttribute("originUrl");

        for (Model tempModel : database.values()) {
            Object tempOriginUrl = tempModel.getAttribute("originUrl");

            if(requestOriginUrl.equals(tempOriginUrl)){

                log.info("Find Model's info : id={}, originUrl={}, shortenUrl={}, accessCount={}",
                        tempModel.getAttribute("id"),
                        tempModel.getAttribute("originUrl"),
                        tempModel.getAttribute("shortenUrl"),
                        tempModel.getAttribute("accessCount"));

                return (String) tempModel.getAttribute("shortenUrl");
            }
        }
        return null;
    }

    @Override
    public String findByShortenUrl(Model model) {

        Object requestShortUrl = model.getAttribute("shortenUrl");

        for (Model tempModel : database.values()) {
            Object tempShortUrl = tempModel.getAttribute("shortenUrl");

            if(requestShortUrl.equals(tempShortUrl)){
                tempModel.addAttribute("accessCount", plusAccessCount(tempModel));

                log.info("Find Model's info : id={}, originUrl={}, shortenUrl={}, accessCount={}",
                        tempModel.getAttribute("id"),
                        tempModel.getAttribute("originUrl"),
                        tempModel.getAttribute("shortenUrl"),
                        tempModel.getAttribute("accessCount"));

                return (String) tempModel.getAttribute("originUrl");
            }
        }
        return null;
    }

    @Override
    public int plusAccessCount(Model tempModel){
        return (int) tempModel.getAttribute("accessCount") + 1;
    }
}

