<%--
  Created by IntelliJ IDEA.
  User: LiuSuFen
  Date: 2018/4/23 0023
  Time: 上午 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../include.jsp"%>
<html>
<head>
    <title>文章列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body>
<table id="listTable"></table>
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a id="remove" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
    <div>
        名称: <input id="catName" class="easyui-textbox" style="width:160px">
        <a id="search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/common-childtab.js"></script>
<script type="text/javascript">
    $(function () {
        $('#listTable').datagrid({
            toolbar: '#tb',
            url:'${ctx}/article/getList',
            rownumbers:true,
            fitColumns:true,
            striped:true,
            singleSelect:true,
            idField:'id',
            columns:[[
                {field:'id',title:'主键',hidden:true},
                {field:'name',title:'名称',width:50},
                {field:'remark',title:'备注信息',width:50},
                {field:'genTime',title:'创建时间',width:50,formatter:formatDatebox},
                {field:'lastUpdateTime',title:'更新时间',width:50,formatter:formatDatebox,align:'right'}
            ]]
        })
    })

    $('#add').click(function () {
        var url = '${ctx}/article/toSave';
        tabsAdd("添加文章",url);
    })

    $('#edit').click(function () {
        var record = $('#listTable').datagrid('getSelected');
        if(record==null){
            alert("请选择需要修改的数据！");
            return;
        }
        var url = '${ctx}/article/toEdit?id='+record.id;
        tabsAdd("修改文章",url);
    })

    $('#remove').click(function () {
        var record = $('#listTable').datagrid('getSelected');
        if(record==null){
            alert("请选择需要删除的数据！");
            return;
        }
        $.messager.confirm('确认', '确认删除吗?', function(r){
            if (r){
                $.ajax({
                    url: '${ctx}/article/remove',
                    method: 'post',
                    data:{id:record.id},
                    dataType:'json',
                    success:function (data) {
                        if(data.code=='0000'){
                            alert('操作成功！');
                        }else {
                            alert(data.message);
                        }
                    }
                })
            }
        });
    })

    $('#search').click(function () {
        var name = $('#name').val();
        $('#listTable').datagrid('load',{
            name: name
        });
    })
</script>
</html>
