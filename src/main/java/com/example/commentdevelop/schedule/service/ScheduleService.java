package com.example.commentdevelop.schedule.service;

import com.example.commentdevelop.schedule.dto.request.CreateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.response.ScheduleResponseDto;
import com.example.commentdevelop.schedule.dto.response.UpdateScheduleResponseDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import com.example.commentdevelop.schedule.repository.ScheduleRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

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
    public ScheduleResponseDto getSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        return ScheduleResponseDto.toDto(schedule);
    }

    @Transactional
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        schedule.updateSchedule(requestDto);

        return UpdateScheduleResponseDto.from(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));

        scheduleRepository.delete(schedule);
    }
}
