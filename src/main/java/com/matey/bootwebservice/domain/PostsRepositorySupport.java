package com.matey.bootwebservice.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.matey.bootwebservice.domain.QPosts.*;

@Repository
public class PostsRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public PostsRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Posts.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Posts> findAllDesc() {
        return jpaQueryFactory
                .selectFrom(posts)
                .orderBy(posts.id.desc())
                .fetch();
    }
}
