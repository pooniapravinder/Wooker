package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReadMessages {
    
    public void ReadChatpageMsg(long id, long timestamp, long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.chatpageRead=true, tb1.chatRead=true, tb1.seenTimestamp=:timestamp where tb1.operId=:id and tb1.chatpageRead=false and tb1.sender<>:user");
            safehqlquery.setParameter("id", id);
            safehqlquery.setParameter("timestamp", timestamp);
            safehqlquery.setParameter("user", user);
            safehqlquery.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
    }
    
    public void ReadAlertMsg(long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.chatRead=true, tb1.seenTimestamp=:timestamp where tb1.chatRead=false and tb1.operId=(select tb2.autoId from Userchatlist tb2 where tb2.autoId=tb1.operId and tb2.request=true and tb2.userTwo=:user)");
            safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            safehqlquery.setParameter("user", user);
            safehqlquery.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
    }
    
    public void ReadAlertSentMsg(long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.chatRead=true, tb1.seenTimestamp=:timestamp where tb1.chatRead=false and tb1.operId=(select tb2.autoId from Userchatlist tb2 where tb2.autoId=tb1.operId and tb2.request=true and tb2.userOne=:user)");
            safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            safehqlquery.setParameter("user", user);
            safehqlquery.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
    }
    
    public void ReadChatMsg(long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.chatRead=true, tb1.seenTimestamp=:timestamp where tb1.chatRead=false and tb1.receiver=:user and tb1.operId=(select tb2.autoId from Userchatlist tb2 where tb2.autoId=tb1.operId and tb2.friend=true)");
            safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            safehqlquery.setParameter("user", user);
            safehqlquery.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
    }
    
    public void ReadSpamMsg(long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.chatRead=true, tb1.seenTimestamp=:timestamp where tb1.chatRead=false and tb1.receiver=:user and tb1.operId=(select tb2.autoId from Userchatlist tb2 where tb2.autoId=tb1.operId and tb2.friend=false and tb2.request=false)");
            safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            safehqlquery.setParameter("user", user);
            safehqlquery.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
    }
    
}
