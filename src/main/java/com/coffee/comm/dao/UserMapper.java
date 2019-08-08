package com.coffee.comm.dao;

import com.coffee.comm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    void insertUser(User user);
}
