package com.project3.teacherwanted.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentReplies {
    private Integer commentReplyId;
    private Integer courseCommentId;
    private Integer memId;
    private Integer teaId;
    private String replyContent;
    private Date updateTime;
    private String memName;
    private byte[] memPhoto;
}
