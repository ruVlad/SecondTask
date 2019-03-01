<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 01.03.2019
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>


<table border="5">
    <thead>
    <tr>
        <td rowspan="2">Б/сч</td>
        <td colspan="2">Входящее сальдо</td>
        <td colspan="2">Обороты</td>
        <td colspan="2">Исходящее сальдо</td>
    </tr>
    <tr>
        <td>Актив</td>
        <td>Пассив</td>
        <td>Дебет</td>
        <td>Кредит</td>
        <td>Актив</td>
        <td>Пассив</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="cell" step="7" varStatus="i">
        <tr>
            <td><c:out value="${list[i.index]}"/></td>
            <td><c:out value="${list[i.index+1]}"/></td>
            <td><c:out value="${list[i.index+2]}"/></td>
            <td><c:out value="${list[i.index+3]}"/></td>
            <td><c:out value="${list[i.index+4]}"/></td>
            <td><c:out value="${list[i.index+5]}"/></td>
            <td><c:out value="${list[i.index+6]}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
