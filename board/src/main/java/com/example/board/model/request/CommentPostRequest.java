package com.example.board.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentPostRequest {
    private Long boardNo;
    private String commentBody;
}
