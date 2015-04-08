<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Edit user page</title>
    <style>
        body {
            background-color: beige;
        }

        td {
            font-size: 1.2em
        }

        input {
            display: inline-block;
            margin-right: 10px;
            font-size: 0.9em
        }

        form {
            line-height: 160%;
        }

        .error {
            color: red;
            font-size: 0.9em;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Edit user page</h1>

<p style="font-size: 1.5em">Here you can edit the existing team.</p>

<p>${message}</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}.html">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Admin:</td>
            <td>
                <input type="radio" name="isAdmin" value="true"
                       <c:if test="${user.isAdmin == 'true'}">checked</c:if>/>YES
                <input type="radio" name="isAdmin" value="false"
                       <c:if test="${user.isAdmin == 'false'}">checked</c:if>/>NO
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit"/></td>

        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>