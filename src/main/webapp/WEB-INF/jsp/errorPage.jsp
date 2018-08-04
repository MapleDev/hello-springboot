<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>errorPage</title>
</head>
<body>
    <div style="width:500px;border:1px solid lightgray;margin:200px auto;padding:80px;background: lightgray; color: red">
        系统 出现了异常，异常原因是：${exception}
        <br/>
        出现异常的地址是：${url}
    </div>
</body>
</html>
