package com.example.mentor_mentee.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinRequestDto {
    // @Valid 써서 해당 검증용 어노테이션들이 실제로 실행될 수 있게 한다.
    @NotBlank
    private final String name;

    @NotBlank
    private final String nickname;

    @NotBlank
    private final String classNum;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    private final String loginId;

    @NotBlank
    private final String password;

    @NotBlank
    private final String department;

    @NotNull
    @Builder.Default
    private final boolean inSchool = true;
}
