package hibernate.query.info;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Showhideinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShowHideMoreInfoOpt {
public void HideOptions(Showhideinfo acc ) {       
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
public Showhideinfo getOptions(long get_user){
        Session sess =null ;
       Transaction tx = null ;
Showhideinfo account = null ;
try {                 
    sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("from Showhideinfo where accountId=:user");
safehqlquery.setParameter("user",get_user);
account = (Showhideinfo)safehqlquery.uniqueResult(); 
tx.commit();
}catch (Exception e){ 
 if(tx!=null){
 tx.rollback();
throw e;
}
} finally { 
    sess.close () ;
}
return account ;
}
public void MoreInfoAll(byte secinfo,byte images_visib,byte moreinfoset,byte moinpri,byte moinsecur,byte addmoin,byte addmoinpo,byte ineducatpo,byte infosch,byte infoschlpo,byte infogrcoll,byte infogrcollpo,byte infogruniv,byte infogrunivpo,byte infopogrcoll,byte infopogrcollpo,byte infopogruniv,byte infopogrunivpo,byte infowork,byte infoworkpo,byte infoloc,byte infolocpo,byte infocont,byte infocontpo,byte infoemail,byte infoemapo,byte infowebs,byte infowebspo,byte infohobb,byte infohobbpo,byte inforeli,byte inforelipo,byte inforel,byte inforelpo,byte infolang,byte infolangpo,byte inforelig,byte inforeligpo,byte infobehav,byte infobehavpo,byte infomyself,byte infomyselfpo,byte infocateg,byte infocategpo,byte showto_all,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set moreinfo=:secinfo,moinimages=:img_prop,moinsetting=:moreinfoset,moinprivacy=:moinpri,moinsecurity=:moinsecur,addmoinfo=:addmoin,addmoinpos=:addmoinpo,ineducatpos=:ineducatpo,infoschl=:infosch,infoschlpos=:infoschlpo,infogrcoll=:infogrcoll,infogrcollpos=:infogrcollpo,infogruniv=:infogruniv,infogrunivpos=:infogrunivpo,infopogrcoll=:infopogrcoll,infopogrcollpos=:infopogrcollpo,infopogruniv=:infopogruniv,infopogrunivpos=:infopogrunivpo,infowork=:infowork,infoworkpos=:infoworkpo,infoloc=:infoloc,infolocpos=:infolocpo,infocont=:infocont,infocontpos=:infocontpo,infoemail=:infoemail,infoemapos=:infoemapo,infowebs=:infowebs,infowebspos=:infowebspo,infohobb=:infohobb,infohobbpos=:infohobbpo,inforeli=:inforeli,inforelipos=:inforelipo,inforel=:inforel,inforelpos=:inforelpo,infolang=:infolang,infolangpos=:infolangpo,inforelig=:inforelig,inforeligpos=:inforeligpo,infobehav=:infobehav,infobehavpos=:infobehavpo,infomyself=:infomyself,infomyselfpos=:infomyselfpo,infocateg=:infocateg,infocategpos=:infocategpo,moinposshowall=:show_all where accountId=:user");
safehqlquery.setParameter("secinfo",secinfo);
safehqlquery.setParameter("img_prop",images_visib);
safehqlquery.setParameter("moreinfoset",moreinfoset);
safehqlquery.setParameter("moinpri",moinpri);
safehqlquery.setParameter("moinsecur",moinsecur);
safehqlquery.setParameter("addmoin",addmoin);
safehqlquery.setParameter("addmoinpo",addmoinpo);
safehqlquery.setParameter("ineducatpo",ineducatpo);
safehqlquery.setParameter("infosch",infosch);
safehqlquery.setParameter("infoschlpo",infoschlpo);
safehqlquery.setParameter("infogrcoll",infogrcoll);
safehqlquery.setParameter("infogrcollpo",infogrcollpo);
safehqlquery.setParameter("infogruniv",infogruniv);
safehqlquery.setParameter("infogrunivpo",infogrunivpo);
safehqlquery.setParameter("infopogrcoll",infopogrcoll);
safehqlquery.setParameter("infopogrcollpo",infopogrcollpo);
safehqlquery.setParameter("infopogruniv",infopogruniv);
safehqlquery.setParameter("infopogrunivpo",infopogrunivpo);
safehqlquery.setParameter("infowork",infowork);
safehqlquery.setParameter("infoworkpo",infoworkpo);
safehqlquery.setParameter("infoloc",infoloc);
safehqlquery.setParameter("infolocpo",infolocpo);
safehqlquery.setParameter("infocont",infocont);
safehqlquery.setParameter("infocontpo",infocontpo);
safehqlquery.setParameter("infoemail",infoemail);
safehqlquery.setParameter("infoemapo",infoemapo);
safehqlquery.setParameter("infowebs",infowebs);
safehqlquery.setParameter("infowebspo",infowebspo);
safehqlquery.setParameter("infohobb",infohobb);
safehqlquery.setParameter("infohobbpo",infohobbpo);
safehqlquery.setParameter("inforeli",inforeli);
safehqlquery.setParameter("inforelipo",inforelipo);
safehqlquery.setParameter("inforel",inforel);
safehqlquery.setParameter("inforelpo",inforelpo);
safehqlquery.setParameter("infolang",infolang);
safehqlquery.setParameter("infolangpo",infolangpo);
safehqlquery.setParameter("inforelig",inforelig);
safehqlquery.setParameter("inforeligpo",inforeligpo);
safehqlquery.setParameter("infobehav",infobehav);
safehqlquery.setParameter("infobehavpo",infobehavpo);
safehqlquery.setParameter("infomyself",infomyself);
safehqlquery.setParameter("infomyselfpo",infomyselfpo);
safehqlquery.setParameter("infocateg",infocateg);
safehqlquery.setParameter("infocategpo",infocategpo);
safehqlquery.setParameter("show_all",showto_all);
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
public void MoreInfoSch(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infoschl=:sch where accountId=:user");
safehqlquery.setParameter("sch",value);
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
public void MoreInfoGrcoll(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infogrcoll=:grcoll where accountId=:user");
safehqlquery.setParameter("grcoll",value);
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
public void MoreInfoGruniv(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infogruniv=:gruniv where accountId=:user");
safehqlquery.setParameter("gruniv",value);
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
public void MoreInfoPogrcoll(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infopogrcoll=:pogrcoll where accountId=:user");
safehqlquery.setParameter("pogrcoll",value);
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
public void MoreInfoPogruniv(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infopogruniv=:pogruniver where accountId=:user");
safehqlquery.setParameter("pogruniver",value);
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
public void MoreInfoWork(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infowork=:work where accountId=:user");
safehqlquery.setParameter("work",value);
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
public void MoreInfoLocat(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infoloc=:locat where accountId=:user");
safehqlquery.setParameter("locat",value);
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
public void MoreInfoCont(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infocont=:conta where accountId=:user");
safehqlquery.setParameter("conta",value);
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
public void MoreInfoEmail(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infoemail=:email where accountId=:user");
safehqlquery.setParameter("email",value);
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
public void MoreInfoWebsite(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infowebs=:website where accountId=:user");
safehqlquery.setParameter("website",value);
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
public void MoreInfoHobbies(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infohobb=:hobbi where accountId=:user");
safehqlquery.setParameter("hobbi",value);
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
public void MoreInfoRelati(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set inforeli=:relati where accountId=:user");
safehqlquery.setParameter("relati",value);
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
public void MoreInfoRelat(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set inforel=:relat where accountId=:user");
safehqlquery.setParameter("relat",value);
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
public void MoreInfoLang(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infolang=:lang where accountId=:user");
safehqlquery.setParameter("lang",value);
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
public void MoreInfoRelig(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set inforelig=:relig where accountId=:user");
safehqlquery.setParameter("relig",value);
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
public void MoreInfoBehav(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infobehav=:behav where accountId=:user");
safehqlquery.setParameter("behav",value);
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
public void MoreInfoMyself(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infomyself=:myself where accountId=:user");
safehqlquery.setParameter("myself",value);
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
public void MoreInfoCateg(byte value,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set infocateg=:categ where accountId=:user");
safehqlquery.setParameter("categ",value);
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