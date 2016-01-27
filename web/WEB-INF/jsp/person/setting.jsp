<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/19 0019
  Time: 下午 14:26
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
    <title>人员设置</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/tools.js"></script>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container" style="margin-top: 70px;">

    <form class="form-horizontal" id="personParam">
        <fieldset>
            <legend>参赛人员添加</legend>
        </fieldset>
        <div class="form-group">
            <label for="input1" class="col-sm-1 control-label">人员名称</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="input1">
                <input type="hidden" name="type" value="20">
                <input type="hidden" name="gameId" value="${game.id}">
            </div>
        </div>

        <div class="form-group">
            <label for="input2" class="col-sm-1 control-label">联系电话</label>
            <div class="col-sm-10">
                <input type="text" name="phone" class="form-control" id="input2">
            </div>
        </div>

        <div class="form-group">
            <label for="input3" class="col-sm-1 control-label">地址</label>
            <div class="col-sm-10">
                <input type="text" name="address" class="form-control" id="input3">
            </div>
        </div>

        <div class="form-group">
            <label for="input4" class="col-sm-1 control-label">报名费</label>
            <div class="col-sm-10">
                <input type="text" name="price" class="form-control span3" id="input4">
            </div>
        </div>
        <div class="form-group">
            <label for="input5" class="col-sm-1 control-label">队伍</label>
            <div class="col-sm-10">
                <input type="text" name="group" class="form-control"  id="input5">
            </div>
        </div>

        <div class="form-group">
            <label for="input6" class="col-sm-1 control-label">备注</label>
            <div class="col-sm-10">
                <input type="text" name="intro" class="form-control" id="input6">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="button" class="btn btn-success" onclick="save()">添加</button>
                <a class="btn btn-info" href="javascript:location.reload()" >清空内容</a>
            </div>
        </div>
    </form>

    <table style="width: 100%;" class="table table-striped table-bordered">
        <tr>
            <th>编号</th>
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
                <td>${item.number}</td>
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
    function save() {
        var param = tools.formParams("personParam");
        tools.action("/person/save", param, function (data) {
            tools.tip(data, {1: "操作失败！"});
            if(data.success){
                if(confirm("是否打印？")){
                    location.href="/person/print/"+data.data;
                }else{
                    location.reload();
                }
            }

        });
    }

    function del(id) {
        if(!confirm("确定删除么？")){
            return;
        }
        tools.action("/person/delete", {"id": id}, function (data) {
            tools.tip(data, {1: "操作失败！"});
            location.reload();
        });
    }
</script>