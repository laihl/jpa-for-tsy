package com.hailong.jpafortsy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/")
@ApiIgnore
public class indexApi {

    @RequestMapping
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

}
