package com.jr.sportplay.dao;

import com.jr.sportplay.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUsers(@Param("username") String username,@Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
    public int getCount(@Param("username")String username);
    public int updateState(@Param("id") int id,@Param("state") boolean state);
    public int addUser(User user);
    public int deleteUser(@Param("id") int id);
    public User getUpdateUser(@Param("id") int id);
    public int editUser(User user);
}
