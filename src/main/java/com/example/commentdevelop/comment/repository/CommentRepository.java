package com.example.commentdevelop.comment.repository;

import com.example.commentdevelop.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
