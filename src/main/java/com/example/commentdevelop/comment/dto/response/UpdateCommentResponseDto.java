package com.example.commentdevelop.comment.dto.response;

import com.example.commentdevelop.comment.entity.Comment;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateCommentResponseDto {

    private final Long id;

    private final String comment;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    private final Long scheduleId;

    public static UpdateCommentResponseDto from(Comment comment) {
        return new UpdateCommentResponseDto(
            comment.getId(),
            comment.getComment(),
            comment.getUpdatedAt(),
            comment.getSchedule().getWriterId(),
            comment.getSchedule().getId()
        );
    }

}
