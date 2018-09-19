package com.yesion.dao.impl;

import com.yesion.dao.ITCustomerDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ITCustomerDaoImpl implements ITCustomerDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public int queryIdNumCount(String idNumber) {
        String queryHql = "select count(*) from TCustomer where idNumber=:idNumber";

        Session session = sessionFactory.openSession();
        int count = ((Number)session
                .createQuery(queryHql)
                .setParameter("idNumber", idNumber)
                .uniqueResult()).intValue();

        session.close();
        return count;
    }
}
