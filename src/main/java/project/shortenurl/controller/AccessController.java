package project.shortenurl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.shortenurl.service.MainService;

@Controller
@RequestMapping("/access")
@RequiredArgsConstructor
public class AccessController {

    private MainService mainService;
}
