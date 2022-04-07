package project.shortenurl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;
import project.shortenurl.service.MainService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/create")
@RequiredArgsConstructor
public class CreateController {

    private final MainService mainService;

    /*
    * 코드 설명
        * basicUrl : 기본 shortenUrl 앞 주소 설정, 'appication.properties'에 설정값 추가

    * 개선 사항
        * 중복 Url 체크하는 기능 추가해야 된다.(조건문 조건)
        *
    */

    @Value("${basicUrl}")
    private String basicUrl;

    @PostMapping
    public ResponseEntity<ShortenUrl> createShortenUrl(@ModelAttribute Url url){
        if(true){
            mainService.join(url);
            log.info("url info id={}, origin={}, shorten={}" , url.getId(), url.getOriginUrl(), url.getShortenUrl());

            return new ResponseEntity<>(new ShortenUrl(basicUrl + url.getShortenUrl()), HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
