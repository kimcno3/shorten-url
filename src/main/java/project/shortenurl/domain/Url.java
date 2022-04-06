package project.shortenurl.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Url {

    private long id;
    private String originUrl;
    private String shortenUrl;

    public Url(String originUrl, String shortenUrl) {
        this.originUrl = originUrl;
        this.shortenUrl = shortenUrl;
    }
}
