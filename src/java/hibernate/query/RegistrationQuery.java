package hibernate.query;

import org.hibernate.Transaction;
import org.hibernate.Session;
import hibernate.mapping.Accounts;
import HibernateUtility.SetHibernateUtility;
import org.hibernate.Query;

public class RegistrationQuery {

    public Accounts findAccount(String EmailPhone) {
        Session sess = null;
        Transaction tx = null;
        Accounts account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Accounts where emailidPhone=:emailphone");
            safehqlquery.setParameter("emailphone", EmailPhone);
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

    public void addAccount(Accounts acc) {
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

    public void UpdateAccount(long timestamp, String country, String emailidPhone, String password) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Accounts set creationTimestamp=:timestamp,verifiedAccount=false,twoStep=false,country=:country,password=:password where emailidPhone=:emailidPhone");
            safehqlquery.setParameter("timestamp", timestamp);
            safehqlquery.setParameter("country", country);
            safehqlquery.setParameter("emailidPhone", emailidPhone);
            safehqlquery.setParameter("password", password);
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

    public void UpdateEmailPhone(String emailidPhone, long autoid) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Accounts set emailidPhone=:emailidPhone where userId=:autoid");
            safehqlquery.setParameter("emailidPhone", emailidPhone);
            safehqlquery.setParameter("autoid", autoid);
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
}
