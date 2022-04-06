package project.shortenurl.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class OriginUrl {

    private String originUrl;

    public OriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }
}
