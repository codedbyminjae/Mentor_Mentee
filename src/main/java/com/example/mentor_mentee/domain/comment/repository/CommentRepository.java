package com.example.mentor_mentee.domain.comment.repository;

import com.example.mentor_mentee.domain.comment.entity.Comment;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 인터페이스 부분은 지피티 참고

    // 특정 게시글에 달린 모든 댓글 조회
    List<Comment> findByPostId(Long postId);

    // 특정 게시글의 특정 댓글 조회 기능
    Comment findByPostIdAndId(Long postId, Long commentId);

    // 특정 게시글에 달린 댓글들을 내용 기준으로 검색
    List<Comment> findByPostIdAndContentContaining(Long postId, String keyword);


}
