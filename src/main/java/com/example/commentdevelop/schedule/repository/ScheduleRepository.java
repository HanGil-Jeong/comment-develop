package com.example.commentdevelop.schedule.repository;

import com.example.commentdevelop.schedule.entity.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));
    }

    List<Schedule> findAll();

}
