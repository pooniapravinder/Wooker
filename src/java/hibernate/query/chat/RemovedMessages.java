package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedMessages {
    
    public List firstRemovedPageMessage(long user) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Usermessages tb1 inner join tb1.messages tb2 where tb1.autoId=(select max(tb3.autoId) from Usermessages tb3,Userchatlist tb4 where tb3.operId=tb1.operId and tb4.autoId=tb3.operId and tb4.removed=true and (tb4.userOne=:user or tb4.userTwo=:user) and tb3.deletedOne<>:user and tb3.deletedTwo<>:user and tb3.getback=false) and tb1.autoId=tb2.msgId order by tb1.autoId desc");
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
    
    public List RemovedMessage(long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if(isForward){
                safehqlquery = sess.createQuery("from Usermessages tb1 left join tb1.messages tb2 where tb1.autoId=(select max(tb3.autoId) from Usermessages tb3,Userchatlist tb4 where tb3.operId=tb1.operId and tb4.autoId=tb3.operId and tb4.removed=true and (tb4.userOne=:user or tb4.userTwo=:user) and tb3.deletedOne<>:user and tb3.deletedTwo<>:user and tb3.getback=false) and tb1.autoId=tb2.msgId and tb1.autoId>:pagination order by tb1.autoId asc");
            }else{
                safehqlquery = sess.createQuery("from Usermessages tb1 left join tb1.messages tb2 where tb1.autoId=(select max(tb3.autoId) from Usermessages tb3,Userchatlist tb4 where tb3.operId=tb1.operId and tb4.autoId=tb3.operId and tb4.removed=true and (tb4.userOne=:user or tb4.userTwo=:user) and tb3.deletedOne<>:user and tb3.deletedTwo<>:user and tb3.getback=false) and tb1.autoId=tb2.msgId and tb1.autoId<:pagination order by tb1.autoId desc");
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
                        safehqlquery = sess.createQuery("from Usermessages tb1 where tb1.autoId=(select max(tb3.autoId) from Usermessages tb3,Userchatlist tb4 where tb3.operId=tb1.operId and tb4.autoId=tb3.operId and tb4.removed=true and (tb4.userOne=:user or tb4.userTwo=:user) and tb3.deletedOne<>:user and tb3.deletedTwo<>:user and tb3.getback=false) and tb1.autoId>:pagination");
                    }else{
                        safehqlquery = sess.createQuery("from Usermessages tb1 where tb1.autoId=(select max(tb3.autoId) from Usermessages tb3,Userchatlist tb4 where tb3.operId=tb1.operId and tb4.autoId=tb3.operId and tb4.removed=true and (tb4.userOne=:user or tb4.userTwo=:user) and tb3.deletedOne<>:user and tb3.deletedTwo<>:user and tb3.getback=false) and tb1.autoId<:pagination");
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
