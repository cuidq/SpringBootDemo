package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/3/5 11:31
 * @Description:
 */
@Mapper
public interface AccountDao {

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(Account account);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(Account account);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    Account findAccountById(int id);

    @Select("select id, name as name, money as money from account")
    List<Account> findAccountList();

}
