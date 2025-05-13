package com.example.commentdevelop.comment.dto.response;

import com.example.commentdevelop.comment.entity.Comment;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentResponseDto {

    private final Long id;

    private final String comment;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    private final Long scheduleId;

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
            comment.getId(),
            comment.getComment(),
            comment.getCreatedAt(),
            comment.getUpdatedAt(),
            comment.getSchedule().getWriterId(),
            comment.getSchedule().getId()
        );
    }

}
