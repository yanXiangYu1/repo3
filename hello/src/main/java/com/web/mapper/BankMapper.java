package com.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface BankMapper {
    @Update("update bank set money = money + #{money} where username = #{username}")
    void addMoney(@Param("username")String username,@Param("money") int i);

    @Update("update bank set money = money - #{money} where username = #{username}")
    void loseMoney(@Param("username")String username,@Param("money") int i);
}
