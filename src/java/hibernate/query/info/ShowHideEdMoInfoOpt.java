
package hibernate.query.info;

import HibernateUtility.SetHibernateUtility;
import hibernate.mapping.Showhideinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ShowHideEdMoInfoOpt {
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
public void MoreInfoAll(byte edmoinfoset,byte edmoinsecur,byte lastsvd,byte ineducatpo,byte infosch,byte infoschlpo,byte infogrcoll,byte infogrcollpo,byte infogruniv,byte infogrunivpo,byte infopogrcoll,byte infopogrcollpo,byte infopogruniv,byte infopogrunivpo,byte infowork,byte infoworkpo,byte infoloc,byte infolocpo,byte infocont,byte infocontpo,byte infoemail,byte infoemapo,byte infowebs,byte infowebspo,byte infohobb,byte infohobbpo,byte inforeli,byte inforelipo,byte inforel,byte inforelpo,byte infolang,byte infolangpo,byte inforelig,byte inforeligpo,byte infobehav,byte infobehavpo,byte infomyself,byte infomyselfpo,byte infocateg,byte infocategpo,long user){
        Session sess =null ;
       Transaction tx = null ;
try {
sess =SetHibernateUtility.getSessionFactory().openSession(); 
tx = sess.getTransaction(); 
tx.begin(); 
Query safehqlquery= sess.createQuery("update Showhideinfo set edmoinsetting=:edmoinfoset,edmoinsecurity=:edmoinsecur,edmoinlastsvd=:lastsvd,edineducatpos=:ineducatpo,edinschl=:infosch,edinschlpos=:infoschlpo,edingrcoll=:infogrcoll,edingrcollpos=:infogrcollpo,edingruniv=:infogruniv,edingrunivpos=:infogrunivpo,edinpogrcoll=:infopogrcoll,edinpogrcollpos=:infopogrcollpo,edinpogruniv=:infopogruniv,edinpogrunivpos=:infopogrunivpo,edinwork=:infowork,edinworkpos=:infoworkpo,edinloc=:infoloc,edinlocpos=:infolocpo,edincont=:infocont,edincontpos=:infocontpo,edinemail=:infoemail,edinemapos=:infoemapo,edinwebs=:infowebs,edinwebspos=:infowebspo,edinhobb=:infohobb,edinhobbpos=:infohobbpo,edinreli=:inforeli,edinrelipos=:inforelipo,edinrel=:inforel,edinrelpos=:inforelpo,edinlang=:infolang,edinlangpos=:infolangpo,edinrelig=:inforelig,edinreligpos=:inforeligpo,edinbehav=:infobehav,edinbehavpos=:infobehavpo,edinmyself=:infomyself,edinmyselfpos=:infomyselfpo,edincateg=:infocateg,edincategpos=:infocategpo where accountId=:user");
safehqlquery.setParameter("edmoinfoset",edmoinfoset);
safehqlquery.setParameter("edmoinsecur",edmoinsecur);
safehqlquery.setParameter("lastsvd",lastsvd);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinschl=:sch where accountId=:set_user");
safehqlquery.setParameter("sch",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edingrcoll=:grcoll where accountId=:set_user");
safehqlquery.setParameter("grcoll",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edingruniv=:gruniv where accountId=:set_user");
safehqlquery.setParameter("gruniv",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinpogrcoll=:pogrcoll where accountId=:set_user");
safehqlquery.setParameter("pogrcoll",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinpogruniv=:pogruniver where accountId=:set_user");
safehqlquery.setParameter("pogruniver",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinwork=:work where accountId=:set_user");
safehqlquery.setParameter("work",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinloc=:locat where accountId=:set_user");
safehqlquery.setParameter("locat",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edincont=:conta where accountId=:set_user");
safehqlquery.setParameter("conta",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinemail=:email where accountId=:set_user");
safehqlquery.setParameter("email",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinwebs=:website where accountId=:set_user");
safehqlquery.setParameter("website",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinhobb=:hobbi where accountId=:set_user");
safehqlquery.setParameter("hobbi",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinreli=:relati where accountId=:set_user");
safehqlquery.setParameter("relati",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinrel=:relat where accountId=:set_user");
safehqlquery.setParameter("relat",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinlang=:lang where accountId=:set_user");
safehqlquery.setParameter("lang",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinrelig=:relig where accountId=:set_user");
safehqlquery.setParameter("relig",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinbehav=:behav where accountId=:set_user");
safehqlquery.setParameter("behav",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edinmyself=:myself where accountId=:set_user");
safehqlquery.setParameter("myself",value);
safehqlquery.setParameter("set_user",user);
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
Query safehqlquery= sess.createQuery("update Showhideinfo set edincateg=:categ where accountId=:set_user");
safehqlquery.setParameter("categ",value);
safehqlquery.setParameter("set_user",user);
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