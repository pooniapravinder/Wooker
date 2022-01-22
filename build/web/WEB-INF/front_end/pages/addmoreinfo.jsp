<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html>
    <head>
        <meta name="keywords" content="Edit your Secondary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Edit your Secondary Info">
        <meta name="google" content="notranslate">
        <title>Add Secondary Info</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/dsEtFcDWRfdd.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Add Secondary Info</h1>
                <jsp:useBean id="getOptions" class="hibernate.query.info.ShowHideInfoOpt"/>
                <c:set var="options" value="${getOptions.getMoreInfoAddOptions(user)}"/>
                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.info)}"><div class="options_position"><a href="/info/">Primary Info</a></div></c:if><c:if test="${(options==null)||(options.moreinfo)}"><div class="options_position"><a href="/more/info/">Secondary Info</a></div></c:if><c:if test="${(options==null)||(options.setting)}"><div class="options_position"><a href="/more/info/add/settings/">Settings</a></div></c:if><c:if test="${(options==null)||(options.security)}"><div class="options_position"><a href="/more/info/add/security/">Security</a></div></c:if>
                </div>
                
                <c:if test="${(options==null)||(options.school)||(options.grcollege)||(options.gruniver)||(options.pogrcoll)||(options.pogruniv)||(options.works)||(options.location)||(options.moved)||(options.mobile)||(options.email)||(options.website)||(options.hobbies)||(options.relationship)||(options.relation)||(options.languages)||(options.religion)||(options.behaviour)||(options.myself)||(options.newcateg)}">
                <p class="fetG_Ht">Your data is yours. It depends on you what you want to share.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.school)}">
                <div class="sdf__fd_"><a href="/more/info/add/school/">Add your School</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/school/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.grcollege)}">
                <div class="sdf__fd_"><a href="/more/info/add/grcollege/">Add your College</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/grcollege/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.gruniver)}">
                <div class="sdf__fd_"><a href="/more/info/add/gruniver/">Add your University</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/gruniver/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.pogrcoll)}">
                <div class="sdf__fd_"><a href="/more/info/add/pogrcoll/">Add your Post Graduate College</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/pogrcoll/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.pogruniv)}">
                <div class="sdf__fd_"><a href="/more/info/add/pogruniver/">Add your Post Graduate University</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/pogruniver/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.works)}">
                <div class="sdf__fd_"><a href="/more/info/add/work/">Add your Work</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/work/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.location)}">
                <div class="sdf__fd_"><a href="/more/info/add/location/">Add your Location</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/location/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.moved)}">
                <div class="sdf__fd_"><a href="/more/info/add/moved/">Add your Moved</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/moved/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.mobile)}">
                <div class="sdf__fd_"><a href="/more/info/add/mobile/">Add your Mobile</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/mobile/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.email)}">
                <div class="sdf__fd_"><a href="/more/info/add/email/">Add your Email</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/email/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.website)}">
                <div class="sdf__fd_"><a href="/more/info/add/website/">Add your Website</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/website/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.hobbies)}">
                <div class="sdf__fd_"><a href="/more/info/add/hobbies/">Add your Hobbies</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/hobbies/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.relationship)}">
                <div class="sdf__fd_"><a href="/more/info/add/relationship/">Add your Relationship</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/relationship/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.relation)}">
                <div class="sdf__fd_"><a href="/more/info/add/relation/">Add your Relation</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/relation/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.languages)}">
                <div class="sdf__fd_"><a href="/more/info/add/languages/">Add your Languages</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/languages/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.religion)}">
                <div class="sdf__fd_"><a href="/more/info/add/religion/">Add your Religion</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/religion/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.behaviour)}">
                <div class="sdf__fd_"><a href="/more/info/add/behaviour/">Add your Behaviour</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/behaviour/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.myself)}">
                <div class="sdf__fd_"><a href="/more/info/add/myself/">Add about Myself</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/myself/">Hide</a></div></c:if></div>
                <p class="uera">You can add more than one school. Click above to add a new school. The school entered can be used for privacy options by you.</p>
                </c:if>
                
                <c:if test="${(options==null)||(options.newcateg)}">
                <div class="dfg_bhgf"><a href="/more/info/add/newcatg/">Something is not mentioned above</a><c:if test="${(options==null)||(options.showhide)}"><div class="ff_wew_ss"><a href="/more/info/add/hide/newcatg/">Hide</a></div></c:if></div>
                </c:if>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
