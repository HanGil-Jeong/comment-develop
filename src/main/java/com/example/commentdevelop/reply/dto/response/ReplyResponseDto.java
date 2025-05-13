package com.example.commentdevelop.reply.dto.response;

import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.reply.entity.Reply;
import com.example.commentdevelop.schedule.entity.Schedule;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReplyResponseDto {

    private final Long id;

    private final String reply;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    private final Long scheduleId;

    private final Long commentId;

    public static ReplyResponseDto toDto(Reply reply) {
        return new ReplyResponseDto(
            reply.getId(),
            reply.getReply(),
            reply.getCreatedAt(),
            reply.getUpdatedAt(),
            reply.getComment().getSchedule().getWriterId(),
            reply.getComment().getSchedule().getId(),
            reply.getComment().getId()
        );
    }

}
