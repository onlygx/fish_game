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
<body  class="body-bg">
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
                    <a class="btn btn-info" href="/game/setting" target="_blank">赛事设置</a>
                </td>
                <td align="center">
                    <a class="btn btn-success" href="/person/setting" target="_blank">报名检入</a>
                </td>
                <td align="center">
                    <a class="btn btn-warning" href="/game/show/${game.id}" target="_blank">下载比赛</a>
                </td>
                <td align="center">
                    <button class="btn btn-primary"  data-toggle="modal" data-target="#myModal"  onclick="">制表打印</button>
                </td>
                <td align="center">
                    <button class="btn btn-success"  data-toggle="modal" data-target="#myModal2"  onclick="">成绩打印</button>
                </td>
                <td align="center">
                    <a class="btn btn-info" href="/person/lucky/${game.id}" target="_blank">幸运抽奖</a>
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
                <h4 class="modal-title" id="myModalLabel">制表打印</h4>
            </div>
            <div class="modal-body">
                <div>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <a href="/grade/info/${game.id}/${status1.index}" target="_blank">第 ${status1.index} 场</a>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/info/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">成绩打印</h4>
            </div>
            <div class="modal-body">
                <div>
                    <fieldset>
                        <legend>个人排名</legend>
                    </fieldset>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <a href="/grade/show/${game.id}/${status1.index}" target="_blank">第 ${status1.index} 场</a>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/show/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                    <fieldset>
                        <legend>队伍排名</legend>
                    </fieldset>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <a href="/grade/group/${game.id}/${status1.index}" target="_blank">第 ${status1.index} 场</a>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/group/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
