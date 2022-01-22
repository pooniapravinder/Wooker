package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Devicedetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeviceInfo {

    public Devicedetails getDeviceDetail(String id) {
        Session sess = null;
        Transaction tx = null;
        Devicedetails data = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Devicedetails where autoId=:id");
            safehqlquery.setParameter("id", id);
            data = (Devicedetails) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return data;
    }

    public void InsertDeviceInfo(Devicedetails details) {
        Session sess = null;
        Transaction tr = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tr = sess.getTransaction();
            sess.getTransaction().setTimeout(1000);
            tr.begin();
            sess.save(details);
            tr.commit();
            if (sess.getTransaction().isActive()) {
                System.out.println("Session is active");
            } else {
                System.out.println("Session is inactive");
            }
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
    }
}
