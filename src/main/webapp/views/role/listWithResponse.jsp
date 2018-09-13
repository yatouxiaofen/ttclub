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
<table class="easyui-datagrid"
       data-options="rownumbers:true,
        singleSelect:true,
        toolbar:'#tb',
        striped:true,
        fitColumns:true,
        pagination:true">
    <thead>
    <tr>
        <th data-options="field:'roleName',width:180">角色名</th>
        <th data-options="field:'genTime',width:180">创建时间</th>
        <th data-options="field:'description',width:180">备注</th>
        <th data-options="field:'putRight',width:180">操作</th>
    </tr>
    </thead>
    <tbody>
        <c:if test="${empty roleList}">
            <tr>
                <td colspan="4">暂无数据</td>
                <td></td>
            </tr>
        </c:if>
        <c:if test="${not empty roleList}">
            <c:forEach items="${roleList}" var="role" varStatus="status">
                <tr>
                    <td>${role.roleName}</td>
                    <td>${role.genTime}</td>
                    <td>${role.description}</td>
                    <td><a href="javascript:void(0);" onclick="openPutRightDlg(${role.trId});">分配权限</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
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
</script>
</html>
