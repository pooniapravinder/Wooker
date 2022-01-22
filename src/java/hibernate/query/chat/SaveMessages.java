package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Messages;
import hibernate.mapping.Starredmessages;
import hibernate.mapping.Usermessages;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveMessages {

    public void InsertUserMessage(Usermessages acc) {
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

    public void InsertMessage(Messages acc) {
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
    
    public void InsertStarMessage(Starredmessages acc) {
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

    public boolean isStarredMsg(long defaultId, long user) {
        Session sess = null;
        Transaction tx = null;
        Starredmessages id = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Starredmessages tb1 where tb1.starredmsgId=:defaultId and tb1.userId=:user");
            safehqlquery.setParameter("defaultId", defaultId);
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            id = (Starredmessages) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return id != null;
    }

    public long getLastMsgId(long defaultId, long user) {
        Session sess = null;
        Transaction tx = null;
        Usermessages id = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Usermessages tb1 where tb1.operId=:defaultId and tb1.sender=:user order by tb1.autoId desc");
            safehqlquery.setParameter("defaultId", defaultId);
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            id = (Usermessages) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return id != null ? id.getAutoId() : 0;
    }

    public void InsertGetBack(long id) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.getback=true where autoId=:id");
            safehqlquery.setParameter("id", id);
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

    public void InsertDelete(long id, long user, boolean isDeletedOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (!isDeletedOne) {
                safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.deletedOne=:user where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.deletedTwo=:user where autoId=:id");
            }
            safehqlquery.setParameter("id", id);
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

    public void RemoveStar(long defaultId, long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("delete from Starredmessages tb1 where tb1.starredmsgId=:defaultId and tb1.userId=:user");
            safehqlquery.setParameter("defaultId", defaultId);
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

    public void InsertUnread(long id, long operId) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Usermessages tb1 set tb1.chatpageRead=false,tb1.seenTimestamp=0 where tb1.operId=:operId and tb1.autoId>:id");
            safehqlquery.setParameter("id", id);
            safehqlquery.setParameter("operId", operId);
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
