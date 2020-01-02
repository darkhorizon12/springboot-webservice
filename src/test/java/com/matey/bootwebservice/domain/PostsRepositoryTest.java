package com.matey.bootwebservice.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PostsRepositoryTest {
    @Autowired PostsRepository postsRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    public void 게시글_저장_호출() {
        //given
        String title = "title for test";
        String content = "content for test";

        postsRepository.save(
            Posts.builder()
                .title(title)
                .content(content)
                .author("finrir@matey.co.kr")
                .build()
        );

        //when
        List<Posts> list = postsRepository.findAll();
        Posts post = list.get(0);

        //then
        assertThat(list.size()).isEqualTo(1);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseEntity_등록_테스트() throws InterruptedException {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(
                Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build()
        );

        //when
        List<Posts> all = postsRepository.findAll();

        //then
        Posts posts = all.get(0);
        System.out.println("posts.getModifiedDate() = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isNotNull();
    }
}
