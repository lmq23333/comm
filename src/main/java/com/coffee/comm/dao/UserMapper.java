package com.coffee.comm.dao;

import com.coffee.comm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 * @author lmq
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * insertUser
     * @param user
     */
    void insertUser(User user);

    /**
     * findByToken
     * @param token
     * @return
     */
    User findByToken(@Param("token") String token);
}
