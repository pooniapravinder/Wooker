package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Blocklist;
import hibernate.mapping.Disabledata;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BlockDisable {

    public void insertBlock(Blocklist acc) {
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

    public void insertDisable(Disabledata acc) {
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

    public boolean isBlocked(long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Blocklist blocked = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Blocklist where userId=:user and targetId=:id order by autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            blocked = (Blocklist) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return ((blocked != null)&&(blocked.isBlockedUser()));
    }

    public boolean isDisabled(String id) {
        Session sess = null;
        Transaction tx = null;
        Disabledata disabled = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Disabledata where targetId=:id order by autoId desc");
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            disabled = (Disabledata) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return ((disabled != null)&&(disabled.isDisabled()));
    }
}
