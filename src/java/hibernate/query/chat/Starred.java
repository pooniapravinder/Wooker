package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Starred {
    
    public List firstStarredPageMessage(long user) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Starredmessages tb3,Usermessages tb1 inner join tb1.messages tb2 where tb3.starmsgId=(select max(tb4.starmsgId) from Starredmessages tb4 where tb4.userId=:user and tb4.operId=tb1.operId) and tb1.autoId=tb3.starredmsgId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId=tb2.msgId order by tb3.starmsgId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(10);
            listdata = (List) safehqlquery.list();
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
    
    public List StarredMessage(long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if(isForward){
                safehqlquery = sess.createQuery("from Starredmessages tb3,Usermessages tb1 inner join tb1.messages tb2 where tb3.starmsgId=(select max(tb4.starmsgId) from Starredmessages tb4 where tb4.userId=:user and tb4.operId=tb1.operId) and tb1.autoId=tb3.starredmsgId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId=tb2.msgId and tb3.starmsgId>:pagination order by tb3.starmsgId asc");
            }else{
                safehqlquery = sess.createQuery("from Starredmessages tb3,Usermessages tb1 inner join tb1.messages tb2 where tb3.starmsgId=(select max(tb4.starmsgId) from Starredmessages tb4 where tb4.userId=:user and tb4.operId=tb1.operId) and tb1.autoId=tb3.starredmsgId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId=tb2.msgId and tb3.starmsgId<:pagination order by tb3.starmsgId desc");
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setMaxResults(10);
            listdata = (List) safehqlquery.list();
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

    public boolean isPagination(long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        boolean pagination = false;
        if(pagination_id==0) return false;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
                    if(isForward){
                        safehqlquery = sess.createQuery("from Starredmessages tb1,Usermessages tb2 where tb1.starmsgId=(select max(tb3.starmsgId) from Starredmessages tb3 where tb3.userId=:user and tb3.operId=tb1.operId) and tb2.autoId=tb1.starredmsgId and tb1.userId=:user and tb2.deletedOne<>:user and tb2.deletedTwo<>:user and tb2.getback=false and tb1.starmsgId>:pagination");
                    }else{
                        safehqlquery = sess.createQuery("from Starredmessages tb1,Usermessages tb2 where tb1.starmsgId=(select max(tb3.starmsgId) from Starredmessages tb3 where tb3.userId=:user and tb3.operId=tb1.operId) and tb2.autoId=tb1.starredmsgId and tb1.userId=:user and tb2.deletedOne<>:user and tb2.deletedTwo<>:user and tb2.getback=false and tb1.starmsgId<:pagination");
                    }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setMaxResults(1);
            pagination = safehqlquery.uniqueResult()!=null;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return pagination;
    }
}
