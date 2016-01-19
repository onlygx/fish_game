<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/7 0007
  Time: 下午 12:06
  To change this template use File | Settings | File Templates.
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
    <title>比赛列表</title>
    <link href="/favicon.ico" type="image/x-icon" rel="shortcut icon" />

    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/datatables.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/datatables.min.js"></script>
    <script src="/static/js/tools.js"></script>
</head>
<body style="background-image: url('/images/index-background.jpg')">
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" >
    <div align="center" style="">
        <img src="/images/index-top.png" style="width: 30%;height: 30%;">
    </div>
    <div  align="center">
        <h1 style="color: black;">钓鱼比赛服务系统</h1>
    </div>
    <div  align="center" style="margin-top: 50px;">
        <table style="width: 100%;text-align: center;" align="center">
            <tr>
                <td align="center">
                    <a class="btn btn-info" href="/game/setting">赛事设置</a>
                </td>
                <td align="center">
                    <button class="btn btn-success" onclick="">报名检入</button>
                </td>
                <td align="center">
                    <button class="btn btn-warning" onclick="">开始抽签</button>
                </td>
                <td align="center">
                    <button class="btn btn-primary"  data-toggle="modal" data-target="#myModal"  onclick="">制表打印</button>
                </td>
                <td align="center">
                    <button class="btn btn-danger" onclick="">成绩导入</button>
                </td>
                <td align="center">
                    <button class="btn btn-success" onclick="">成绩打印</button>
                </td>
                <td align="center">
                    <button class="btn btn-info" onclick="">幸运抽奖</button>
                </td>
            </tr>
        </table>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">功能</h4>
            </div>
            <div class="modal-body">
                <div>
                    <h1>

                    </h1>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
