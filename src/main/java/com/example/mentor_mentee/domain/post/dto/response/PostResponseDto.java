package com.example.mentor_mentee.domain.post.dto.response;

import lombok.*;

@Getter
@Builder
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final Long views;
}
