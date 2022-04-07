package project.shortenurl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.shortenurl.domain.ShortenUrl;
import project.shortenurl.domain.Url;
import project.shortenurl.service.MainService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccessController {

    private final MainService mainService;

    /*
    * 개선사항
        * 리턴하는 url에 'localhost:8080'을 제거한 url을 redirect 하도록 개선해야 한다.
        * 접근하는 url에서도 localhost:8080을 제거하고 샆다.
        * @ResponseBody는 리턴 Url 확인을 위한 추가로, 실제 동작을 위해선 없어야 한다.
    */

    @GetMapping("/{shortenUrl}")
//    @ResponseBody
    public String accessShortenUrl(@PathVariable ShortenUrl shortenUrl,
                                   RedirectAttributes redirectAttributes){

        log.info("shorten = {}", shortenUrl.getShortenUrl());
        Url url = mainService.findOriginUrl(shortenUrl);
        redirectAttributes.addAttribute("originUrl", url.getOriginUrl());
        return "redirect:{originUrl}";
     }
}
