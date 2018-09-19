package com.yesion.dao.impl;

import com.yesion.dao.ITOperatorDao;
import com.yesion.pojo.TOperator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ITOperatorDaoImpl implements ITOperatorDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public TOperator queryByIdAndPwd(String id, String pwd) {
        Session session = sessionFactory.openSession();
        TOperator tOperator = (TOperator)session.createQuery("from TOperator where operatorId=:id and operatorPwd=:pwd")
                .setParameter("id", id).setParameter("pwd", pwd).uniqueResult();
        session.close();
        return tOperator;
    }

    @Override
    public List queryOperator() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from TOperator").getResultList();

    }


}
