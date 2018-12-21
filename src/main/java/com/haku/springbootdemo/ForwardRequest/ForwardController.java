package com.haku.springbootdemo.ForwardRequest;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/forward")
public class ForwardController {

    @RequestMapping(value = "/getproducts", produces = "application/json")
    public String getEmployees(@RequestParam("page") String page, @RequestParam("pagesize") String pagesize)
    {
        final String uri = String.format("http://localhost:9000/api/values/GetProducts/?page=%s&pagesize=%s", page, pagesize);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);

    }
}
