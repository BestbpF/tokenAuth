package com.bpf.tokenAuth.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bpf.tokenAuth.entity.User;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results(@Result(column = "create_time", property = "createTime"))
    User findByName(String username);
}
