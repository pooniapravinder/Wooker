package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Validlogin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VerifyCookies {
public Validlogin findCookies(long timestamp,String qwed,String xcut){
        Session sess =null ;
       Transaction tx = null ;
 Validlogin account = null ;
try {                 
    sess =SetHibernateUtility.getSessionFactory().openSession();
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("from Validlogin where loginKey=:qwed and loginKeySet=:xcut and loginTimestamp>:timestamp");
safehqlquery.setParameter("qwed",qwed);
safehqlquery.setParameter("xcut",xcut);
safehqlquery.setParameter("timestamp",timestamp);
account = (Validlogin)safehqlquery.uniqueResult(); 
tx.commit();
}catch (Exception e){ 
 if(tx!=null){
 tx.rollback();
throw e;
}
} finally { 
    sess.close ();
}
return account ;
}
public void LogoutUser(String logoutVal,String setId){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Validlogin set isLogout=true where logoutKey=:logoutVal and deviceId=:setId");
safehqlquery.setParameter("logoutVal",logoutVal);
safehqlquery.setParameter("setId",setId);
safehqlquery.executeUpdate();
tx. commit () ; 
} catch (Exception e ) { 
    if ( tx != null ) {
 tx. rollback () ;
 throw e;
} 
} finally { 
    sess.close () ;
}
}
}
