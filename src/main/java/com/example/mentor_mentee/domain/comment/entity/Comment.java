package com.example.mentor_mentee.domain.comment.entity;

import com.example.mentor_mentee.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 증가 명시
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String content;


    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    /*
    @ManyToOne
    Comment는 Post와 N:1 관계. 즉, 여러 댓글이 하나의 게시글에 달릴 수 있다.
    @JoinColumn
    실제 DB에서 Comment 테이블에 만들어질 외래키 컬럼 이름 지정.
    이 Comment가 어떤 Post에 속했는지 DB 컬럼으로 구분.

    현재 기능에 필요 없지만 추후 기능에 필요할 것 같아서 일단 선언.
     */
}
