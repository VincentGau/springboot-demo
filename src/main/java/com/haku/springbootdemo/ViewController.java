package com.haku.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("username", "haku");
        model.addAttribute("mode", "prod");
        return "index";
    }
}
