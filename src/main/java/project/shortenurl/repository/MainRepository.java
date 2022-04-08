package project.shortenurl.repository;

import org.springframework.ui.Model;

public interface MainRepository {

    boolean isSameUrl();
    Model save(Model model);
    Model findByShortenUrl(Model model);
    Model findById(Long id);
}
