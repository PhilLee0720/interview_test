package com.lee.dao;

import com.lee.config.MyBatisConfig;
import com.lee.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * user数据访问层
 * 对应表  user
 */
public interface UserDao {


   User getUserByUserName(@Param("username")String username);

    Integer saveUser(@Param("username")String username,@Param("password")String password);
}
