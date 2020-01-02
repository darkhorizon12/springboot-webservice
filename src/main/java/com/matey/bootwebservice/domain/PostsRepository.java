package com.matey.bootwebservice.domain;

import com.matey.bootwebservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
