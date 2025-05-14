package com.example.commentdevelop.schedule.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateScheduleRequestDto {

    private String title;

    private String content;

}
