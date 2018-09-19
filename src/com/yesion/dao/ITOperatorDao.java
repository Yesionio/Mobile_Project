package com.yesion.dao;

import com.yesion.pojo.TOperator;

import java.util.List;

public interface ITOperatorDao {
    TOperator queryByIdAndPwd(String id, String pwd);

    List queryOperator();

}
