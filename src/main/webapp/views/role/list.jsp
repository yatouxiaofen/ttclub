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
<table id="roleTable" class="easyui-datagrid" title="角色列表"
       data-options="rownumbers:true,singleSelect:true,url:'${ctx}/role/getRoleList',method:'get',toolbar:'#tb'">
    <thead>
    <tr>
        <th data-options="field:'trId',width:80">ID</th>
        <th data-options="field:'roleName',width:100">角色名</th>
        <th data-options="field:'genTime',width:80,align:'right'">创建时间</th>
        <th data-options="field:'description',width:80,align:'right'">备注</th>
    </tr>
    </thead>
</table>
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

<%-- 权限分配弹出框 --%>
<div id="putRightDlg"></div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript">
    function openPutRightDlg(trId) {
        $('#putRightDlg').dialog({
            title: '分配权限',
            width: 500,
            height: 500,
            closed: false,
            modal: true,
            href:'${ctx}/role/getRoleRightList?roleId='+trId
        });
    }

    $(function () {
        $('#editRole').click(function () {
            var record = $('#roleTable').datagrid('getSelected');
            openPutRightDlg(record.trId);
        })
    })
</script>
</html>
