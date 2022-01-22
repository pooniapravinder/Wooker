package hibernate.query.info;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Devicedetails;
import hibernate.mapping.Primaryinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InfoAction {

    public void addPrimaryInfo(Primaryinfo acc) {
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

    public Primaryinfo getPriInfo(long user) {
        Session sess = null;
        Transaction tx = null;
        Primaryinfo account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Primaryinfo where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            account = (Primaryinfo) safehqlquery.uniqueResult();
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
    
    public Object getInfoUpdate(long user) {
        Session sess = null;
        Transaction tx = null;
        Object getData = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select (select count(autoId) from Primaryinfo where primaryUpdate=true and userId=:user),timestampVal from Primaryinfo where primaryUpdate=true and userId=:user order by autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            getData = (Object) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return getData;
    }

    public void UpdateEmailPhone(String emailidPhone, long autoid) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Primaryinfo set emailidPhone=:emailidPhone where autoId=:autoid");
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

    public void UpdatePrimaryInfo(String firstName, String lastName, String gender, String birthDay, String emailidPhone, long timestamp, long autoid) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Primaryinfo set firstName=:firstName,lastName=:lastName,gender=:gender,birthDay=:birthDay,timestampVal=:timestamp,emailidPhone=:emailidPhone where autoId=:autoid");
            safehqlquery.setParameter("firstName", firstName);
            safehqlquery.setParameter("lastName", lastName);
            safehqlquery.setParameter("gender", gender);
            safehqlquery.setParameter("birthDay", birthDay);
            safehqlquery.setParameter("timestamp", timestamp);
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

    public void UpdateDeviceInfo(Devicedetails details, String autoid) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Devicedetails set deviceType=:type,deviceOs=:os,deviceResolution=:resolution,browserName=:name,browserVersion=:version,clientIp=:ip,location=:location where autoId=:autoid");
            safehqlquery.setParameter("type", details.getDeviceType());
            safehqlquery.setParameter("os", details.getDeviceOs());
            safehqlquery.setParameter("resolution", details.getDeviceResolution());
            safehqlquery.setParameter("name", details.getBrowserName());
            safehqlquery.setParameter("version", details.getBrowserVersion());
            safehqlquery.setParameter("ip", details.getClientIp());
            safehqlquery.setParameter("location", details.getLocation());
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
