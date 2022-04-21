<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All posts</title>
</head>
<body>

<c:forEach var="post" items="${myattribute}">
    ${post.title}<br>
    ${post.text}<br>
    ${post.created}<br>
    <br>
</c:forEach>
</body>
</html>
