package project.shortenurl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;
import project.shortenurl.service.MainService;

@Slf4j
@RestController
@RequestMapping("/create")
@RequiredArgsConstructor
public class CreateController {

    private final MainService mainService;

    @PostMapping
    public ResponseEntity<ShortenUrl> createShortenUrl(@ModelAttribute Url url){
        if(true){
            Long id = mainService.join(url);
            return new ResponseEntity<>(new ShortenUrl(url.getOriginUrl()), HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
