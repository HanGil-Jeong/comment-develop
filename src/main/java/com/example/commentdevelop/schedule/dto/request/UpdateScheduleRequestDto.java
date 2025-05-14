package com.example.commentdevelop.schedule.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateScheduleRequestDto {

    @NotBlank(message = "일정 제목은 필수입니다")
    private final String title;

    @NotBlank(message = "일정 내용은 필수입니다")
    private final String content;

}
