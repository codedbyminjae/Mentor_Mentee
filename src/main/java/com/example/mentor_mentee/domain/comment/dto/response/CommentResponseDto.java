package com.example.mentor_mentee.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private Long commentId;
    private final String content;
    private final String title;

}
