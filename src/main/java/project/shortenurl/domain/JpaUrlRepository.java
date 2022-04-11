package project.shortenurl.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUrlRepository extends JpaRepository<Url, Long> {
}
