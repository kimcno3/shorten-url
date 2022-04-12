package project.shortenurl.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.shortenurl.dtos.RequestOriginUrlDto;
import project.shortenurl.dtos.ResponseShortenUrlDto;
import project.shortenurl.service.UrlService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @Value("${basicUrl}")
    private String basicUrl;

    @PostMapping
    @ResponseBody
    public ResponseEntity createShortenUrl(@RequestBody RequestOriginUrlDto requestOriginUrl){
        String originUrl = requestOriginUrl.getOriginUrl();

        if(urlService.isNotExist(originUrl)){

            Long id = urlService.save(originUrl);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseShortenUrlDto(basicUrl + urlService.findOne(id).getShortenUrl()));
        } else{

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseShortenUrlDto(basicUrl + urlService.findShortenUrl(originUrl)));
        }
    }

    @GetMapping("/{shortenUrl}")
    public String accessShortenUrl(@PathVariable String shortenUrl){
        String originUrl = urlService.findOriginUrl(shortenUrl);
        return "redirect:" + originUrl;
    }
}
