package com.example.mentor_mentee.domain.comment.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    // 댓글 생성
    @PostMapping("/create")
    public String createComment(@RequestParam Long postId, @RequestParam String content) {
        return postId + "댓글 생성" + content;
    }

    // 댓글 전체 조회
    @GetMapping("/all")
    public String getAllComments(@RequestParam Long postId) {
        return postId + "번의 게시글 댓글 전체 조회";
    }


    // 댓글 부분 조회
    @GetMapping("/one")
    public String getCommentById(@RequestParam Long postId, @RequestParam Long commentId) {
        return postId + "번의 게시글 중" + commentId + "번 댓글 조회";
    }

    // 댓글 수정
    @PutMapping("/update")
    public String updateComment(@RequestParam Long postId, @RequestParam Long commentId, @RequestParam String content) {
        return postId + "번의 게시글 중" + commentId + "번 댓글 수정" + content + "로";
    }

    // 댓글 삭제
    @DeleteMapping("/delete")
    public String deleteComment(@RequestParam Long postId, @RequestParam Long commentId) {
        return postId + "번 게시글 중 " + commentId + "번 댓글 삭제";
    }
}
