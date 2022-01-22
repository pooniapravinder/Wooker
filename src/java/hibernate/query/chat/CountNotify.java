package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CountNotify {
    
    public Long countMessage(long id,long user) {
        Session sess = null;
        Transaction tx = null;
        Long listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Usermessages tb1 where tb1.operId=:id and tb1.receiver=:user and tb1.chatpageRead=false and tb1.getback=false");
            safehqlquery.setParameter("id", id);
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            listdata = (Long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return listdata;
    }
    
    public Long countAlertMessage(long user) {
        Session sess = null;
        Transaction tx = null;
        Long count = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(distinct tb1.operId) from Usermessages tb1, Userchatlist tb2 where tb1.receiver=:user and tb1.operId=tb2.autoId and tb2.request=true and tb1.sender<>tb2.muteOne and tb1.sender<>tb2.muteTwo and tb1.chatRead=false and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            count = (Long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return count;
    }
    
    public Long countAlertSentMessage(long user) {
        Session sess = null;
        Transaction tx = null;
        Long count = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(distinct tb1.operId) from Usermessages tb1, Userchatlist tb2 where tb1.receiver=:user and tb1.operId=tb2.autoId and tb2.request=true and tb1.sender<>tb2.muteOne and tb1.sender<>tb2.muteTwo and tb1.chatRead=false and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            count = (Long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return count;
    }
    
    public Long countChatMessage(long user) {
        Session sess = null;
        Transaction tx = null;
        Long count = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(distinct tb1.operId) from Usermessages tb1, Userchatlist tb2 where tb1.receiver=:user and tb1.operId=tb2.autoId and tb2.friend=true and tb1.sender<>tb2.muteOne and tb1.sender<>tb2.muteTwo and tb1.chatRead=false and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            count = (Long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return count;
    }
    
    public Long countSpamMessage(long user) {
        Session sess = null;
        Transaction tx = null;
        Long count = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(distinct tb1.operId) from Usermessages tb1, Userchatlist tb2 where tb1.receiver=:user and tb1.operId=tb2.autoId and tb2.friend=false and tb1.sender<>tb2.muteOne and tb1.sender<>tb2.muteTwo and tb2.request=false and tb1.chatRead=false and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            count = (Long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return count;
    }
    
}
