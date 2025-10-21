package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 컨트롤러 서비스 레포지토리 연결
@RestController
@RequestMapping("/api/posts")   // 공통 prefix
public class PostController {
    /*
    Rest API는 “자 원”을 URI로 표현하고, “행위”는 HTTP 메서드로 구분하는 방식이 관례.
    동일한 자원(Post)에 대해서 어떤 행위를 할 것인지 메서드로 구분 해놓는 것이 Restful 한 것.
    컨트롤러 코드 작성시 반환값 설정, 인자 설정, 넘겨줘야 하는 인자 설정
     */
    private final PostService postService;

    // 게시글 생성
    @PostMapping("/")
    public PostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        PostResponseDto responseDto = postService.createPost(createPostRequestDto);
        return responseDto;
    }

    // 게시글 전체 조회
    @GetMapping
    public String getAllPosts() {
        return "게시글 리스트 조회 완료";
    }

    // 게시글 단건 조회
    @GetMapping("/{post-id}")
    public PostResponseDto getPostById(@PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.readPost(id);
        return responseDto;
    }

    // 게시글 수정
    @PutMapping("/{post-id}")
    public PostResponseDto updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto, @PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
        return responseDto;
    }

    // 게시글 삭제
    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable(value = "post-id") Long id) {
        String response = postService.deletePost(id);
        return response;
    }
}

