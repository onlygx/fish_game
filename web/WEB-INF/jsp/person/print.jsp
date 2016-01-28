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
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>

</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container"  align="center" style="margin-top: 80px;">
    <div class="row"  style="margin-top: 70%;width: 230px;">

        <div  align="left" style="font-family: 黑体;font-weight: bold;">
            <h1>编号：${obj.number}</h1>
            <h1>姓名：${obj.name}</h1>
        </div>
        <div  style="margin-top: 50px;">
            <div id="erweima"></div>
        </div>

    </div>
</div>
</body>
</html>
<script>

    (function($){
        jQuery('#erweima').qrcode({
            text : "${obj.id}",
            width:230,
            height:230
        });
        window.print();
    })(jQuery);
</script>