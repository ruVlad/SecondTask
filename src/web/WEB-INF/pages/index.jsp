
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<meta http-equiv="content-type" content="text/html; charset=windows-1251" />
<form enctype="multipart/form-data" method="POST" action="${pageContext.request.contextPath}/parse.html" >
    <p><input type="file" name="file"/>
        <input type="submit" value="Send"></p>
</form>

<c:forEach items="${files}" var="file">
    <tr>
        <p><a href="${pageContext.request.contextPath}/show/${file.id}.html"><c:out value="${file.fileName}"/></a>
    </tr>
</c:forEach>
</body>
</html>
