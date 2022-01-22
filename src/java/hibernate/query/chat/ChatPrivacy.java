package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Chatuseroptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChatPrivacy {

    public void InsertChatPrivacy(Chatuseroptions acc) {
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

    public Chatuseroptions getPrivacy(long userOne, long userTwo) {
        Session sess = null;
        Transaction tx = null;
        Chatuseroptions listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Chatuseroptions tb1 where tb1.userOne=:userOne and tb1.userTwo=:userTwo");
            safehqlquery.setParameter("userOne", userOne);
            safehqlquery.setParameter("userTwo", userTwo);
            safehqlquery.setMaxResults(1);
            listdata = (Chatuseroptions) safehqlquery.uniqueResult();
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
    
    public void ChatBlock(long id, long user, boolean isOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (!isOne) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.blockedchatOne=:user where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.blockedchatTwo=:user where autoId=:id");
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

    public void ChatUnblock(long id, boolean isOne) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery;
            if (isOne) {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.blockedchatOne=0 where autoId=:id");
            } else {
                safehqlquery = sess.createQuery("update Userchatlist tb1 set tb1.blockedchatTwo=0 where autoId=:id");
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

    public void updatePrivacy(long autoId, String deviceId, boolean likeDislike, boolean talking, boolean comment, boolean share, boolean image, boolean audio, boolean video, boolean file, boolean gif) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Chatuseroptions tb1 set tb1.deviceId=:deviceId,tb1.likeDislike=:likeDislike,tb1.talking=:talking,tb1.comment=:comment,tb1.share=:share,tb1.chatImage=:image,tb1.chatAudio=:audio,tb1.chatVideo=:video,tb1.chatFile=:file,tb1.chatGif=:gif where tb1.autoId=:autoId");
            safehqlquery.setParameter("autoId", autoId);
            safehqlquery.setParameter("deviceId", deviceId);
            safehqlquery.setParameter("likeDislike", likeDislike);
            safehqlquery.setParameter("talking", talking);
            safehqlquery.setParameter("comment", comment);
            safehqlquery.setParameter("share", share);
            safehqlquery.setParameter("image", image);
            safehqlquery.setParameter("audio", audio);
            safehqlquery.setParameter("video", video);
            safehqlquery.setParameter("file", file);
            safehqlquery.setParameter("gif", gif);
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
