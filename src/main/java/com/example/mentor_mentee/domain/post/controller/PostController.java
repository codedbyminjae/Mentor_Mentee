package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 컨트롤러 서비스 레포지토리 연결
@RestController
@RequestMapping("/api/posts")   // 공통 prefix
public class PostController {
    private final PostService postService;

    // 게시글 생성
    @PostMapping("/")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto responseDto = postService.createPost(postRequestDto);
        return responseDto;
    }

    // 게시글 전체 조회
    @GetMapping
    public String getAllPosts() {
        return "게시글 리스트 조회 완료";
    }

    // 게시글 단건 조회
    @GetMapping("/{post-id}")
    public String getPostById(@PathVariable("post-id") Long id) {
        return id + "번 게시글 조회 완료";
    }

    // 게시글 수정
    @PutMapping("/{post-id}")
    public String updatePost(@PathVariable("post-id") Long id) {
        return id + "번 게시글 수정 완료";
    }

    // 게시글 삭제
    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable("post-id") Long id) {
        return id + "번 게시글 삭제 완료";
    }
}

