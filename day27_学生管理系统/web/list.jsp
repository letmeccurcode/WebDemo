<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>

<%--<c:if test="${msg == 'java'}">--%>

<%--</c:if>--%>

<%--<c:forEach items="" var="">--%>

<%--</c:forEach>--%>

<%--<c:forEach begin="0" end="10" var="i" step="2">--%>

<%--</c:forEach>--%>

<%--<c:set scope="session" var="x" value="java">--%>

<%--</c:set>--%>

<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>生日</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${list}" var="stu">

            <tr>
                <td>${stu.id}</td>
                <td>${stu.sname}</td>
                <td>${stu.sex}</td>
                <td>${stu.age}</td>
                <td>${stu.address}</td>
                <td>${stu.qq}</td>
                <td>${stu.birthStr}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findstubyidServlet?id=${stu.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" onclick="deletestu(${stu.id});">删除</a></td>
<%--         href="${pageContext.request.contextPath}/deletestuServlet?id=${stu.id}"       --%>
<%--                 /stu/deletestuServlet?id=1         --%>
<%--                ima src="${pagecontext.request.contextpaath}/CheckcodeServlet"    --%>
            </tr>

        </c:forEach>


        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a></td>
        </tr>
    </table>
</div>

<script>

    function deletestu(id) {
        // var flag = confirm("确定要删除吗");
        if (confirm("确定要删除吗")){
            location.href = "${pageContext.request.contextPath}/deletestuServlet?id="+id;
        }
    }

</script>
</body>
</html>

