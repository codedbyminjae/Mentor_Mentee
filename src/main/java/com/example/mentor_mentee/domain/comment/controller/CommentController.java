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

    // 댓글 생성
    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto postRequestDto) {
        CommentResponseDto responseDto = commentService.createComment(postRequestDto);
        return responseDto;
    }

    // 댓글 전체 조회
    @GetMapping
    public String getAllComments(@RequestParam Long postId) {
        return postId + "댓글 리스트 조회 완료";
    }

    // 댓글 부분 조회
    @GetMapping("/{comment-Id}")
    public String getCommentById(@RequestParam Long postId, @PathVariable Long commentId) {
        return postId + "번의 게시글 중" + commentId + "번 댓글 조회";
    }

    // 댓글 수정
    @PutMapping("/{comment-Id}")
    public String updateComment(@RequestParam Long postId, @PathVariable Long commentId, @RequestParam String content) {
        return postId + "번의 게시글 중" + commentId + "번 댓글 수정" + content + "로";
    }

    // 댓글 삭제
    @DeleteMapping("/{comment-Id}")
    public String deleteComment(@RequestParam Long postId, @PathVariable Long commentId) {
        return postId + "번 게시글 중 " + commentId + "번 댓글 삭제";
    }
}
