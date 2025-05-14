package com.example.commentdevelop.reply.service;

import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.comment.repository.CommentRepository;
import com.example.commentdevelop.reply.dto.request.ReplyRequestDto;
import com.example.commentdevelop.reply.dto.response.GetReplyListWithCommentResponseDto;
import com.example.commentdevelop.reply.dto.response.ReplyResponseDto;
import com.example.commentdevelop.reply.dto.response.UpdateReplyResponseDto;
import com.example.commentdevelop.reply.entity.Reply;
import com.example.commentdevelop.reply.repository.ReplyRepository;
import com.example.commentdevelop.schedule.entity.Schedule;
import com.example.commentdevelop.schedule.repository.ScheduleRepository;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ReplyResponseDto createReply(Long scheduleId, Long commentId,
        ReplyRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        Reply reply = replyRepository.save(new Reply(schedule, comment, requestDto));

        return ReplyResponseDto.toDto(reply);
    }

    public GetReplyListWithCommentResponseDto getReplies(Long commentId) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        List<Reply> replies = replyRepository.findAllByCommentId(commentId);

        List<ReplyResponseDto> replyList = replies.stream()
            .map(ReplyResponseDto::toDto)
            .toList();

        return GetReplyListWithCommentResponseDto.from(comment, replyList);
    }

    @Transactional
    public UpdateReplyResponseDto updateReply(Long scheduleId, Long commentId, Long replyId, ReplyRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        Reply reply = replyRepository.findByIdOrElseThrow(replyId);

        reply.UpdateReply(requestDto);

        return UpdateReplyResponseDto.from(reply);
    }

    @Transactional
    public void deleteReply(Long scheduleId, Long commentId, Long replyId) {

        replyRepository.deleteById(replyId);
    }
}
