package hibernate.query.reactoper;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Comments;
import hibernate.mapping.Likesdislikes;
import hibernate.mapping.Talkings;
import hibernate.mapping.Userchatlist;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReactOper {

    public Userchatlist getChatlistPrivacy(long userone, long usertwo) {
        Session sess = null;
        Transaction tx = null;
        Userchatlist account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Userchatlist tb1 where tb1.autoId=(select max(tb2.autoId) from Userchatlist tb2 where ((tb2.userOne=:userone and tb2.userTwo=:usertwo) or (tb2.userOne=:usertwo and tb2.userTwo=:userone)))");
            safehqlquery.setParameter("userone", userone);
            safehqlquery.setParameter("usertwo", usertwo);
            safehqlquery.setMaxResults(1);
            account = (Userchatlist) safehqlquery.uniqueResult();
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

    public boolean getSchoolPrivacy(long userone, long usertwo) {
        Session sess = null;
        Transaction tx = null;
        boolean account = false;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select autoId from Secondaryinfo where school=(select school from Secondaryinfo where school!=null and deleted=false and schoolPrivacy=true and userId=:userone) and deleted=false and userId=:usertwo");
            safehqlquery.setParameter("userone", userone);
            safehqlquery.setParameter("usertwo", usertwo);
            safehqlquery.setMaxResults(1);
            account = (Long) safehqlquery.uniqueResult() != null;
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

    public boolean getCollegePrivacy(long userone, long usertwo) {
        Session sess = null;
        Transaction tx = null;
        boolean account = false;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select autoId from Secondaryinfo where (gradcollege=(select gradcollege from Secondaryinfo where gradcollege!=null and deleted=false and gradcollPrivacy=true and userId=:userone) or pogradcollege=(select pogradcollege from Secondaryinfo where pogradcollege!=null and deleted=false and pogradcollPrivacy=true and userId=:userone)) and deleted=false and userId=:usertwo");
            safehqlquery.setParameter("userone", userone);
            safehqlquery.setParameter("usertwo", usertwo);
            safehqlquery.setMaxResults(1);
            account = (Long) safehqlquery.uniqueResult() != null;
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

    public boolean getUniverPrivacy(long userone, long usertwo) {
        Session sess = null;
        Transaction tx = null;
        boolean account = false;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select autoId from Secondaryinfo (graduniver=(select graduniver from Secondaryinfo where graduniver!=null and deleted=false and graduniverPrivacy=true and userId=:userone) or pograduniver=(select pograduniver from Secondaryinfo where pograduniver!=null and deleted=false and pograduniverPrivacy=true and userId=:userone)) and deleted=false and userId=:usertwo");
            safehqlquery.setParameter("userone", userone);
            safehqlquery.setParameter("usertwo", usertwo);
            safehqlquery.setMaxResults(1);
            account = (Long) safehqlquery.uniqueResult() != null;
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

    public void insertLikeDislike(Likesdislikes acc) {
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

    public void insertTalkings(Talkings acc) {
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
    
    public void insertComments(Comments acc) {
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

    public Likesdislikes getSingleLikeDislike(long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Likesdislikes account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Likesdislikes where userId=:user and targetId=:id order by autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            account = (Likesdislikes) safehqlquery.uniqueResult();
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

    public List<Long> getLikesDislikes(boolean val, long user, String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Long> countdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select userId from Likesdislikes tb1 where tb1.autoId=(select max(tb2.autoId) from Likesdislikes tb2 where tb1.userId=tb2.userId and tb1.targetId=tb2.targetId) and (select case when tb3.blocked=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userId and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userId))))=null and tb1.likeDislike=:val and tb1.targetId=:id");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("val", val);
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            countdata = (List<Long>) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }

    public Long couLiDislikeTotPage(boolean val, long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Likesdislikes tb1 where tb1.autoId=(select max(tb2.autoId) from Likesdislikes tb2 where tb1.userId=tb2.userId and tb1.targetId=tb2.targetId) and (select case when tb3.blocked=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userId and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userId))))=null and tb1.likeDislike=:val and tb1.targetId=:id");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("val", val);
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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
    
    public Talkings getTalkingByOperId(String id) {
        Session sess = null;
        Transaction tx = null;
        Talkings account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Talkings where operId=:id order by autoId desc");
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            account = (Talkings) safehqlquery.uniqueResult();
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
    
    
    public  List<Long> getDisTalkings(long user, String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Long> countdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select distinct userOne from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampTalk desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            countdata = (List<Long>) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }
    
    public Long getDisTalkTotalPage(long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.targetId=tb1.targetId and tb2.userOne=tb1.userOne) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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

    public List<Talkings> getTalkings(boolean isSelf, long user, String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Talkings> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isSelf) {
                safehqlquery = sess.createQuery("from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and (select case when tb3.blocked=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userOne and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampTalk desc");
            } else {
                safehqlquery = sess.createQuery("from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampTalk desc");
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            account = (List<Talkings>) safehqlquery.list();
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
    
    public Long getTalkTotalPage(boolean isSelf, long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isSelf) {
                safehqlquery = sess.createQuery("select count (*) from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and (select case when tb3.blocked=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userOne and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id");
            } else {
                safehqlquery = sess.createQuery("select count (*) from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id");
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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

    public List<Talkings> getEditedTalk(String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Talkings> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Talkings tb1 where tb1.deleted=false and tb1.operId=:id order by tb1.timestampVal desc");
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            account = (List<Talkings>) safehqlquery.list();
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

    public List<Talkings> getCommonUser(boolean isSelf, long user, String id) {
        Session sess = null;
        Transaction tx = null;
        List<Talkings> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isSelf) {
                safehqlquery = sess.createQuery("from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.targetId=tb1.targetId and tb2.userOne=tb1.userOne) and tb1.deleted=false and tb1.targetId=:id and (select case when tb3.friend=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userOne and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userOne))))=true order by tb1.timestampTalk desc");
            } else {
                safehqlquery = sess.createQuery("from Talkings tb1 where tb1.autoId =(select max(tb2.autoId) from Talkings tb2 where tb2.targetId=tb1.targetId and tb2.userOne=tb1.userOne) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and tb1.deleted=false and tb1.targetId=:id and (select case when tb3.friend=true then true else null end from Userchatlist tb3 where tb3.autoId=(select max(tb4.autoId) from Userchatlist tb4 where ((tb4.userOne=tb1.userOne and tb4.userTwo=:user) or (tb4.userOne=:user and tb4.userTwo=tb1.userOne))))=true order by tb1.timestampTalk desc");
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(3);
            account = (List<Talkings>) safehqlquery.list();
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
    
    public Long getEditTotalPage(String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count (*) from Talkings tb1 where tb1.deleted=false and tb1.operId=:id order by tb1.timestampVal asc");
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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
    
    public Long getEditCommTotalPage(String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count (*) from Comments tb1 where tb1.deleted=false and tb1.operId=:id order by tb1.timestampVal asc");
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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
    
    public  List<Long> getDisComments(long user, String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Long> countdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select distinct userOne from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampComment desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            countdata = (List<Long>) safehqlquery.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }
    
    public Long getDisCommTotalPage(long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.targetId=tb1.targetId and tb2.userOne=tb1.userOne) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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
    
    public List<Comments> getComments(boolean isSelf, long user, String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Comments> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isSelf) {
                safehqlquery = sess.createQuery("from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.targetId=tb1.targetId and tb1.userOne=tb2.userOne) and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampComment desc");
            } else {
                safehqlquery = sess.createQuery("from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId and tb2.userOne=:user) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampComment desc");
            safehqlquery.setParameter("user", user);
            }
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            account = (List<Comments>) safehqlquery.list();
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
    
    public List<Comments> getWriteComments(long user, String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Comments> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId and tb1.userOne=:user) and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampComment desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            account = (List<Comments>) safehqlquery.list();
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
    
    public Long getWriteCommentsTotalPage(long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId and tb1.userOne=:user) and tb1.deleted=false and tb1.targetId=:id order by tb1.timestampComment desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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
    
    public Comments getCommentByOperId(String id) {
        Session sess = null;
        Transaction tx = null;
        Comments account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Comments where operId=:id order by autoId desc");
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            account = (Comments) safehqlquery.uniqueResult();
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
    
    public Comments getCommentByUser(long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Comments account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Comments where targetId=:id and userOne=:user and deleted=false order by autoId desc");
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("id", id);
            safehqlquery.setMaxResults(1);
            account = (Comments) safehqlquery.uniqueResult();
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
    
    public Long getCommentTotalPage(boolean isSelf, long user, String id) {
        Session sess = null;
        Transaction tx = null;
        Long count_page = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isSelf) {
                safehqlquery = sess.createQuery("select count (*) from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.targetId=tb1.targetId and tb1.userOne=tb2.userOne) and tb1.deleted=false and tb1.targetId=:id");
            } else {
                safehqlquery = sess.createQuery("select count (*) from Comments tb1 where tb1.autoId =(select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId) and (select case when tb3.disabled=true then true else null end from Disabledata tb3 where tb3.autoId=(select max(tb4.autoId) from Disabledata tb4 where tb4.targetId=tb1.operId))=null and (select case when tb5.blocked=true then true else null end from Userchatlist tb5 where tb5.autoId=(select max(tb6.autoId) from Userchatlist tb6 where ((tb6.userOne=tb1.userOne and tb6.userTwo=:user) or (tb6.userOne=:user and tb6.userTwo=tb1.userOne))))=null and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("user", user);
            }
            safehqlquery.setParameter("id", id);
            count_page = (Long) safehqlquery.uniqueResult() - 1;
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

    public List<Comments> getEditedComment(String id, int page_id) {
        Session sess = null;
        Transaction tx = null;
        List<Comments> account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Comments tb1 where tb1.deleted=false and tb1.operId=:id order by tb1.timestampVal desc");
            safehqlquery.setParameter("id", id);
            safehqlquery.setFirstResult(page_id * 10);
            safehqlquery.setMaxResults(10);
            account = (List<Comments>) safehqlquery.list();
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
    
    public long countLikesDislikes(boolean val, String id) {
        Session sess = null;
        Transaction tx = null;
        long countdata = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(tb1.autoId) from Likesdislikes tb1 where tb1.autoId=(select max(tb2.autoId) from Likesdislikes tb2 where tb1.userId=tb2.userId and tb1.targetId=tb2.targetId) and tb1.likeDislike=:val and tb1.targetId=:id");
            safehqlquery.setParameter("val", val);
            safehqlquery.setParameter("id", id);
            countdata = (long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }

    public long countTalkings(String id) {
        Session sess = null;
        Transaction tx = null;
        long countdata = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Talkings tb1 where tb1.autoId in (select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("id", id);
            countdata = (long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }
    
    public long countDisTalkings(String id) {
        Session sess = null;
        Transaction tx = null;
        long countdata = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(distinct userOne) from Talkings tb1 where tb1.autoId in (select max(tb2.autoId) from Talkings tb2 where tb2.operId=tb1.operId) and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("id", id);
            countdata = (long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }
    
    public long countComments(String id) {
        Session sess = null;
        Transaction tx = null;
        long countdata = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(*) from Comments tb1 where tb1.autoId in (select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId) and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("id", id);
            countdata = (long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }
    
    public long countDisComments(String id) {
        Session sess = null;
        Transaction tx = null;
        long countdata = 0;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("select count(distinct userOne) from Comments tb1 where tb1.autoId in (select max(tb2.autoId) from Comments tb2 where tb2.operId=tb1.operId) and tb1.deleted=false and tb1.targetId=:id");
            safehqlquery.setParameter("id", id);
            countdata = (long) safehqlquery.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return countdata;
    }
}
