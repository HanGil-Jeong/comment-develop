package com.example.commentdevelop.schedule.entity;

import com.example.commentdevelop.common.entity.BaseEntity;
import com.example.commentdevelop.schedule.dto.request.CreateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "일정 제목은 필수입니다")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "일정 내용은 필수입니다")
    @Column(nullable = false)
    private String content;

    @NotBlank(message = "작성자ID는 필수입니다.")
    @Column(nullable = false)
    private Long writerId;

    public Schedule(CreateScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writerId = requestDto.getWriterId();
    }

    public void updateSchedule(UpdateScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
