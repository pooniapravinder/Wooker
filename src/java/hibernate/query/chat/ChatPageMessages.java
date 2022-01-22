package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChatPageMessages {
    
    public List firstChatpageMessage(long defaultId, long user) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Usermessages tb1 inner join tb1.messages tb2 where tb1.operId=:defaultId and tb1.autoId=tb2.msgId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false order by tb1.autoId desc");
            safehqlquery.setParameter("defaultId", defaultId);
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(20);
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
    
    public List ChatpageMessage(long defaultId, long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if(isForward){
                safehqlquery = sess.createQuery("from Usermessages tb1 left join tb1.messages tb2 where tb1.operId=:defaultId and tb1.autoId=tb2.msgId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId>:pagination order by tb1.autoId asc");
            }else{
                safehqlquery = sess.createQuery("from Usermessages tb1 left join tb1.messages tb2 where tb1.operId=:defaultId and tb1.autoId=tb2.msgId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId<:pagination order by tb1.autoId desc");
            }
            safehqlquery.setParameter("defaultId", defaultId);
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setMaxResults(20);
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

    public boolean isPagination(long defaultId, long user, long pagination_id, boolean isForward) {
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
                        safehqlquery = sess.createQuery("from Usermessages tb1 where tb1.operId=:defaultId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId>:pagination");
                    }else{
                        safehqlquery = sess.createQuery("from Usermessages tb1 where tb1.operId=:defaultId and tb1.deletedOne<>:user and tb1.deletedTwo<>:user and tb1.getback=false and tb1.autoId<:pagination");
                    }
            safehqlquery.setParameter("defaultId", defaultId);
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
    
    public Object getMessageById(long id) {
        Session sess = null;
        Transaction tx = null;
        Object data = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Messages tb1 inner join tb1.usermessages tb2 where tb2.autoId=:id and tb1.msgId=tb2.autoId");
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            data = (Object) safehqlquery.uniqueResult();
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
}