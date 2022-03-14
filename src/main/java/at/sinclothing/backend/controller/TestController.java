package at.sinclothing.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

    @ModelAttribute
    public void addAttributtes(Model model) {
        model.addAttribute("firstname", "Nico");
        model.addAttribute("lastname", "Nudel");
        model.addAttribute("adresse", "fettsackgasse 10");
    }

    @GetMapping("/rechnung")
    public String showDesign() {
        return "rechnung";
    }

}
