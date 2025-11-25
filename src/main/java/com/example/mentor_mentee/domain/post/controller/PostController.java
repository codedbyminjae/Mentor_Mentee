package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostListResponseDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import com.example.mentor_mentee.global.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<BaseResponse<PostResponseDto>> createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        PostResponseDto responseDto = postService.createPost(createPostRequestDto);
        return ResponseEntity
                .status(201)
                .body(BaseResponse.success(201, "게시글이 성공적으로 생성되었습니다.", responseDto));
    }

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<BaseResponse<List<PostListResponseDto>>> getAllPosts() {
        List<PostListResponseDto> responseDtos = postService.readPostList();
        return ResponseEntity
                .status(200)
                .body(BaseResponse.success(responseDtos));
    }

    // 게시글 단건 조회
    @GetMapping("/{post-id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.readPost(id);
        return ResponseEntity.status(200).body(responseDto);
    }

    // 게시글 수정
    @PutMapping("/{post-id}")
    public ResponseEntity<PostResponseDto> updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto, @PathVariable(value = "post-id") Long id) {
        PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
        return ResponseEntity.status(200).body(responseDto);
    }

    // 게시글 삭제
    @DeleteMapping("/{post-id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "post-id") Long id) {
        String response = postService.deletePost(id);
        return ResponseEntity.status(204).body(response);
    }

}

