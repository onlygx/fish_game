<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/19 0019
  Time: 上午 10:42
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
    <title>比赛设置</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/tools.js"></script>

</head>
<body style="background-image: url('/images/index-background.jpg')">
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container" style="margin-top: 70px;">
    <form class="form-horizontal" id="gameParam">
        <div class="form-group">
            <label for="input1" class="col-sm-2 control-label">赛事名称</label>
            <div class="col-sm-10">
                <input type="email" name="name" class="form-control" id="input1" value="${game.name}">
                <input type="hidden" name="id" value="${game.id}">
            </div>
        </div>

        <div class="form-group">
            <label for="input2" class="col-sm-2 control-label">主办单位</label>
            <div class="col-sm-10">
                <input type="email" name="zhu" class="form-control" id="input2"  value="${game.zhu}">
            </div>
        </div>

        <div class="form-group">
            <label for="input3" class="col-sm-2 control-label">承办单位</label>
            <div class="col-sm-10">
                <input type="email" name="cheng" class="form-control" id="input3"  value="${game.cheng}">
            </div>
        </div>

        <div class="form-group">
            <label for="input4" class="col-sm-2 control-label">场次数量</label>
            <div class="col-sm-10">
                <input type="email" name="chang" class="form-control" id="input4"  value="${game.chang}">
            </div>
        </div>
        <div class="form-group">
            <label for="input5" class="col-sm-2 control-label">钓区数量</label>
            <div class="col-sm-10">
                <input type="email" name="qu" class="form-control" id="input5"  value="${game.qu}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default" onclick="save()">确定</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    function save(){

        var param = tools.formParams("gameParam");
        tools.action("/game/update",param,function(data){
            tools.tip(data,{1:"操作失败！"});
        })
    }
</script>