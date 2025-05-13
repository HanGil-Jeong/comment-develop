package com.example.commentdevelop.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateScheduleRequestDto {

    private String title;

    private String content;

    private Long writerId;

}
