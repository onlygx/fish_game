<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/8 0008
  Time: 下午 18:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>制表打印</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container"  align="center" style="margin-top: 80px;">
    <h3>
        第 ${chang} 场
        <c:if test="${qu != null}">
            ，第 ${qu} 区
        </c:if>
        信息
    </h3>
    <table style="width: 100%;" class="table table-striped table-bordered">
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th>地址</th>
            <th>报名费</th>
            <th>队伍</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <c:forEach var="item" items="${persons}" varStatus="status">
            <tr>
                <td>${item.name}</td>
                <td>${item.phone}</td>
                <td>${item.address}</td>
                <td>${item.price}</td>
                <td>${item.group}</td>
                <td>${item.intro}</td>
                <td>
                    <a href="javascript:void(0);" onclick="del('${item.id}')">删除</a>
                    <a href="/person/print/${item.id}"  target="_blank">查看/打印</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
<script>

</script>