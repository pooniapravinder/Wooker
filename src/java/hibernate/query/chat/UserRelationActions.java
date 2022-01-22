package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Userchatlist;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRelationActions {

    public void insertAction(Userchatlist acc) {
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

    public void makeRequest(long id, long userOne, long userTwo) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.userOne=:userOne,tb1.userTwo=:userTwo,tb1.request=true,tb1.blocked=false,tb1.friend=false,tb1.removed=false,tb1.sent=:timestamp where autoId=:id");
            safehqlquery.setParameter("userOne", userOne);
            safehqlquery.setParameter("userTwo", userTwo);
            safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            safehqlquery.setParameter("id", id);
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

    public void InsertRequestAll(long user, boolean isAccept) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isAccept) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.friend=true,tb1.request=false,tb1.accepted=:timestamp where tb1.userTwo=:user");
                safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.request=false where tb1.userTwo=:user");
            }
            safehqlquery.setParameter("user", user);
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

    public void InsertRequest(long id, boolean isAccept) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isAccept) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.friend=true,tb1.request=false,tb1.accepted=:timestamp where tb1.autoId=:id");
                safehqlquery.setParameter("timestamp", System.currentTimeMillis());
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.request=false where tb1.autoId=:id");
            }
            safehqlquery.setParameter("id", id);
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

    public void InsertRemove(long id, long userOne, long userTwo) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.userOne=:userOne,tb1.userTwo=:userTwo,tb1.request=false,tb1.blocked=false,tb1.friend=false,tb1.removed=true,tb1.sent=0,tb1.accepted=0 where autoId=:id");
            safehqlquery.setParameter("userOne", userOne);
            safehqlquery.setParameter("userTwo", userTwo);
            safehqlquery.setParameter("id", id);
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

    public void InsertBlockUnblock(long id, long userOne, long userTwo, boolean isBlock) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isBlock) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.userOne=:userOne,tb1.userTwo=:userTwo,tb1.request=false,tb1.blocked=true,tb1.friend=false,tb1.removed=false,tb1.sent=0,tb1.accepted=0 where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.userOne=:userOne,tb1.userTwo=:userTwo,tb1.request=false,tb1.blocked=false,tb1.friend=false,tb1.removed=false,tb1.sent=0,tb1.accepted=0 where autoId=:id");
            }
            safehqlquery.setParameter("userOne", userOne);
            safehqlquery.setParameter("userTwo", userTwo);
            safehqlquery.setParameter("id", id);
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

    public void InsertFriend(long id) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.friend=true where autoId=:id");
            safehqlquery.setParameter("id", id);
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

    public void InsertMute(long id, long user, boolean isOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (!isOne) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.muteOne=:user where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.muteTwo=:user where autoId=:id");
            }
            safehqlquery.setParameter("id", id);
            safehqlquery.setParameter("user", user);
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

    public void InsertUnmute(long id, boolean isOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isOne) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.muteOne=0 where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.muteTwo=0 where autoId=:id");
            }
            safehqlquery.setParameter("id", id);
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

    public void InsertOffchat(long id, long user, boolean isOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (!isOne) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.offchatOne=:user where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.offchatTwo=:user where autoId=:id");
            }
            safehqlquery.setParameter("id", id);
            safehqlquery.setParameter("user", user);
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

    public void InsertOnchat(long id, boolean isOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isOne) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.offchatOne=0 where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.offchatTwo=0 where autoId=:id");
            }
            safehqlquery.setParameter("id", id);
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

    public Userchatlist getUserslist(long userone, long usertwo) {
        Session sess = null;
        Transaction tx = null;
        Userchatlist account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Userchatlist tb1 where (tb1.userOne=:userone and tb1.userTwo=:usertwo) or (tb1.userOne=:usertwo and tb1.userTwo=:userone) order by tb1.autoId desc");
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

    public Userchatlist getUserlistById(long id) {
        Session sess = null;
        Transaction tx = null;
        Userchatlist account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Userchatlist tb1 where tb1.autoId=:id");
            safehqlquery.setParameter("id", id);
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

    public List getfirstUserlist(boolean isChatlist, boolean isRemoved, long user) {
        Session sess = null;
        Transaction tx = null;
        List account = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isChatlist) {
                safehqlquery = sess.createQuery("from Online tb2, Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and tb1.friend=true and tb2.userId=(case when tb1.userOne=:user then tb1.userTwo else tb1.userOne end) order by tb1.autoId desc");
            } else if (isRemoved) {
                safehqlquery = sess.createQuery("from Userchatlist tb1 where tb1.userOne=:user and tb1.removed=true order by autoId desc");
            } else {
                safehqlquery = sess.createQuery("from Userchatlist tb1 where tb1.userOne=:user and tb1.blocked=true order by autoId desc");
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(10);
            account = (List) safehqlquery.list();
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

    public List getUserlist(boolean isChatlist, boolean isRemoved, long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        List listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isChatlist) {
                if (isForward) {
                    safehqlquery = sess.createQuery("from Online tb2, Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and tb1.friend=true and tb2.userId=(case when tb1.userOne=:user then tb1.userTwo else tb1.userOne end) and tb1.autoId>:pagination order by tb1.autoId asc");
                } else {
                    safehqlquery = sess.createQuery("from Online tb2, Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and tb1.friend=true and tb2.userId=(case when tb1.userOne=:user then tb1.userTwo else tb1.userOne end) and tb1.autoId<:pagination order by tb1.autoId desc");
                }
            } else if (isRemoved) {
                if (isForward) {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.removed=true and tb1.autoId>:pagination order by tb1.autoId asc");
                } else {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.removed=true and tb1.autoId<:pagination order by tb1.autoId desc");
                }
            } else {
                if (isForward) {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.blocked=true and tb1.autoId>:pagination order by tb1.autoId asc");
                } else {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.blocked=true and tb1.autoId<:pagination order by tb1.autoId desc");
                }
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setMaxResults(10);
            listdata = (List) safehqlquery.list();
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

    public boolean isPagination(boolean isChatlist, boolean isRemoved, long user, long pagination_id, boolean isForward) {
        Session sess = null;
        Transaction tx = null;
        boolean pagination = false;
        if (pagination_id == 0) {
            return false;
        }
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isChatlist) {
                if (isForward) {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and tb1.friend=true and tb1.autoId>:pagination");
                } else {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and tb1.friend=true and tb1.autoId<:pagination");
                }
            } else if (isRemoved) {
                if (isForward) {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.removed=true and tb1.autoId>:pagination");
                } else {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.removed=true and tb1.autoId<:pagination");
                }
            } else {
                if (isForward) {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.blocked=true and tb1.autoId>:pagination");
                } else {
                    safehqlquery = sess.createQuery("from Userchatlist tb1 where userOne=:user and tb1.blocked=true and tb1.autoId<:pagination");
                }
            }
            safehqlquery.setParameter("user", user);
            safehqlquery.setParameter("pagination", pagination_id);
            safehqlquery.setMaxResults(1);
            pagination = safehqlquery.uniqueResult() != null;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            sess.close();
        }
        return pagination;
    }

    public Long countUserlist(boolean isChatlist, boolean isRemoved, long user) {
        Session sess = null;
        Transaction tx = null;
        Long countdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isChatlist) {
                safehqlquery = sess.createQuery("select count(*) from Userchatlist tb1 where ((tb1.userOne=:user) or (tb1.userTwo=:user)) and tb1.friend=true");
            } else if (isRemoved) {
                safehqlquery = sess.createQuery("select count(*) from Userchatlist tb1 where tb1.userOne=:user and tb1.removed=true");
            } else {
                safehqlquery = sess.createQuery("select count(*) from Userchatlist tb1 where tb1.userOne=:user and tb1.blocked=true");
            }
            safehqlquery.setParameter("user", user);
            countdata = (Long) safehqlquery.uniqueResult();
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
