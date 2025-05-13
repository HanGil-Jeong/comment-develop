package com.example.commentdevelop.reply.controller;

import com.example.commentdevelop.reply.dto.request.ReplyRequestDto;
import com.example.commentdevelop.reply.dto.response.GetReplyListWithCommentResponseDto;
import com.example.commentdevelop.reply.dto.response.ReplyResponseDto;
import com.example.commentdevelop.reply.dto.response.UpdateReplyResponseDto;
import com.example.commentdevelop.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedules/{scheduleId}/comments/{commentId}/replies")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<ReplyResponseDto> createReply(
        @PathVariable("scheduleId") Long scheduleId,
        @PathVariable("commentId") Long commentId,
        @Valid @RequestBody ReplyRequestDto requestDto
    ) {
        ReplyResponseDto replyResponseDto = replyService.createReply(scheduleId, commentId, requestDto);

        return new ResponseEntity<>(replyResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GetReplyListWithCommentResponseDto> getReplies(
        @PathVariable("commentId") Long commentId) {

        GetReplyListWithCommentResponseDto replies = replyService.getReplies(commentId);

        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

    @PatchMapping("/{replyId}")
    public ResponseEntity<UpdateReplyResponseDto> updateReply(
        @PathVariable("scheduleId") Long scheduleId,
        @PathVariable("commentId") Long commentId,
        @PathVariable("replyId") Long replyId,
        @Valid @RequestBody ReplyRequestDto requestDto
    ) {
        UpdateReplyResponseDto updateReplyResponseDto = replyService.updateReply(scheduleId,
            commentId, replyId, requestDto);

        return new ResponseEntity<>(updateReplyResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(
        @PathVariable("scheduleId") Long scheduleId,
        @PathVariable("commentId") Long commentId,
        @PathVariable("replyId") Long replyId
    ) {
        replyService.deleteReply(scheduleId, commentId, replyId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
