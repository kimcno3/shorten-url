package project.shortenurl.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ShortenUrl {
    private String shortenUrl;

    public ShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }
}
