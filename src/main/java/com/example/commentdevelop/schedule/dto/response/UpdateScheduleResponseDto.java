package com.example.commentdevelop.schedule.dto.response;

import com.example.commentdevelop.schedule.entity.Schedule;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String content;

    private final Long writerId;

    private final LocalDateTime updatedAt;

    public static UpdateScheduleResponseDto from(Schedule schedule) {
        return new UpdateScheduleResponseDto(
            schedule.getId(),
            schedule.getTitle(),
            schedule.getContent(),
            schedule.getWriterId(),
            schedule.getUpdatedAt()
        );
    }

}
