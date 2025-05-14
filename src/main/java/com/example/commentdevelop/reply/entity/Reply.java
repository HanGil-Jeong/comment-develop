package com.example.commentdevelop.reply.entity;

import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.common.entity.BaseEntity;
import com.example.commentdevelop.reply.dto.request.ReplyRequestDto;
import com.example.commentdevelop.schedule.entity.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "대댓글을 입력하세요")
    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Comment comment;

    public Reply(Schedule schedule, Comment comment, ReplyRequestDto replyRequestDto) {
        this.schedule = schedule;
        this.comment = comment;
        this.reply = replyRequestDto.getReply();
    }

    public void UpdateReply(ReplyRequestDto requestDto) {
        this.reply = requestDto.getReply();
    }

}
