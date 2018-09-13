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
    <title>时间轴列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body>
<table id="timeLineTable"></table>
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a id="remove" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
    <div>
        名称: <input class="easyui-textbox" style="width:160px">
        开始时间: <input class="easyui-datebox" style="width:120px">
        结束时间: <input class="easyui-datebox" style="width:120px">
        <a id="search" href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/common-childtab.js"></script>
<script type="text/javascript">
    $(function () {
        $('#timeLineTable').datagrid({
            toolbar: '#tb',
            url:'${ctx}/timeline/getList',
            striped:true,
            singleSelect:true,
            fitColumns: true,
            columns:[[
                {field:'id',title:'主键',width:100},
                {field:'userName',title:'用户名',width:100},
                {field:'content',title:'内容',width:100},
                {field:'genTime',title:'创建时间',width:120,formatter:formatDatebox,align:'right'}
            ]]
        })
    })

    $('#add').click(function () {
        var url = '${ctx}/timeline/toSave';
        tabsAdd("添加时间轴",url);
    })

    $('#edit').click(function () {
        var record = $('#timeLineTable').datagrid('getSelected');
        if(record==null){
            alert("请选择需要修改的数据！");
            return;
        }
        var url = '${ctx}/timeline/toEdit?id='+record.id;
        tabsAdd("修改时间轴",url);
    })

    $('#remove').click(function () {
        var record = $('#timeLineTable').datagrid('getSelected');
        if(record==null){
            alert("请选择需要删除的数据！");
            return;
        }
        $.messager.confirm('确认', '确认删除吗?', function(r){
            if (r){
                $.ajax({
                    url: '${ctx}/timeline/remove',
                    method: 'post',
                    data:{id:record.Id},
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
        var rightName = $('#rightName').val();
        $('#rightTable').treegrid('load',{
            rightName: rightName
        });
    })
</script>
</html>
