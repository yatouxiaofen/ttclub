<%--
  Created by IntelliJ IDEA.
  User: LiuSuFen
  Date: 2018/4/19 0019
  Time: 上午 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include.jsp" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/bootstrap-3.3.7/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body>
    <div class="panel panel-primary" style="width: 500px;height: 400px;margin: 100px auto;">
        <div class="panel-heading">
            <h3 class="panel-title">登录</h3>
        </div>
        <div class="panel-body">
            <form action="login" method="post">
                <div class="input-group" style="margin-bottom: 20px;">
                    <span class="input-group-addon">@</span>
                    <input id="loginName" name="loginName" required type="text" class="form-control" placeholder="用户名"/>
                </div>
                <div class="input-group"  style="margin-bottom: 20px;">
                    <span class="input-group-addon">@</span>
                    <input id="password" name="password" required type="password" class="form-control" placeholder="密码"/>
                </div>
                <div class="input-group" style="margin: 0 auto;">
                    <button type="submit" style="width:280px;" class="btn btn-default">登 录</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            if(window !=top){
                top.location.href=location.href;
            }
            if('${message}'){
                alert('${message}');
            }
        })
    </script>
</body>
</html>
