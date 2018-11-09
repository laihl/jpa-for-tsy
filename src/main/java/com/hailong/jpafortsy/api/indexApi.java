package com.hailong.jpafortsy.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("")
@ApiIgnore
public class indexApi {

    @RequestMapping
    public String index(){
        return "redirect:/swagger-ui.html";
    }

}
