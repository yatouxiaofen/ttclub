<%--
  Created by IntelliJ IDEA.
  User: LiuSuFen
  Date: 2018/4/19 0019
  Time: 上午 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:50px">
    <h2>后台管理系统</h2>
</div>
<div data-options="region:'south',split:true" style="height:50px;"></div>
<div data-options="region:'west',split:true" title="West" style="width:250px;">
    <div id="menus" class="easyui-accordion" style="width:243px;">
    </div>
</div>
<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" style="width:100%;height:100%">
        <div title="主页" style="padding:10px">
            <h2>欢迎来到后台管理界面</h2>
            <ul>
                <li>系统管理</li>
                <li>业务管理</li>
                <li>个人网站管理</li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/menu.js"></script>
<script type="text/javascript">
    $(function(){
        getUserMenu();
    })
</script>
</html>
