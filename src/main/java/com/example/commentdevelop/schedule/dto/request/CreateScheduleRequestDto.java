package com.example.commentdevelop.schedule.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateScheduleRequestDto {

    @NotBlank(message = "일정 제목은 필수입니다")
    private final String title;

    private final String content;

    private final Long writerId;

}
