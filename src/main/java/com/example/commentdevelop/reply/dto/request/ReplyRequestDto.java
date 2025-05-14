package com.example.commentdevelop.reply.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReplyRequestDto {

    @NotBlank(message = "대댓글을 입력하세요")
    private final String reply;

}
