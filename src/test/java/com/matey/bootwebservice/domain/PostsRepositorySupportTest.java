package com.matey.bootwebservice.domain;

import com.matey.bootwebservice.service.PostsService;
import com.matey.bootwebservice.web.dto.PostsSaveRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsRepositorySupportTest {
    @Autowired
    PostsService postsService;
    @Autowired PostsRepositorySupport repositorySupport;

    @Test
    public void 쿼리DSL_테스트() {
        //given
        Long save = postsService.save(
                PostsSaveRequestDTO.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build()
        );

        //when
        List<Posts> allDesc = repositorySupport.findAllDesc();
        Posts posts = allDesc.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("No exists article. id = " + save));

        //then
        assertThat(allDesc.size()).isEqualTo(1);
        assertThat(posts.getTitle()).isEqualTo("title");

    }
}