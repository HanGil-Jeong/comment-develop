package com.example.commentdevelop.schedule.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateScheduleRequestDto {

    private final String title;

    private final String content;

    private final Long writerId;

}
