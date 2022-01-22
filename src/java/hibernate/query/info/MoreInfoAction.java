package hibernate.query.info;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Secondaryinfo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MoreInfoAction {

    public void addSecondaryInfo(Secondaryinfo acc) {
        Session sess = null;
        Transaction tr = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tr = sess.getTransaction();
            sess.getTransaction().setTimeout(1000);
            tr.begin();
            sess.save(acc);
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

    public List<Secondaryinfo> getSecInfo(long user) {
        Session sess = null;
        Transaction tx = null;
        List<Secondaryinfo> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Secondaryinfo tb1 where userId=:user and autoId = (select max(tb2.autoId) from Secondaryinfo tb2 where tb2.defaultId=tb1.defaultId ) and deleted=false order by tb1.autoId asc");
            safehqlquery.setParameter("user", user);
            account = (List<Secondaryinfo>) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return account;
    }

    public Secondaryinfo getSingleSecInfo(String id, long user) {
        Session sess = null;
        Transaction tx = null;
        Secondaryinfo account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Secondaryinfo where defaultId=:id and userId=:user order by autoId desc");
            safehqlquery.setParameter("id", id);
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            account = (Secondaryinfo) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return account;
    }
    
}
