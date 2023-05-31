package com.project3.teacherwanted.model.vo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "COMMENT_REPLY")
public class CommentReplyVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_reply_id")
    private Integer commentReplyId;
    private Integer courseCommentId;
    private Integer memId;
    private Integer teaId;
    private String replyContext;
    private Date createTime;
    private Date updateTime;
}
