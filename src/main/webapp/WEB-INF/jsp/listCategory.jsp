<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>listCategory</title>
</head>
<body>

    <div style="text-align:center">
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>分类</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${cs}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><a href="/editCategory?id=${c.id}">编辑</a></td>
                    <td><a href="/deleteCategory?id=${c.id}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">
                    <a href="?start=0">首页</a>
                    <a id="prePage" href="?start=${page.start - page.count}">上一页</a>
                    <a id="nextPage" href="?start=${page.start + page.count}">下一页</a>
                    <a href="?start=${page.last}">末页</a>
                </td>
            </tr>
        </table>
    </div>

    <div style="margin-top:40px">
        <form method="post" action="/addCategory">
            分类名称： <input name="name" type="text">
            <input type="submit" value="增加分类">
        </form>
    </div>

</body>
</html>