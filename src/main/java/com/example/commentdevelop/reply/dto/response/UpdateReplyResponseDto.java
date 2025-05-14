package com.example.commentdevelop.reply.dto.response;

import com.example.commentdevelop.reply.entity.Reply;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateReplyResponseDto {

    private final Long id;

    private final String reply;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    private final Long scheduleId;

    private final Long commentId;

    public static UpdateReplyResponseDto from(Reply reply) {
        return new UpdateReplyResponseDto(
            reply.getId(),
            reply.getReply(),
            reply.getUpdatedAt(),
            reply.getComment().getSchedule().getWriterId(),
            reply.getComment().getSchedule().getId(),
            reply.getComment().getId()
        );
    }

}
