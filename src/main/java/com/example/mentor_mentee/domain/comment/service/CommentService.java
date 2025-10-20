package com.example.mentor_mentee.domain.comment.service;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        // 댓글이 달릴 게시글(postId)이 존재하는지 확인하고 가져옴
        // postRepo에 있는 데이터를 가져와야 하기에 postRepo도 함께 사용
        Post post = postRepository.findById(commentRequestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        // CommentRequestDto에 있는 값으로 Comment 객체 생성
        // 빌더로 연결된 것
        Comment comment = Comment.builder()
                .content(commentRequestDto.getContent())
                .post(post)
                .build();

        // 새로 생성한 comment 객체 DB에 저장
        Comment savedComment = commentRepository.save(comment);

        // 저장된 comment 객체에서 필요한 값을 꺼내 CommentResponseDto 생성
        return CommentResponseDto.builder()
                .id(savedComment.getId())
                .content(savedComment.getContent())
                .build();
    }
}
