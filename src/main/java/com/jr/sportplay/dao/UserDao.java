package com.jr.sportplay.dao;

import com.jr.sportplay.bean.User;
import lombok.experimental.PackagePrivate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
}
