package com.demo.book.service;

import com.demo.book.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public User selectByUserName(String uname) {
        return userMapper.selectByUserName(uname);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public Boolean isUserNameExist(String uname) {
        return userMapper.isUserNameExist(uname);
    }
}
