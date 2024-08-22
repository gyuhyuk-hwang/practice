package com.example.board.model.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.*;

public class QBoard extends EntityPathBase<Board> {
    private static final long serialVersionUID = 2047104154L;
    public static final QBoard board = new QBoard("board");
    public final NumberPath<Long> boardNo = this.createNumber("boardNo", Long.class);
    public final EnumPath<BoardStatus> boardStatus = this.createEnum("boardStatus", BoardStatus.class);
    public final StringPath body = this.createString("body");
    public final ListPath<Comment, QComment> comments;
    public final StringPath title;

    public QBoard(String variable) {
        super(Board.class, PathMetadataFactory.forVariable(variable));
        this.comments = this.createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);
        this.title = this.createString("title");
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
        this.comments = this.createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);
        this.title = this.createString("title");
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
        this.comments = this.createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);
        this.title = this.createString("title");
    }
}
