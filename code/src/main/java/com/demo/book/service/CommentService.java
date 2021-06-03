package com.demo.book.service;

import com.demo.book.repository.CommentMapper;
import com.demo.book.model.Comment;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public Comment[] selectByBookIdAndPage(Integer bid, Integer page) {
        return commentMapper.selectByBookIdFromX(bid, (page - 1) * 5);
    }

    public Integer getCommentCountByBid(Integer bid) {
        return commentMapper.getCommentCountByBid(bid);
    }

    public void submitComment(Integer uid, Integer bid, String content) {
        Comment comment = new Comment();
        comment.setUid(uid);
        comment.setBid(bid);
        comment.setContent(content);
        comment.setTime(new Date());
        commentMapper.insertSelective(comment);
    }
}
