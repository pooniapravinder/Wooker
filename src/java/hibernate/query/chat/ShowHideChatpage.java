package hibernate.query.chat;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Showhidechatpage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShowHideChatpage {

    public void ChatpageOptions(Showhidechatpage acc) {
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
    
    public void UpdateChatSettings(Showhidechatpage options) {
        Session sess = null;
        Transaction tx = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("update Showhidechatpage tb1 set tb1.deviceId=:deviceId, tb1.wooks=:wooks, tb1.remove=:remove, tb1.block=:block, tb1.starred=:starred, tb1.priority=:priority, tb1.mute=:mute, tb1.offchat=:offchat, tb1.privacy=:privacy, tb1.settings=:settings, tb1.msgTime=:msgTime, tb1.msgLength=:msgLength, tb1.defaultWallpaper=:defaultWallpaper, tb1.wallpaperId=:wallpaperId where tb1.userId=:userId");
            safehqlquery.setParameter("userId", options.getUserId());
            safehqlquery.setParameter("deviceId", options.getDeviceId());
            safehqlquery.setParameter("wooks", options.isWooks());
            safehqlquery.setParameter("remove", options.isRemove());
            safehqlquery.setParameter("block", options.isBlock());
            safehqlquery.setParameter("starred", options.isStarred());
            safehqlquery.setParameter("priority", options.isPriority());
            safehqlquery.setParameter("mute", options.isMute());
            safehqlquery.setParameter("offchat", options.isOffchat());
            safehqlquery.setParameter("privacy", options.isPrivacy());
            safehqlquery.setParameter("settings", options.isSettings());
            safehqlquery.setParameter("msgTime", options.isMsgTime());
            safehqlquery.setParameter("msgLength", options.getMsgLength());
            safehqlquery.setParameter("defaultWallpaper", options.getDefaultWallpaper());
            safehqlquery.setParameter("wallpaperId", options.getWallpaperId());
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
    
    public Showhidechatpage getChatSettings(long user) {
        Session sess = null;
        Transaction tx = null;
        Showhidechatpage listdata = null;
        try {
            sess = SetHibernateUtility.getSessionFactory().openSession();
            tx = sess.getTransaction();
            tx.begin();
            Query safehqlquery = sess.createQuery("from Showhidechatpage tb1 where tb1.userId=:user");
            safehqlquery.setParameter("user", user);
            safehqlquery.setMaxResults(1);
            listdata = (Showhidechatpage) safehqlquery.uniqueResult();
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
    
}
