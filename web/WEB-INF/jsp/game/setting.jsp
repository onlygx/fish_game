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
<body >
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container" style="margin-top: 70px;">

    <form class="form-horizontal" id="gameParam">
        <fieldset>
            <legend>赛事管理</legend>
        </fieldset>
        <div class="form-group">
            <label for="input1" class="col-sm-1 control-label">赛事名称</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="input1" value="${game.name}">
                <input type="hidden" name="id" value="${game.id}">
            </div>
        </div>

        <div class="form-group">
            <label for="input2" class="col-sm-1 control-label">主办单位</label>
            <div class="col-sm-10">
                <input type="text" name="zhu" class="form-control" id="input2"  value="${game.zhu}">
            </div>
        </div>

        <div class="form-group">
            <label for="input3" class="col-sm-1 control-label">承办单位</label>
            <div class="col-sm-10">
                <input type="text" name="cheng" class="form-control" id="input3"  value="${game.cheng}">
            </div>
        </div>

        <div class="form-group">
            <label for="input4" class="col-sm-1 control-label">场次数量</label>
            <div class="col-sm-10">
                <input type="text" name="chang" class="form-control" id="input4"  value="${game.chang}">
            </div>
        </div>
        <div class="form-group">
            <label for="input5" class="col-sm-1 control-label">钓区数量</label>
            <div class="col-sm-10">
                <input type="text" name="qu" class="form-control" id="input5"  value="${game.qu}">
            </div>
        </div>

        <div class="form-group">
            <label for="input6" class="col-sm-1 control-label">备注</label>
            <div class="col-sm-10">
                <input type="text" name="intro" class="form-control" id="input6"  value="${game.intro}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="button" class="btn btn-success" onclick="update()">修改</button>
                <button type="button" class="btn btn-danger" onclick="save()">创建新比赛</button>
            </div>
        </div>
    </form>

    <form class="form-horizontal" id="personParam">
        <fieldset>
            <legend>裁判以及主席管理</legend>
        </fieldset>
        <div class="form-group">
            <label for="select2_1" class="col-sm-1 control-label">身份</label>
            <div class="col-sm-10">
                <select class="form-control" name="type" id="select2_1">
                    <option value="1">组委会主席</option>
                    <option value="2">主任仲裁员</option>
                    <option value="3">总裁判长</option>
                    <option value="4">副总裁判长</option>
                    <option value="5">成统裁判长</option>
                    <option value="6">成统裁判员</option>
                    <option value="7">分区裁判长</option>
                    <option value="8">分区裁判员</option>
                    <option value="9">助理裁判员</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="input2_2" class="col-sm-1 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="input2_2" >
                <input type="hidden" name="gameId" value="${game.id}">
            </div>
        </div>
        <div class="form-group">
            <label for="input2_3" class="col-sm-1 control-label">电话</label>
            <div class="col-sm-10">
                <input type="text" name="phone" class="form-control" id="input2_3" >
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="button" class="btn btn-success" onclick="savePerson()">添加</button>
            </div>
        </div>
    </form>
    <table style="width: 100%;" class="table table-striped table-bordered">
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th>身份</th>
            <th>操作</th>
        </tr>
    <c:forEach var="item" items="${persons}" varStatus="status" >
        <tr>
            <td>${item.name}</td>
            <td>${item.phone}</td>
            <td>
                <c:if test="${item.type==1}">组委会主席</c:if>
                <c:if test="${item.type==2}">主任仲裁员</c:if>
                <c:if test="${item.type==3}">总裁判长</c:if>
                <c:if test="${item.type==4}">副总裁判长</c:if>
                <c:if test="${item.type==5}">成统裁判长</c:if>
                <c:if test="${item.type==6}">成统裁判员</c:if>
                <c:if test="${item.type==7}">分区裁判长</c:if>
                <c:if test="${item.type==8}">分区裁判员</c:if>
                <c:if test="${item.type==9}">助理裁判员</c:if>

            </td>
            <td>
                <a href="javascript:void(0);" onclick="delPerson('${item.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>

    </table>
</div>
</body>
</html>
<script>
    function savePerson(){
        var param = tools.formParams("personParam");
        tools.action("/person/save",param,function(data){
            tools.tip(data,{1:"操作失败！"});
            location.reload();
        });
    }

    function delPerson(id){
        if(!confirm("确定删除么？")){
            return;
        }
        tools.action("/person/delete",{"id":id},function(data){
            tools.tip(data,{1:"操作失败！"});
            location.reload();
        });
    }

    function update(){
        var param = tools.formParams("gameParam");
        tools.action("/game/update",param,function(data){
            tools.tip(data,{1:"操作失败！"});
        });
    }

    function save(){
        if(!confirm("您确定新建比赛吗？")){
            return;
        }
        var param = tools.formParams("gameParam");
        tools.action("/game/save",param,function(data){
            tools.tip(data,{1:"操作失败！"});
        });
    }
</script>