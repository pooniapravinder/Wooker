package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Accounts;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GetUser {

    public Accounts getUserbyId(long id) {
        Session sess = null;
        Transaction tx = null;
        Accounts account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Accounts where userId=:id");
            safehqlquery.setParameter("id", id);
            account = (Accounts) safehqlquery.uniqueResult();
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
