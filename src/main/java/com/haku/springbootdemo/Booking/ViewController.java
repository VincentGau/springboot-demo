package com.haku.springbootdemo.Booking;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/bookinglistview")
    public String bookinglistview(Model model){
        model.addAttribute("username", "haku");
        model.addAttribute("mode", "prod");
        return "bookinglistview";
    }

    @RequestMapping("/kendo")
    @PreAuthorize("hasRole('Manager')")
    public String kendo(){
        return "customer/index";
    }

    @RequestMapping("/kendo/chart")
    public String chart(){
        return "chart";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
