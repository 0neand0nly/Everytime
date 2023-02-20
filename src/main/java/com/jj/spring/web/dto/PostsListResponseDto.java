package com.jj.spring.web.dto;

import com.jj.spring.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime ModifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.ModifiedDate = entity.getModifiedDate();
    }
}
