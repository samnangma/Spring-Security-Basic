package com.example.springsecurity.repository;

import com.example.springsecurity.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@Repository
public interface UserRepository {
    @Select("select * from accounttb where email like #{email}")
    Account findUserByEmail(String email);

}
