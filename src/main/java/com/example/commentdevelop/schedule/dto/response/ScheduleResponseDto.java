package com.example.commentdevelop.schedule.dto.response;

import com.example.commentdevelop.schedule.entity.Schedule;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String content;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
            schedule.getId(),
            schedule.getTitle(),
            schedule.getContent(),
            schedule.getCreatedAt(),
            schedule.getUpdatedAt(),
            schedule.getWriterId()
        );

    }

}
