package project.shortenurl.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.shortenurl.dtos.RequestOriginUrlDto;
import project.shortenurl.dtos.ResponseShortenUrlDto;
import project.shortenurl.service.UrlService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UrlController {

    /*
     * 추가 개선 사항

     * 중복 Url 체크하는 기능 추가해야 된다.(조건문 조건)
     *
     * 현재 사용하는 클래스들의 명칭이 코드를 처음 읽는 사람이 어떤 역할을 하는지 알기 쉬울지
        * DTO 클래스명으로 변경
        *
     * 현재 사용하는 클래스와 패키지 구조로 구현한 이유와 다른 방법들도 있었을지
        * Controller 하나로 통합
        *
        *
     * Url 클래스를 직접 사용하고 있는데, 이 녀석을 꼭 사용해야 할지, 없이 구현한다면 어떻게 할 수 있을지
            * Model 객체 활용
            * POST 요청 처리시 @RequestBody를 가져올 떈 OriginUrl 객체, 응답 처리시 ShortenUrl 객체만 사용
            * OriginUrl 내부에 @Setter는 미선언, @NoArgsContructor만 선언
            *
     * shorten url로 접근한 횟수를 저장하고 볼 수 있게 하려면 어떤 부분을 수정하면 될지
            * Model 객체를 DB에 저장 전, Repository 에서 "AccessCount" 변수를 생성 및 저장
            * 저장된 URL에 접근하는 요청이 오면 해당되는 Url이 저장된 Model 객체를 DB에서 찾고 count 1 증가
            * 대신 형변환 필요...
            *
     * memory가 아닌 database로 저장할 경우 코드의 수정 범위를 최소화 하려면 어떤 설계가 되는게 좋을지
        *
        *
     */

    private final UrlService urlService;

    @Value("${basicUrl}")
    private String basicUrl;

    @PostMapping
    @ResponseBody
    public ResponseEntity createShortenUrl(@RequestBody RequestOriginUrlDto requestOriginUrl, Model model){
        String originUrl = requestOriginUrl.getOriginUrl();
        model.addAttribute("originUrl", originUrl);

        if(urlService.isExist(originUrl)){

            urlService.save(model);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseShortenUrlDto(basicUrl + urlService.findShortenUrl(model))); // change
        } else{
            String shortenUrl = basicUrl + urlService.findShortenUrl(model);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseShortenUrlDto(shortenUrl));
        }
    }

    @GetMapping("/{shortenUrl}")
    public String accessShortenUrl(@PathVariable String shortenUrl,
                                   @NotNull Model model){

        model.addAttribute("shortenUrl", shortenUrl);
        String originUrl = urlService.findOriginUrl(model);
        return "redirect:" + originUrl;
    }
}
