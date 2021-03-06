<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>List of users</title>
    <style type="text/css">
        body{
            background-color: beige;
        }

        table#maintable{
            margin:auto; width: 1000px; border: double ; border-color: darkgray; border-width: 2px;
        }
        table#maintable th{
            text-align: center; background-color: azure; font-size: 1.5em; height: 50px;
        }
        table#maintable td{
            background-color: white; font-size: 1.25em; border: double;
        }
        table#pagetable{
            margin: auto; font-size: 1.25em;
        }
        table#pagetable td{
            margin: auto; font-size: 1.25em;
        }
        .main{
          text-align: center;
        }
    </style>
</head>
<body>
<div class="main">
    <h1>List of users</h1>

    <p style="font-size: 1.5em">Here you can see the list of the users, edit them, remove or update.</p>

    <div class="table-view">
        <table id="maintable" cellpadding="0" cellspacing="0" >
            <thead>
            <tr>
                <th width="50" align="center" valign="middle">User ID</th>
                <th width="100" align="center" valign="middle">User name</th>
                <th width="50" align="center" valign="middle">User age</th>
                <th width="50" align="center" valign="middle">Admin</th>
                <th width="100" align="center" valign="middle">Date of creating</th>
                <th width="50" align="center" valign="middle">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td align="center">${user.id}</td>
                    <td align="center">${user.name}</td>
                    <td align="center">${user.age}</td>
                    <td align="center">
                        <c:choose>
                            <c:when test="${user.isAdmin == 'true'}">
                                yes
                            </c:when>
                            <c:when test="${user.isAdmin=='false'}">
                                no
                            </c:when>
                        </c:choose>
                    </td>
                    <td align="center">${user.createdDate}</td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
                        <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

        <div class="pagination">
            <table id="pagetable" cellpadding="3" cellspacing="0">
                <tr>
                    <c:if test="${amountOfPages > 0}">
                        <div style="float: left;">
                            <!--For displaying previous link except for the 1st page -->
                            <c:if test="${currentPage > 0}">
                                <td width="50"><a href="list.html?page=${currentPage - 1}">Prev</a></td>
                            </c:if>
                        </div>
                        <div id="div3" style="float: left;">
                            <c:set var="p" value="${currentPage}"/> <%-- current page (1-based) --%>
                            <c:set var="l" value="5"/> <%-- amount of page links to be displayed --%>
                            <c:set var="r" value="${l / 2}"/> <%-- minimum link range ahead/behind --%>
                            <c:set var="t" value="${amountOfPages}"/> <%-- total amount of pages --%>

                            <c:set var="begin"
                                   value="${((p - r) > 0 ? ((p - r) < (t - l + 1) ? (p - r) : (t - l)) : 0)}"/>
                            <c:set var="end" value="${(p + r) < t ? ((p + r) > l ? (p + r) : l) : t}"/>

                            <c:forEach begin="${begin}" end="${end - 1}" var="i">
                                <c:choose>
                                    <c:when test="${currentPage eq i}">
                                        <td width="50">${i + 1}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td width="50"><a href="list.html?page=${i}">${i + 1}</a></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                        <div style="float: left;">
                                <%--For displaying Next link except for the last page --%>
                            <c:if test="${currentPage lt amountOfPages - 1}">
                                <td><a href="list.html?page=${currentPage + 1}">Next</a></td>
                            </c:if>
                        </div>

                    </c:if>
                </tr>
            </table>
        </div>

    <p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</div>
</body>
</html>