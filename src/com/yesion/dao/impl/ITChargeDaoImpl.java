package com.yesion.dao.impl;

import com.yesion.dao.ITChargeDao;
import com.yesion.pojo.TCharge;
import com.yesion.pojo.TCharge_Rule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ITChargeDaoImpl implements ITChargeDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List queryCharge() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from TCharge").getResultList();
    }

    @Override
    public List queryChargeRule() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from TCharge_Rule").getResultList();
    }

    @Override
    public void deleteAllData(String funcId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hqlDelete = "delete from TCharge_Rule where funcId=:id";
        int deletedEntities = session.createQuery(hqlDelete)
                .setParameter("id", funcId)
                .executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public boolean insertAllData(TCharge_Rule[] rules) {
        boolean flag = false;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            for (TCharge_Rule rule: rules) {
                session.save(rule);
            }
            tx.commit();
            flag = true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }


}
