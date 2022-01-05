<!--HTML注释：客户端显示（右键--查看网页源代码）-->
<%--
  JSP注释：客户端不显示
  webapp这里html和jsp的区别：
  html只给用户提供静态数据
  jsp页面可以嵌套java代码，为用户提供动态数据
  jsp原理：
  jsp最终转换成一个java类
  jsp本质就是servlet

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
指定错误页面
--%>
<%--
<%@ page errorPage="error/500.jsp" %>
--%>
<%--
导入jar包
--%>
<%@ page import="java.util.*" %>
<%--
引入JSTL标签库
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
公用组件
@include将两个页面合二为一
jsp标签：拼接页面
--%>
<%@include file="common/header.jsp"%>
<jsp:include page="/common/header.jsp"/>


${pageContext.request.contextPath}
${requestScope}
<br/>
<%
    String val = "hello" + "\r\n" + "world";
    out.print("-----yu------"+val);
%>
<br/>
<%
    String name = "叽叽叽叽";
%>
name: <%=name%>
<%--
jsp的基础语法：
jsp表达式
<%= 变量或者表达式 %>
作用：用来将程序输出到客户端

导入jar包，才能用new Date()
--%>
<hr/>
<%= new java.util.Date() %>
<hr/>
<%--
jsp脚本片段中的代码，会生成到java类里
--%>
<%
//    int ytr = 1/0;  1/0会报错500，1/1正常
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>
<%--
在代码中嵌套入html元素
--%>
<hr/>
<%
    for (int i = 0; i < 3; i++) {
%>
    <h2>循环中：<%=i%></h2>
<%
    }
%>
<hr>
<%--
jsp声明：被编译一个java的类，生成到_jspServlet方法中
--%>
<%!
    static {
        System.out.println("Loading Servlet!");
    }
    private int ksk = 0;
    public void iye() {
        System.out.println("进入了iye方法！");
    }
%>
<hr>
<%--
9大内置对象：
  页面上下文    ${pageContext.}
  session    ${session.}
  application    ${application.}
  配置    ${config.}
  输出对象    ${out.}
  当前页    ${page.}  几乎不用
  请求    ${request.}
  响应    ${response.}
  异常    ${excepetion.}

  其中有四个能保存数据，用pageContext取值
  从底层到高层（作用域）：page_scope < request_scope < session_scope < application_scope
  不同页面获取保存的数据，只有session和application取到
--%>
<%
    pageContext.setAttribute("name1", "1号");// 页面中有效
    // pageContext.setAttribute("name1", "1号", PageContext.SESSION_SCOPE);// 指定作用域
    request.setAttribute("name2", "2号");// 请求中有效，请求转发携带这个数据   应用：新闻
    session.setAttribute("name3", "3号");// 会话中有效，从打开浏览器到关闭浏览器  应用：购物车
    application.setAttribute("name4", "4号");// 服务器中有效，从打开服务器到关闭服务器
    // 跳转
//    pageContext.forward("/index.jsp");
//    request.getRequestDispatcher("/index.jsp").forward(request, response);
%>
<%
    String name1 =(String) pageContext.findAttribute("name1");
    String name2 =(String) pageContext.findAttribute("name2");
    String name3 =(String) pageContext.findAttribute("name3");
    String name4 =(String) pageContext.findAttribute("name4");
%>
<h2>name1: ${name1}</h2>
<h2>name2: ${name2}</h2>
<h2>name3: ${name3}</h2>
<h2>name4: ${name4}</h2>

<hr>
<%--
jsp标签：转发跳转并带参
<jsp:forward page="/study.jsp">
    <jsp:param name="name" value="hong"/>
    <jsp:param name="age" value="12"/>
</jsp:forward>
另一页面接收参数
--%>

url名字：<%=request.getParameter("name")%>
<br>
url年龄：<%=request.getParameter("age")%>
<hr>
<%--
JSTL标签为了弥补HTML标签，有很多自定义标签
--%>
<form action="study.jsp" method="get">
    <%--
    EL表达式获取表单中的数据   ${param.参数名}
    --%>
    <input type="text" name="username" value="${param.username}" required>
    <input type="submit" value="登录">
</form>
<%--
判断提交的用户是管理员，则登录成功
--%>
<%
//     request.getParameter("username")为null报错500
//    if(request.getParameter("username").equals("admin")) {
//        out.print("登录成功"+request.getParameter("username"));
//    }else{
//        out.print("登录失败，用户不是管理员！");
//    }
%>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎您！"/>
</c:if>
<c:out value="${isAdmin}"/>
<%--
定义一个变量
--%>
<c:set var="score" value="85"/>
<c:choose>
    <c:when test="${score>=90}">
        成绩优秀！
    </c:when>
    <c:when test="${score>=80}">
        成绩一般！
    </c:when>
    <c:when test="${score>=70}">
        成绩良好！
    </c:when>
    <c:when test="${score<60}">
        成绩不合格！
    </c:when>
</c:choose>
<hr>
<%
    ArrayList<String> people = new ArrayList<>();
    people.add(0,"明0");
    people.add(1,"明1");
    people.add(2,"明2");
    request.setAttribute("list", people);
%>
<c:forEach var="item" items="${list}">
    <c:out value="${item}"/> <br>
</c:forEach>

</body>
</html>
