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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long AccessCount;

    @Column
    private String originUrl;

    @Column
    private String shortenUrl;

    @Builder
    public Url(String originUrl, String shortenUrl){
        this.originUrl = originUrl;
        this.shortenUrl = shortenUrl;
    }
}
