<%--
  Created by IntelliJ IDEA.
  User: 82386
  Date: 2020/7/8
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--设置变量-->
<c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
<!--引入样式-->
<link rel="stylesheet" href="${path}/css/index.css"/>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <h1>上传文件</h1>
    <hr>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>选择文件:</td>
                <td><input type="file" name="filename"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="上传"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
