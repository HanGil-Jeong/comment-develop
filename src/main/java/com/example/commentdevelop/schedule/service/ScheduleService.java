package com.example.commentdevelop.schedule.service;

import com.example.commentdevelop.comment.dto.response.CommentResponseDto;
import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.comment.repository.CommentRepository;
import com.example.commentdevelop.schedule.dto.request.CreateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.response.GetScheduleWhitCommentResponseDto;
import com.example.commentdevelop.schedule.dto.response.ScheduleResponseDto;
import com.example.commentdevelop.schedule.dto.response.UpdateScheduleResponseDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import com.example.commentdevelop.schedule.repository.ScheduleRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(CreateScheduleRequestDto requestDto) {

        Schedule savedSchedule = scheduleRepository.save(new Schedule(requestDto));

        return ScheduleResponseDto.toDto(savedSchedule);
    }

    public List<ScheduleResponseDto> getScheduleList() {
        return scheduleRepository.findAll()
            .stream()
            .map(ScheduleResponseDto::toDto)
            .toList();
    }

    @Transactional
    public GetScheduleWhitCommentResponseDto getSchedule(Long id) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        List<Comment> comments = commentRepository.findByScheduleId(id);

        List<CommentResponseDto> commentResponseDtoList = comments.stream()
            .map(CommentResponseDto::toDto)
            .collect(Collectors.toList());

        return GetScheduleWhitCommentResponseDto.from(schedule, commentResponseDtoList);
    }

    @Transactional
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        schedule.updateSchedule(requestDto);

        return UpdateScheduleResponseDto.from(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(schedule);
    }
}
