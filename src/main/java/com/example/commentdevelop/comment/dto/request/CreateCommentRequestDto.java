package com.example.commentdevelop.comment.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCommentRequestDto {

    @NotBlank(message = "댓글 내용은 필수입니다")
    @Column(nullable = false)
    private final String comment;

}
