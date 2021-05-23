package com.demo.book.repository;

import com.demo.book.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    User selectByUserName(String uname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Boolean isUserNameExist(String uname);
}
