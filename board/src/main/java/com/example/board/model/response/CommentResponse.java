package com.example.board.model.response;

import com.example.board.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentResponse {

    private Long commentNo;
    private String body;

    static public CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getCommentNo(), comment.getBody());
    }
}
