package com.example.commentdevelop.schedule.entity;

import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.common.entity.BaseEntity;
import com.example.commentdevelop.schedule.dto.request.CreateScheduleRequestDto;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int commentCnt;

    @Column(nullable = false)
    private Long writerId;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(CreateScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writerId = requestDto.getWriterId();
    }

    public void updateSchedule(UpdateScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void increaseCommentCnt() {
        this.commentCnt++;
    }

    public void decreaseCommentCnt() {
        if(commentCnt > 0) {
            this.commentCnt--;
        }
    }
}
