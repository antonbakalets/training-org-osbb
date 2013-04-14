<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="os"      tagdir="/WEB-INF/tags" %>

<os:title-h1 text="Вхід"/>--%>
<form method="POST" action="<c:url value="/j_spring_security_check"/>" class="form-horizontal">
    <fieldset>
        <div id="legend">
            <legend class="">Вхід</legend>
        </div>



        <c:if test="${!empty messageCode}">
            <div class="alert alert-success">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <spring:message code="${messageCode}"/>
            </div>
        </c:if>

        <c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION.message}">
            <div class="alert alert-error">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
            </div>
        </c:if>

        <div class="control-group">
            <label class="control-label"  for="username"><spring:message code="login.username"/>:</label>
            <div class="controls">
                <input type="text" id="username" name="j_username" placeholder="" class="input-xlarge" autocomplete="off">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="password"><spring:message code="login.password"/>:</label>
            <div class="controls">
                <input type="password" id="password" name="j_password" placeholder="" class="input-xlarge">
            </div>
        </div>

        <div class="control-group">

            <div class="controls">
                <label class="checkbox" for="password">
                    <input id="login-rememberme" type="checkbox" name="_spring_security_remember_me" />
                    <spring:message code="login.remember"/>
                </label>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <input id="login-submit" type="submit" value="<spring:message code="login.button.login"/>" class="btn btn-success"/>
                <a href="#">Forgot Password?</a>
            </div>
        </div>
    </fieldset>
</form>


