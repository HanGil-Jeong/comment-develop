package com.example.commentdevelop.schedule.controller;

import com.example.commentdevelop.schedule.dto.request.CreateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.response.ScheduleResponseDto;
import com.example.commentdevelop.schedule.dto.response.UpdateScheduleResponseDto;
import com.example.commentdevelop.schedule.service.ScheduleService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedeules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(
        // 요청 데이터 받기
        @RequestBody CreateScheduleRequestDto requestDto) {

        // 요청 데이터 Service에 넘기기
        ScheduleResponseDto schedule = scheduleService.createSchedule(requestDto);

        //응답 데이터 클라이언트에 전달
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getScheduleList() {

        List<ScheduleResponseDto> scheduleList = scheduleService.getScheduleList();

        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id) {

        ScheduleResponseDto schedule = scheduleService.getSchedule(id);

        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(
        @PathVariable Long id,
        @RequestBody UpdateScheduleRequestDto requestDto) {

        UpdateScheduleResponseDto updatedScheduleResponseDto = scheduleService.updateSchedule(id, requestDto);

        return new ResponseEntity<>(updatedScheduleResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {

        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
