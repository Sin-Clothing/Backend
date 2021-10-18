package at.sinclothing.backend.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/page")
    public String home(){
        return "page";
    }
}
