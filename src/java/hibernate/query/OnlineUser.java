package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Online;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OnlineUser {
    
    public void insertOnline(Online acc) {
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

    public void UpdateOnline(long user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Online set timestampVal=:timestamp where userId=:user");
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
    
    public long getOnline(long id) {
        Session sess = null;
        Transaction tx = null;
        long timestamp = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select timestampVal from Online where userId=:id");
            safehqlquery.setParameter("id", id);
            timestamp = (long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return timestamp;
    }
    
    public Long countOnline(long user) {
        Session sess = null;
        Transaction tx = null;
        Long listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Online tb1,Userchatlist tb2 where (tb2.userOne=:user or tb2.userTwo=:user) and tb2.friend=true and tb1.userId=(case when tb2.userOne=:user then tb2.userTwo else tb2.userOne end) and tb1.timestampVal>:timestamp");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("timestamp", (System.currentTimeMillis()-50000));
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
    
    public List<Long> getOnlineList(long user) {
        Session sess = null;
        Transaction tx = null;
        List<Long> timestamp = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select tb2 from Online tb1,Userchatlist tb2 where (tb2.userOne=:user or tb2.userTwo=:user) and tb2.friend=true and tb1.userId=(case when tb2.userOne=:user then tb2.userTwo else tb2.userOne end) and tb1.timestampVal>:timestamp order by tb2.autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("timestamp", (System.currentTimeMillis()-50000));
            safehqlquery.setMaxResults(30);
            timestamp = (List<Long>) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return timestamp;
    }
    
    public List OnlineList(long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if(isForward){
                safehqlquery = sess.createQuery("select tb2 from Online tb1,Userchatlist tb2 where (tb2.userOne=:user or tb2.userTwo=:user) and tb2.friend=true and tb1.userId=(case when tb2.userOne=:user then tb2.userTwo else tb2.userOne end) and tb1.timestampVal>:timestamp and tb2.autoId>:pagination order by tb2.autoId asc");
            }else{
                safehqlquery = sess.createQuery("select tb2 from Online tb1,Userchatlist tb2 where (tb2.userOne=:user or tb2.userTwo=:user) and tb2.friend=true and tb1.userId=(case when tb2.userOne=:user then tb2.userTwo else tb2.userOne end) and tb1.timestampVal>:timestamp and tb2.autoId<:pagination order by tb2.autoId desc");
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setParameter("timestamp", (System.currentTimeMillis()-50000));
            safehqlquery.setMaxResults(30);
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
                        safehqlquery = sess.createQuery("select tb1 from Online tb1,Userchatlist tb2 where (tb2.userOne=:user or tb2.userTwo=:user) and tb2.friend=true and tb1.userId=(case when tb2.userOne=:user then tb2.userTwo else tb2.userOne end) and tb1.timestampVal>:timestamp and tb2.autoId>:pagination");
                    }else{
                        safehqlquery = sess.createQuery("select tb1 from Online tb1,Userchatlist tb2 where (tb2.userOne=:user or tb2.userTwo=:user) and tb2.friend=true and tb1.userId=(case when tb2.userOne=:user then tb2.userTwo else tb2.userOne end) and tb1.timestampVal>:timestamp and tb2.autoId<:pagination");
                    }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setParameter("timestamp", (System.currentTimeMillis()-50000));
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
