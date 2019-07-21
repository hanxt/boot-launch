<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table class="">
    <tr>
        <td>作者</td>
        <td>教程名称</td>
        <td>内容</td>
    </tr>
    <c:forEach var="article" items="${articles}">
        <tr class="text-info">
            <td>${article.author}</td>
            <td>${article.title}</td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>


</table>
<img src="/image/template.png">
</body>
</html>

