package hibernate.query.info;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Showhideaddmoreinfo;
import hibernate.mapping.Showhideeditaccpic;
import hibernate.mapping.Showhideeditinfo;
import hibernate.mapping.Showhideinfo;
import hibernate.mapping.Showhidemoreinfo;
import hibernate.mapping.Showhideuplaccpic;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShowHideInfoOpt {

    public void InfoOptions(Showhideinfo acc) {
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
    
    public void EditInfoOptions(Showhideeditinfo acc) {
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
    
    public void InfoPicOptions(Showhideeditaccpic acc) {
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
    
    public void InfoPicUplOptions(Showhideuplaccpic acc) {
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
    
    public void MoreInfoOptions(Showhidemoreinfo acc) {
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
    
    public void MoreInfoAddOptions(Showhideaddmoreinfo acc) {
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

    public Showhideinfo getInfoOptions(long get_user) {
        Session sess = null;
        Transaction tx = null;
        Showhideinfo account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhideinfo where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setMaxResults(1);
            account = (Showhideinfo) safehqlquery.uniqueResult();
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

    public Showhideeditinfo getEditInfoOptions(long get_user) {
        Session sess = null;
        Transaction tx = null;
        Showhideeditinfo account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhideeditinfo where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setMaxResults(1);
            account = (Showhideeditinfo) safehqlquery.uniqueResult();
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
    
    public Showhideeditaccpic getPicOptions(long get_user) {
        Session sess = null;
        Transaction tx = null;
        Showhideeditaccpic account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhideeditaccpic where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setMaxResults(1);
            account = (Showhideeditaccpic) safehqlquery.uniqueResult();
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
    
    public Showhideuplaccpic getPicUplOptions(long get_user) {
        Session sess = null;
        Transaction tx = null;
        Showhideuplaccpic account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhideuplaccpic where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setMaxResults(1);
            account = (Showhideuplaccpic) safehqlquery.uniqueResult();
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
    
    public Showhidemoreinfo getMoreInfoOptions(long get_user) {
        Session sess = null;
        Transaction tx = null;
        Showhidemoreinfo account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhidemoreinfo where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setMaxResults(1);
            account = (Showhidemoreinfo) safehqlquery.uniqueResult();
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
    
    public Showhideaddmoreinfo getMoreInfoAddOptions(long get_user) {
        Session sess = null;
        Transaction tx = null;
        Showhideaddmoreinfo account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhideaddmoreinfo where userId=:user order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setMaxResults(1);
            account = (Showhideaddmoreinfo) safehqlquery.uniqueResult();
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
