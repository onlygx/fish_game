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
    <title>幸运抽奖</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>

</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container"   style="margin-top: 80px;">
    <di style="padding-bottom: 50px;" align="left">
        <button class="btn btn-info" onclick="luck()">抽奖</button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中奖用户：<span id="luckResoult">点击抽奖开始抽奖...</span>
    </di>

    <table style="width: 100%;margin-top: 20px; " class="table table-striped table-bordered">
        <tr>
            <th>选择</th>
            <th>编号</th>
            <th>姓名</th>
            <th>电话</th>
            <th>队伍</th>
            <th>备注</th>
        </tr>
        <c:forEach var="item" items="${persons}" varStatus="status">
            <tr >
                <td>
                    <input type="checkbox" id="p_${item.id}" checked name="persons" value="${item.id}">
                </td>
                <td>${item.number}</td>
                <td id="n_${item.id}">${item.name}</td>
                <td>${item.phone}</td>
                <td>${item.group}</td>
                <td>${item.intro}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
<script>

    function luck(){
        var pers = new Array();
        $('input[name="persons"]:checked').each(function(){
            pers.push($(this).val());
        });
        var random = parseInt(Math.random()*pers.length);
        var id = pers[random];
        var name = $("#n_"+id).text();
        $("#luckResoult").text(name);
        $("#p_"+id).attr("checked",false);
    }

</script>