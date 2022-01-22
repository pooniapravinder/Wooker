package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Primaryinfo;
import hibernate.mapping.Searches;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SearchQuery {

    public void InsertSearch(Searches search) {
        Session sess = null;
        Transaction tr = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tr = sess.getTransaction();
            sess.getTransaction().setTimeout(1000);
            tr.begin();
            sess.save(search);
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

    public List<Primaryinfo> getSearchResult(String query, long user, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Primaryinfo> listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Primaryinfo tb1 where (concat(tb1.firstName,' ',tb1.lastName) like :query or tb1.emailidPhone like :query) and tb1.userId<>:user and (select case when tb3.blocked=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userId and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userId))))=null and (select max(tb2.userId) from Accounts tb2 where tb2.userId=tb1.userId and tb2.verifiedAccount=true)<>null order by tb1.autoId desc");
            safehqlquery.setParameter("query", "%\\" + query + "%");
            safehqlquery.setParameter("user", user);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            listdata = (List<Primaryinfo>) safehqlquery.list();
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

    public Long SearchResultTotal(String query, long user) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(tb1.autoId) from Primaryinfo tb1 where (tb1.firstName like :query or tb1.lastName like :query or tb1.emailidPhone like :query) and tb1.userId<>:user and (select case when tb3.blocked=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userId and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userId))))=null and (select max(tb2.userId) from Accounts tb2 where tb2.userId=tb1.userId and tb2.verifiedAccount=true)<>null");
            safehqlquery.setParameter("query", "%\\" + query + "%");
            safehqlquery.setParameter("user", user);
            count_page = (Long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return count_page;
    }
}
