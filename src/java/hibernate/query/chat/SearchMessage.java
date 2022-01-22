package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SearchMessage {

    public List getSearchMessage(long user, String query) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Userchatlist tb4, Primaryinfo tb5, Online tb6, Usermessages tb1 inner join tb1.messages tb2 where tb1.autoId=(select max(tb3.autoId) from Usermessages tb3 where tb3.operId=tb1.operId and tb4.autoId=tb3.operId and (tb4.userOne=:user or tb4.userTwo=:user) and tb5.userId=(case when tb4.userOne=:user then tb4.userTwo else tb4.userOne end) and (concat(tb5.firstName,' ',tb5.lastName) like :query) and tb3.deletedOne<>:user and tb3.deletedTwo<>:user and tb3.getback=false) and tb1.autoId=tb2.msgId and tb6.userId=tb5.userId order by tb1.autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("query", "%\\" + query + "%");
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
}
