package com.example.commentdevelop.reply.dto.response;

import com.example.commentdevelop.comment.dto.response.CommentResponseDto;
import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.reply.entity.Reply;
import com.example.commentdevelop.schedule.dto.response.GetScheduleWhitCommentResponseDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetReplyListWithCommentResponseDto {

    private final Long id;

    private final String comment;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final Long writerId;

    private final Long scheduleId;

    private final List<ReplyResponseDto> replyList;

    public static GetReplyListWithCommentResponseDto from(
        Comment comment, List<ReplyResponseDto> replyList) {
        return new GetReplyListWithCommentResponseDto(
            comment.getId(),
            comment.getComment(),
            comment.getCreatedAt(),
            comment.getUpdatedAt(),
            comment.getSchedule().getWriterId(),
            comment.getId(),
            replyList
        );
    }

}
