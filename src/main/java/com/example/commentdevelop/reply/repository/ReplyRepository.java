package com.example.commentdevelop.reply.repository;

import com.example.commentdevelop.comment.entity.Comment;
import com.example.commentdevelop.reply.entity.Reply;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    default Reply findByIdOrElseThrow(Long replyId) {
        return findById(replyId).orElseThrow(()-> new RuntimeException("대댓글을 찾을 수 없습니다."));
    }

    List<Reply> findAllByCommentId(Long commentId);

}
