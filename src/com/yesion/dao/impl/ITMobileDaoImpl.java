package com.yesion.dao.impl;

import com.yesion.dao.ITMobileDao;
import com.yesion.pojo.TMobiles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ITMobileDaoImpl implements ITMobileDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public boolean saveAllMobile(String[] mobs, String type) {
        boolean flag = false;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            TMobiles mobiles = null;
            for (String mob: mobs) {
                mobiles = new TMobiles(mob, type, null, "Y");
                session.save(mobiles);
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

    @Override
    public int queryNumCount(String number) {
        String queryHql = "select count(*) from TMobiles where mobileNumber=:number";

        Session session = sessionFactory.openSession();
        int count = ((Number)session
                .createQuery(queryHql)
                .setParameter("number", number)
                .uniqueResult()).intValue();

        session.close();
        return count;
    }
}
