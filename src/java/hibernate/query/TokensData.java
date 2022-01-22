
package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Tokens;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TokensData {
public void InsertToken(Tokens token) {       
    Session sess =null ;
    Transaction tr =null;
try {     
    sess =SetHibernateUtility. getSessionFactory () . openSession () ;            
    tr = sess.getTransaction();           
    sess.getTransaction().setTimeout(1000);
    tr. begin () ;
          sess. save (token);
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
public boolean isValidToken(long user,String token,long timestamp){
    Session sess = null;
    Transaction tx = null;
    boolean result = false;
    try{                 
        sess = SetHibernateUtility.getSessionFactory().openSession(); 
        tx = sess.getTransaction(); 
        tx.begin();
        Query safehqlquery= sess.createQuery("select count(tokenId) from Tokens where userId=:user and token=:token and setTimestamp>:timestamp");
        safehqlquery.setParameter("user",user);
        safehqlquery.setParameter("token",token);
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
