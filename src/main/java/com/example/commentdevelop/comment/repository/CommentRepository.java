package com.example.commentdevelop.comment.repository;

import com.example.commentdevelop.comment.dto.response.CommentResponseDto;
import com.example.commentdevelop.comment.entity.Comment;
import java.util.List;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByScheduleId(Long scheduleId);

    default Comment findByIdOrElseThrow(Long commentId) {
        return findById(commentId).orElseThrow(()-> new RuntimeException("일정을 찾을 수 없습니다."));
    }

    int countCommentByScheduleId(Long scheduleId);

}
