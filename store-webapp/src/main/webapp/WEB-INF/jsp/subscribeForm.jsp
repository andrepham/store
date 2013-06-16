<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
    .error{
        color:#ff0000;
        font-weight: bold;
    }
</style>
<title>Page user</title>
</head>
<body>
<h3>Today is ${today}</h3>

<form:form method="post" modelAttribute="subscription">
<form:errors path="*" cssClass="error"/>
<table>
    <tr>
        <td>First name: </td>
        <td><form:input path="firstName" value="jack"/></td>
        <td><form:errors path="firstName" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Last name: </td>
        <td><form:input path="lastName" value="bauer"/></td>
        <td><form:errors path="lastName" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Email: </td>
        <td><form:input path="email" value="jbauer@cat.com"/></td>
        <td><form:errors path="email" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Password: </td>
        <td><form:password path="password" value="password"/></td>
        <td><form:errors path="lastName" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Password: </td>
        <td><form:password path="passwordCheck" value="password"/></td>
    </tr>
     <tr>
        <td>Number</td>
        <td><form:input path="number" value="4"/></td>
        <td><form:errors path="number" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Street</td>
        <td><form:input path="street"value="rue leclerc"/></td>
        <td><form:errors path="street" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Town</td>
        <td><form:input path="town" value="Palavas"/></td>
        <td><form:errors path="town" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Country</td>
        <td><form:input path="country" value="France"/></td>
        <td><form:errors path="country" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Submit: </td>
        <td><input type="submit"/></td>
    </tr>
</table>
</form:form>

<%-- <h3><c:out value="${requestScope['andre']}" default="Inconnu"/></h3> --%>

</body>
</html>