package com.web.mapper;

import com.web.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface UserMapper {
    @Insert("inert into user values")
    void addUser();
    @Select("select * from user where username = #{0}")
    User findUser(String username);
}
