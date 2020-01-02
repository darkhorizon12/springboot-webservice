package com.matey.bootwebservice.web;

import com.matey.bootwebservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.matey.bootwebservice.domain.QPosts.posts;

@Controller
public class IndexController {
    private final PostsService postsService;

    public IndexController(PostsService postsService) {
        this.postsService = postsService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
