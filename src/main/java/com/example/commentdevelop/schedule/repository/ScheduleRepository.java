package com.example.commentdevelop.schedule.repository;

import com.example.commentdevelop.schedule.entity.Schedule;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAll();

}
