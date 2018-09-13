<%--
  Created by IntelliJ IDEA.
  User: LiuSuFen
  Date: 2018/4/23 0023
  Time: 上午 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include.jsp"%>
<html>
<head>
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body>
<table id="roleTable"></table>
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a id="editRole" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
    <div>
        角色名称: <input class="easyui-datebox" style="width:80px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common-childtab.js"></script>
<script type="text/javascript">
    $(function () {
        $('#roleTable').datagrid({
            toolbar: '#tb',
            url:'${ctx}/role/getRoleList',
            striped:true,
            singleSelect:true,
            columns:[[
                {field:'trId',title:'主键',width:100},
                {field:'roleName',title:'权限名',width:100},
                {field:'genTime',title:'创建时间',width:100},
                {field:'description',title:'备注',width:100,align:'right'}
            ]]
        })

       /* 跳转新tab页面 */
       $('#editRole').click(function () {
            var record = $('#roleTable').datagrid('getSelected');
            tabsAdd('角色权限','${ctx}/role/getRoleRightList1?roleId='+record.trId);
        })

    })
</script>
</html>
