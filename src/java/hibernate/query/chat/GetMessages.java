package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Usermessages;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GetMessages {
    
    public Usermessages getMessageById(long id) {
        Session sess = null;
        Transaction tx = null;
        Usermessages data = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Usermessages tb1 where tb1.autoId=:id");
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            data = (Usermessages) safehqlquery.uniqueResult();
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
