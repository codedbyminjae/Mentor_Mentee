package com.example.mentor_mentee.domain.post.dto.request;

import lombok.*;

// 빌더란 기존 생성자 형식의 객체 생성 방식에서 안전하게 객체를 생성해주는 패턴
@Getter
@Builder
public class PostRequestDto {
    // DTO 내부 변수를 private, final을 붙여서 변수를 선언하는 이유 ->
    // 데이터를 외부에서 보이지 않게 하기 위함 + 외부에서 데이터 변경 수비
    private final String title; // 게시판 제목
    private final String content; // 게시판 본문 데이터

    /* 기존 방식
    public PostRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    */


}
