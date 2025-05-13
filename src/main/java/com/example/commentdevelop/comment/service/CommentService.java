package com.example.commentdevelop.comment.service;

import com.example.commentdevelop.comment.dto.request.CreateCommentRequestDto;
import com.example.commentdevelop.comment.dto.request.UpdateCommentRequestDto;
import com.example.commentdevelop.comment.dto.response.CommentResponseDto;
import com.example.commentdevelop.comment.dto.response.UpdateCommentResponseDto;
import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.comment.repository.CommentRepository;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.response.UpdateScheduleResponseDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import com.example.commentdevelop.schedule.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponseDto createComment(
        Long scheduleId,
        CreateCommentRequestDto requestDto
    ) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        Comment comment = commentRepository.save(new Comment(schedule, requestDto));

        return CommentResponseDto.toDto(comment);
    }

    @Transactional
    public List<CommentResponseDto> getCommentList(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        return commentRepository.findAll()
            .stream()
            .map(CommentResponseDto::toDto)
            .toList();
    }

    @Transactional
    public CommentResponseDto getComment(Long scheduleId, Long commentId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(()-> new RuntimeException("댓글을 찾을 수 없습니다."));

        return CommentResponseDto.toDto(comment);

    }

    @Transactional
    public UpdateCommentResponseDto updateComment(Long scheduleId, Long commentId,
        UpdateCommentRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(()-> new RuntimeException("댓글을 찾을 수 없습니다."));

        comment.updateComment(requestDto);

        return UpdateCommentResponseDto.from(comment);
    }

    @Transactional
    public void deleteComment(Long scheduleId, Long commentId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(()-> new RuntimeException("댓글을 찾을 수 없습니다."));

        commentRepository.delete(comment);

    }
}
