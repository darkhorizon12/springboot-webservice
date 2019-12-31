package com.matey.bootwebservice.web;

import com.matey.bootwebservice.dto.HelloResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntroController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDTO helloDTO(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDTO(name, amount);
    }
}
