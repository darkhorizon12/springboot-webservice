package com.matey.bootwebservice.web;

import com.matey.bootwebservice.web.dto.PostResponseDTO;
import com.matey.bootwebservice.web.dto.PostsSaveRequestDTO;
import com.matey.bootwebservice.service.PostsService;
import com.matey.bootwebservice.web.dto.PostsUpdateRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsApiController {
    private final PostsService postsService;

    public PostsApiController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDTO requestDTO) {
        return postsService.save(requestDTO);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDTO requestDTO) {
        return postsService.update(id, requestDTO);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDTO findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
