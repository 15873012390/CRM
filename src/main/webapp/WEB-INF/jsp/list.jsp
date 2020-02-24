<%--
  Created by IntelliJ IDEA.
  User: heting
  Date: 2020/1/6
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <style>
        table, td{
            border: 1px solid #CCCCCC;
        }

        td, th{
            padding: 5px;
        }

        th{
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>管理员列表</h1>
    <table border="1" width="100%" style="border-collapse: collapse">
        <thead>
            <th>编号</th>
            <th>名称</th>
            <th>注册时间</th>
            <th>操作</th>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="c">
                <tr>
                    <td>${c.aid}</td>
                    <td>${c.name}</td>
                    <td><fmt:formatDate value="${c.regTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                    <td>编辑 删除</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
