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

    /*
    * 개선 사항
        * findByShortenUrl의 코드를 더 작게 나눠볼 수 없을지
        * 위 메서드의 로직을 Mainservice로 뺄 수는 없을지
        *
    *
    */

    private ConcurrentHashMap<Long, Model> database = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    @Override
    public boolean isSameUrl() {
        return false;
    }

    @Override
    public Model save(Model model) {
        model.addAttribute("id", ++sequence);
        model.addAttribute("accessCount", 0);
        Long currentId = (Long) model.getAttribute("id");

        return database.put(currentId, model);
    }

    @Override
    public Model findByShortenUrl(Model model) {
        log.info("repository param model shortenUrl = {}", model.getAttribute("shortenUrl"));

        for (Model tempModel: database.values()) {
            if(tempModel.getAttribute("shortenUrl").equals(model.getAttribute("shortenUrl"))){
                tempModel.addAttribute("accessCount", (int)tempModel.getAttribute("accessCount")+1);

                log.info("repository's tempModel info : originUrl = {}, shortenUrl = {}, accessCount = {}",
                        tempModel.getAttribute("originUrl"),
                        tempModel.getAttribute("shortenUrl"),
                        tempModel.getAttribute("accessCount"));

                return tempModel;
            }
        }
        return null;
    }

    @Override
    public Model findById(Long id) {
        return database.get(id);
    }
}
