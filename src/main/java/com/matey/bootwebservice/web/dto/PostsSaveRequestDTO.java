package com.matey.bootwebservice.web.dto;

import com.matey.bootwebservice.domain.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDTO {
    private String title;
    private String content;
    private String author;

    public PostsSaveRequestDTO(PostsSaveBuilder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.author = builder.author;
    }

    public static PostsSaveBuilder builder() {
        return new PostsSaveBuilder();
    }

    public static class PostsSaveBuilder {
        private String title;
        private String content;
        private String author;

        public PostsSaveBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostsSaveBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostsSaveBuilder author(String author) {
            this.author = author;
            return this;
        }

        public PostsSaveRequestDTO build() {
            return new PostsSaveRequestDTO(this);
        }
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
