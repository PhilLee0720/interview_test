package com.lee.service;

import com.lee.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;

public interface UserService {
    User getUserByUserName(String username) throws IOException;
    Integer saveUser(String username,String password) throws IOException;
}
