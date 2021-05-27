package com.demo.book.repository;

import com.demo.book.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    Comment[] selectByBookIdFromX(@Param("bid") Integer bid, @Param("index") Integer index);

    Integer getCommentCountByBid(Integer bid);
}
