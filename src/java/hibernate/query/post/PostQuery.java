package hibernate.query.post;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Posts;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostQuery {
    
    public void insertPost(Posts acc) {
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
    
    public List firstPagePosts(long id) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Posts where wookId=:id order by autoId desc");
            safehqlquery.setParameter("id", id);
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
    
    public List Posts(long id, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if(isForward){
                safehqlquery = sess.createQuery("from Posts where wookId=:id and autoId>:pagination order by autoId asc");
            }else{
                safehqlquery = sess.createQuery("from Posts where wookId=:id and autoId<:pagination order by autoId desc");
            }
            safehqlquery.setParameter("id", id);
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

    public boolean isPagination(long id, long pagination_id, boolean isForward) {
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
                        safehqlquery = sess.createQuery("from Posts where wookId=:id and autoId>:pagination");
                    }else{
                        safehqlquery = sess.createQuery("from Posts where wookId=:id and autoId<:pagination");
                    }
            safehqlquery.setParameter("id", id);
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
