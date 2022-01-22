
package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Otpcode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserOTP {
    
public void saveOTP(Otpcode acc) {
    Session sess =null ;
    Transaction tr =null;
try {     
    sess =SetHibernateUtility. getSessionFactory () . openSession () ;            
    tr = sess.getTransaction();           
    sess.getTransaction().setTimeout(1000);
    tr. begin () ;
          sess. save ( acc ) ;
          tr. commit () ;
          if(sess.getTransaction().isActive()){
              System.out.println("Session is active");
          }else{
              System.out.println("Session is inactive");
          }
} catch (Exception e )
{
    if ( tr != null ) {
 tr. rollback () ;
 throw e;
} 
} finally
{
    sess.close();
}
}
public void NewOTP(long userid,long timestamp,int OtpCode) {
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession();
tx = sess.getTransaction();
tx.begin();
Query safehqlquery= sess.createQuery("update Otpcode set verifyCode=:otpcode,setTimestamp=:timestamp,attempts=0 where userId=:userid");
safehqlquery.setParameter("otpcode",OtpCode);
safehqlquery.setParameter("userid",userid);
safehqlquery.setParameter("timestamp",timestamp);
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
public Otpcode GetOTP(long user){
        Session sess =null;
       Transaction tx = null;
 Otpcode otp = null;
try {                 
    sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("from Otpcode where userId=:user");
safehqlquery.setParameter("user",user);
otp = (Otpcode)safehqlquery.uniqueResult(); 
tx. commit () ;
} catch (Exception e ) { 
    if ( tx != null ) {
 tx. rollback () ;
 throw e;
} 
} finally { 
    sess.close () ;
}
return otp;
}

public void updateAttempts(long userid) {
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession();
tx = sess.getTransaction();
tx.begin();
Query safehqlquery= sess.createQuery("update Otpcode set attempts=attempts+1 where userId=:userid");
safehqlquery.setParameter("userid",userid);
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
public void AccountVerifySuccess(long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Accounts set verifiedAccount=true where userId=:user");
safehqlquery.setParameter("user",user);
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