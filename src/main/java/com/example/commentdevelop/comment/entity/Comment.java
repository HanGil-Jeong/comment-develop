package com.example.commentdevelop.comment.entity;

import com.example.commentdevelop.comment.dto.request.CreateCommentRequestDto;
import com.example.commentdevelop.comment.dto.request.UpdateCommentRequestDto;
import com.example.commentdevelop.common.entity.BaseEntity;
import com.example.commentdevelop.schedule.dto.request.UpdateScheduleRequestDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "댓글은 필수값입니다.")
    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn
    private Schedule schedule;

    public Comment(CreateCommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }

    public void updateComment(UpdateCommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}
