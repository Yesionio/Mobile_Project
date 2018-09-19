package com.yesion.service.impl;

import com.yesion.dao.ITOperatorDao;
import com.yesion.dao.UtilDao;
import com.yesion.pojo.TOperator;
import com.yesion.service.ITOperatorService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ITOperatorServiceImpl implements ITOperatorService {

    private ITOperatorDao itOperatorDao;

    private UtilDao utilDao;

    public void setItOperatorDao(ITOperatorDao itOperatorDao) {
        this.itOperatorDao = itOperatorDao;
    }

    public ITOperatorDao getItOperatorDao() {
        return itOperatorDao;
    }

    public UtilDao getUtilDao() {
        return utilDao;
    }

    public void setUtilDao(UtilDao utilDao) {
        this.utilDao = utilDao;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public TOperator LoginService(String id, String pwd) {
        return itOperatorDao.queryByIdAndPwd(id, pwd);
    }

    @Override
    @Transactional
    public boolean SaveOperator(TOperator operator) {
        return utilDao.save(operator);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List queryOperator() {
        return itOperatorDao.queryOperator();
    }

    @Override
    @Transactional
    public boolean updateOperatorService(TOperator operator) {
        return utilDao.update(operator);
    }
}
