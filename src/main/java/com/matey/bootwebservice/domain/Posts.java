package com.matey.bootwebservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@Getter
@Entity
@ToString
public class Posts extends BaseEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    public Posts(PostsBuilder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.author = builder.author;
    }

    public static PostsBuilder builder() {
        return new PostsBuilder();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static class PostsBuilder {
        private String title;
        private String content;
        private String author;

        public PostsBuilder() {
        }

        public PostsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostsBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostsBuilder author(String author) {
            this.author = author;
            return this;
        }

        public Posts build() {
            return new Posts(this);
        }
    }
}
