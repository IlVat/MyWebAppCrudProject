<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Add user page</title>
</head>
<body>
<h1>Add user page</h1>

<p>Here you can add a new user.</p>

<p>${message}</p>

    <style>
       /* body { background-color: #eee; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
        .green { font-weight: bold; color: green; }
        .message { margin-bottom: 10px; }
        label {width:70px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }*/
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>


<div id="container">

    <form:form method="POST" action="${pageContext.request.contextPath}/user/add.html" modelAttribute="user" commandName="user">
        <table>
            <tbody>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" value="${user.name}"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" value="${user.age}"/></td>
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
                <td><input type="submit" value="Submit"/></td>

            </tr>
            </tbody>
        </table>
    </form:form>
</div>




<%--<script type="text/javascript">

    $(document).ready(function() {

        toggleFrequencySelectBox(); // show/hide box on page load

        $('#newsletterCheckbox').change(function() {
            toggleFrequencySelectBox();
        })

    });

    function toggleFrequencySelectBox() {
        if(!$('#newsletterCheckbox').is(':checked')) {
            $('#frequencySelect').val('');
            $('#frequencySelect').prop('disabled', true);
        } else {
            $('#frequencySelect').prop('disabled', false);
        }
    }

</script>--%>

</body>