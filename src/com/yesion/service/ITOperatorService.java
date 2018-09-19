package com.yesion.service;

import com.yesion.pojo.TOperator;

import java.util.List;

public interface ITOperatorService {
    TOperator LoginService(String id, String pwd);

    boolean SaveOperator(TOperator operator);

    List queryOperator();

    boolean updateOperatorService(TOperator operator);
}
