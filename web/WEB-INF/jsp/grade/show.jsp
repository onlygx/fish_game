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
    <title>成绩打印</title>
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
    </h3>
    <table style="width: 100%;margin-top: 30px;" class="table table-striped table-bordered">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>钓位</th>
            <th>尾数</th>
            <th>重量</th>
            <th>计分</th>
            <th>罚分</th>
            <th>得分</th>
            <th>名次</th>
        </tr>
        <c:forEach var="item" items="${grades}" varStatus="status">
            <tr>
                <td>${item.personNumber}</td>
                <td>${item.personName}</td>
                <td>${item.room}</td>
                <td>${item.number}</td>
                <td>${item.weight}</td>
                <td>${item.grade}</td>
                <td>${item.ranking}</td>
                <td>${item.grade+item.ranking}</td>
                <td>${status.count}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
<script>

</script>