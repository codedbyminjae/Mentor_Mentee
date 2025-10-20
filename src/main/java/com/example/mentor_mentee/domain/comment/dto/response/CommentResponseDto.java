package com.example.mentor_mentee.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private Long id;
    private String content;
    private String title;
    private Long views;

}
