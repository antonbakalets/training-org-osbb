<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="tiles"   uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<c:set var="locale" value="${pageContext.response.locale}"/>
<html lang="${locale.language}" xmlns="http://www.w3.org/1999/xhtml">
    <head> 
        <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/magic-bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css" />

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" />

        <title><spring:message code="jsp.osbb.title"/></title>
    </head>

    <body>
        <noscript>
            This page uses JavaScript and requires a JavaScript enabled browser.
            Your browser is not JavaScript enabled.
        </noscript>
        <span id="menuitem" class="ui-helper-hidden"><tiles:insertAttribute name="menuitem" ignore="true" /></span>

        <div>
            <header>
                <br/>
                <br/>
                <br/>
            </header>>
            <div class="container clearfix">
                <tiles:insertAttribute name="body" />
            </div>
            <footer>
                <br/>
                <br/>
                <%--<a href="${pageContext.request.contextPath}/registration/register.html">Зареєструватися</a>--%>
            </footer>
        </div>
    </body>
</html>