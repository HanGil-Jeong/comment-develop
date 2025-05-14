package com.example.commentdevelop.schedule.dto.response;

import com.example.commentdevelop.comment.dto.response.CommentResponseDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetScheduleWhitCommentResponseDto {

    private final Long id;

    private final String title;

    private final String content;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    private final List<CommentResponseDto> comments;

    public static GetScheduleWhitCommentResponseDto from(Schedule schedule, List<CommentResponseDto> comments) {
        return new GetScheduleWhitCommentResponseDto(
            schedule.getId(),
            schedule.getTitle(),
            schedule.getContent(),
            schedule.getCreatedAt(),
            schedule.getUpdatedAt(),
            schedule.getWriterId(),
            comments
        );
    }

}
