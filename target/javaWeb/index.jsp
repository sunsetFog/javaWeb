<%--
  <%@ page新建jsp文件才有
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
配置了web.xml才能用${}
${pageContext.request.contextPath} 默认路径   /host
以post的方式，请求login页接口
--%>
<h2>默认路径: ${pageContext.request.contextPath}</h2>


<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="get">
        用户名: <input type="text" name="username" required>  <br>
        密码: <input type="password" name="password" required> <br>
        爱好:
        <input type="checkbox" name="hobbys" value="女孩">女孩
        <input type="checkbox" name="hobbys" value="代码">代码
        <br>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
