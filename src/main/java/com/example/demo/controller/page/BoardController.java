package com.example.demo.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {
    @GetMapping("{page}")
    public String page(@PathVariable String page){
        return "board/"+ page;
    }

    @GetMapping("{page}/{id}")//detail
    public String page2(@PathVariable String page, Integer id){
        return "board/"+ page;
    }
}


