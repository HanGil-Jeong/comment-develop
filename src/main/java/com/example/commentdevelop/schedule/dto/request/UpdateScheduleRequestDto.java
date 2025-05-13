package com.example.commentdevelop.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateScheduleRequestDto {

    private String title;

    private String content;

}
