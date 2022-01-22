package hibernate.query;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Accountpics;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserAccountPic {

    public void SavePic(Accountpics account) {
        Session sess = null;
        Transaction tr = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tr = sess.getTransaction();
            sess.getTransaction().setTimeout(1000);
            tr.begin();
            sess.save(account);
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

    public Accountpics getAccountPic(long user) {
        Session sess = null;
        Transaction tx = null;
        Accountpics img_id = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Accountpics where deleted=false and accpic=true and userId=:user order by autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            img_id = (Accountpics) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return img_id;
    }

    public Accountpics AccountImg(String imgid) {
        Session sess = null;
        Transaction tx = null;
        Accountpics img_id = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Accountpics where deleted=false and accpic=true and picId=:imgid order by autoId desc");
            safehqlquery.setParameter("imgid", imgid);
            safehqlquery.setMaxResults(1);
            img_id = (Accountpics) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return img_id;
    }

    public List<Accountpics> getAccImage(long get_user, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Accountpics> listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Accountpics tb1 where deleted=false and accpic=true and userId=:user and autoId = (select max(autoId) from Accountpics tb2 where tb2.picId=tb1.picId group by tb2.picId) order by autoId desc");
            safehqlquery.setParameter("user", get_user);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            listdata = (List<Accountpics>) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return listdata;
    }

    public long getAccImgPage(long get_user) {
        Session sess = null;
        Transaction tx = null;
        long count_page = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(picId) from Accountpics where accpic=true and userId=:user order by picId desc");
            safehqlquery.setParameter("user", get_user);
            count_page = (long) safehqlquery.uniqueResult() - 1;
            count_page = count_page / 10;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return count_page;
    }

    public void Remove(String set_imgid, long set_user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Accountpics set accpic=false where picId=:picid and userId=:user");
            safehqlquery.setParameter("picid", set_imgid);
            safehqlquery.setParameter("user", set_user);
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

    public void Delete(String set_imgid, long set_user) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Accountpics set deleted=true where picId=:picid and userId=:user");
            safehqlquery.setParameter("picid", set_imgid);
            safehqlquery.setParameter("user", set_user);
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
