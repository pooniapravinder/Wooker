package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Invalidlogin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertInvalidLogin {

public boolean isExceed(long user,long timestamp){
    Session sess = null;
    Transaction tx = null;
    boolean result = false;
    try{                 
        sess = SetHibernateUtility.getSessionFactory().openSession(); 
        tx = sess.getTransaction(); 
        tx.begin();
        Query safehqlquery= sess.createQuery("select count(userId) from Invalidlogin where userId=:user and loginTimestamp>=:timestamp");
        safehqlquery.setParameter("user",user);
        safehqlquery.setParameter("timestamp",timestamp);
        result = (long)safehqlquery.uniqueResult()>5; 
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

public void InsertUser(Invalidlogin account){       
    Session sess =null ;
    Transaction tr =null;
try {     
    sess =SetHibernateUtility. getSessionFactory () . openSession () ;            
    tr = sess.getTransaction();           
    sess.getTransaction().setTimeout(1000);
    tr. begin () ;
          sess.save(account);
          tr.commit();
          if(sess.getTransaction().isActive()){
              System.out.println("Session is active");
          }else{
              System.out.println("Session is inactive");
          }
} catch (Exception e){
    if ( tr != null ) {
 tr. rollback () ;
 throw e;
} 
} finally
{
    sess.close();
}
}
}
