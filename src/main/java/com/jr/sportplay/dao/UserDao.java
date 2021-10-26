package com.jr.sportplay.dao;

import com.jr.sportplay.bean.User;
import lombok.experimental.PackagePrivate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
public interface UserDao {
    public User getUserByMassage(@Param("username") String username, @Param("password") String password);
}
