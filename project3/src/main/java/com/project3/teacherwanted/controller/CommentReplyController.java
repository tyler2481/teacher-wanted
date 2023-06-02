package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.vo.CommentReplyVo;
import com.project3.teacherwanted.service.CommentReplyService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentReplyController {
    @Autowired
    private CommentReplyService commentReplyService;

    @GetMapping("/replies")
    public ResponseEntity<List<CommentReplyVo>> findAll() {
        List<CommentReplyVo> commentReplies = commentReplyService.findAll();
        return new ResponseEntity<>(commentReplies, HttpStatus.OK);
    }

    @GetMapping("/replies/{commentId}")
    public ResponseEntity<List<CommentReplyVo>> getRepliesByCommentId(@PathVariable("commentId") Integer commentReplyId) {
        List<CommentReplyVo> commentReplies = commentReplyService.getRepliesByCommentId(commentReplyId);
        return new ResponseEntity<>(commentReplies, HttpStatus.OK);
    }

    @GetMapping("/reply/{id}")
    public ResponseEntity<CommentReplyVo> getReplyById(@PathVariable("id") Integer id) {
        CommentReplyVo commentReply = commentReplyService.getReplyById(id);
        return new ResponseEntity<>(commentReply, HttpStatus.OK);
    }

    @PostMapping("/reply")
    public ResponseEntity<Void> createReply(@RequestBody @Valid CommentReplyVo commentReply) {
        commentReplyService.createReply(commentReply);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/reply/{id}")
    public ResponseEntity<Void> updateReply(@PathVariable("id") Integer id, @RequestBody @Valid CommentReplyVo commentReply) {
        commentReply.setCourseCommentId(id);
        commentReplyService.updateReply(commentReply);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/reply/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable("id") Integer id) {
        commentReplyService.deleteReply(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/replies/{commentId}")
    public ResponseEntity<Object> deleteRepliesByCommentId(@PathVariable("commentId") Integer commentId) {
        commentReplyService.deleteRepliesByCommentId(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
