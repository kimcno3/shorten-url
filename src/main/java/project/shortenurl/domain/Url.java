package project.shortenurl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Url {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long accessCount;

    @Column
    private String originUrl;

    @Column
    private String shortenUrl;

    @Builder
    public Url(Long id, String originUrl, String shortenUrl, Long accessCount){
        this.id = id;
        this.originUrl = originUrl;
        this.shortenUrl = shortenUrl;
        this.accessCount = accessCount;
    }
}
