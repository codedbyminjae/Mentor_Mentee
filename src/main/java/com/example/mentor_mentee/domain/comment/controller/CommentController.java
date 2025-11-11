package com.example.mentor_mentee.domain.comment.controller;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
즉, @RequestMapping은 “특정 URL 경로(Path)”로 들어온
요청을 어떤 컨트롤러(혹은 메서드)가 처리할지 연결하는 어노테이션입니다!
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성 - 수정ver
    @PostMapping("/{post-id}")
    public CommentResponseDto createComment(@PathVariable(value = "post-id") Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto responseDto = commentService.createComment(postId, commentRequestDto);
        return responseDto;
    }

    // 댓글 삭제 - 수정ver
    @DeleteMapping("/{post-id}/{comment-id}")
    public String deleteComment(@PathVariable(value = "post-id") Long postId, @PathVariable(value = "comment-id") Long commentId){
        return commentService.deleteComment(postId, commentId);
    }
}
