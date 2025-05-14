package com.example.commentdevelop.comment.controller;

import com.example.commentdevelop.comment.dto.request.CreateCommentRequestDto;
import com.example.commentdevelop.comment.dto.request.UpdateCommentRequestDto;
import com.example.commentdevelop.comment.dto.response.CommentResponseDto;
import com.example.commentdevelop.comment.dto.response.UpdateCommentResponseDto;
import com.example.commentdevelop.comment.service.CommentService;
import java.util.List;
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
@RequestMapping("/schedules/{scheduleId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
        @PathVariable Long scheduleId,
        @RequestBody CreateCommentRequestDto requestDto
    ) {
        CommentResponseDto commentResponseDto = commentService.createComment(scheduleId, requestDto);

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getCommentList(@PathVariable Long scheduleId) {

        List<CommentResponseDto> commentList = commentService.getCommentList(scheduleId);

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> getComment(
        @PathVariable Long scheduleId,
        @PathVariable Long commentId
    ) {
        CommentResponseDto comment = commentService.getComment(scheduleId, commentId);

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<UpdateCommentResponseDto> updateComment(
        @PathVariable Long scheduleId,
        @PathVariable Long commentId,
        @RequestBody UpdateCommentRequestDto requestDto
        ) {

        UpdateCommentResponseDto updateCommentResponseDto = commentService.updateComment(scheduleId,
            commentId, requestDto);

        return new ResponseEntity<>(updateCommentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
        @PathVariable Long scheduleId,
        @PathVariable Long commentId
    ) {
        commentService.deleteComment(scheduleId, commentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
