package com.lee.service.impl;

import com.lee.config.MyBatisConfig;
import com.lee.dao.UserDao;
import com.lee.pojo.User;
import com.lee.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUserName(String username) throws IOException {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserByUserName(username);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public Integer saveUser(String username, String password) throws IOException {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Integer integer = mapper.saveUser(username, password);
        sqlSession.commit();
        sqlSession.close();
        return integer;
    }
}
