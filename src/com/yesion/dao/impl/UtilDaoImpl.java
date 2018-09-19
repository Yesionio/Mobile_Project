package com.yesion.dao.impl;

import com.yesion.dao.UtilDao;
import com.yesion.pojo.ThePojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UtilDaoImpl implements UtilDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean save(ThePojo pojo) {
        boolean flag = false;
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(pojo);
            tx.commit();
            flag = true;
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        session.close();
        return flag;
    }

    @Override
    public boolean update(ThePojo pojo) {
        boolean flag = false;
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.update(pojo);
            tx.commit();
            flag = true;
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        session.close();
        return flag;
    }
}
