package com.example.board.model.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.*;

public class QComment extends EntityPathBase<Comment> {
    private static final long serialVersionUID = 1070511891L;
    private static final PathInits INITS;
    public static final QComment comment;
    public final QBoard board;
    public final StringPath body;
    public final NumberPath<Long> commentNo;
    public final EnumPath<CommentStatus> commentStatus;

    public QComment(String variable) {
        this(Comment.class, PathMetadataFactory.forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.body = this.createString("body");
        this.commentNo = this.createNumber("commentNo", Long.class);
        this.commentStatus = this.createEnum("commentStatus", CommentStatus.class);
        this.board = inits.isInitialized("board") ? new QBoard(this.forProperty("board")) : null;
    }

    static {
        INITS = PathInits.DIRECT2;
        comment = new QComment("comment");
    }
}
