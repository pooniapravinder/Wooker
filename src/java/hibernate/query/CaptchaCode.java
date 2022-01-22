package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Captchacode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CaptchaCode {
    
public void InsertCaptcha(Captchacode captcha) {       
    Session sess =null ;
    Transaction tr =null;
try {     
    sess =SetHibernateUtility. getSessionFactory () . openSession () ;            
    tr = sess.getTransaction();           
    sess.getTransaction().setTimeout(1000);
    tr. begin () ;
          sess. save (captcha);
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

public boolean isValidCaptcha(String code,String get_id,long timestamp){
    Session sess = null;
    Transaction tx = null;
    boolean result = false;
    try{                 
        sess = SetHibernateUtility.getSessionFactory().openSession(); 
        tx = sess.getTransaction(); 
        tx.begin();
        Query safehqlquery= sess.createQuery("select count(autoId) from Captchacode where captchaCode=:code and captchaId=:set_id and isUsed=false and setTimestamp>:timestamp");
        safehqlquery.setParameter("code",code);
        safehqlquery.setParameter("set_id",get_id);
        safehqlquery.setParameter("timestamp",timestamp);
        result = (long)safehqlquery.uniqueResult()>0;
        tx. commit () ; 
    }catch (Exception e){
        if(tx!=null){
            tx.rollback();
            throw e;
        }
    }finally{
        sess.close();
    }
    return result;
}
    
}
