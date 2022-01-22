package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SearchUserList {
    
    public List getSearchList(long user, String query) {
        Session sess = null;
        Transaction tx = null;
        List account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Online tb2, Primaryinfo tb3, Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and (tb1.blocked=true or tb1.friend=true or tb1.removed=true) and tb3.userId=(case when tb1.userOne=:user then tb1.userTwo else tb1.userOne end) and (concat(tb3.firstName,' ',tb3.lastName) like :query) and tb2.userId=tb3.userId order by tb1.autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("query", "%\\" + query + "%");
            safehqlquery.setMaxResults(20);
            account = (List) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return account;
    }
    
}
