<%--
  Created by IntelliJ IDEA.
  User: LiuSuFen
  Date: 2018/4/26 0026
  Time: 上午 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include.jsp" %>
<html>
<head>
    <title>权限列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body>
    <table id="rightTable"></table>

    <div id="tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a id="addRight" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a id="editRight" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a id="removeRight" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div>
            权限名称: <input id="rightName" class="easyui-textbox" style="width:160px">
            <a id="searchRight" href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
        </div>
    </div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/common-childtab.js"></script>
<script type="text/javascript">
    $(function () {
        showRight();
    })

    function showRight() {
        $('#rightTable').treegrid({
            toolbar: '#tb',
            url:'${ctx}/right/getRightList',
            rownumbers:true,
            striped:true,
            singleSelect:true,
            fitColumns: true,
            idField:'trId',
            treeField:'rightName',
            columns:[[
                {field:'trId',title:'主键',hidden:true},
                {field:'rightName',title:'权限名',width:100},
                {field:'url',title:'URL',width:150},
                {field:'showOrder',title:'排序',width:50},
                {field:'genTime',title:'创建时间',width:100,formatter:formatDatebox},
                {field:'description',title:'备注',width:100}
            ]]
        })
    }
    
    $('#addRight').click(function () {
        var url = '${ctx}/right/toAddRight';
        tabsAdd("添加权限",url);
    })
    
    $('#editRight').click(function () {
        var record = $('#rightTable').datagrid('getSelected');
        if(record==null){
            alert("请选择需要修改的数据！");
            return;
        }
        var url = '${ctx}/right/toEditRight?trId='+record.trId;
        tabsAdd("修改权限",url);
    })
    
    $('#removeRight').click(function () {
        var record = $('#rightTable').datagrid('getSelected');
        if(record==null){
            alert("请选择需要修改的数据！");
            return;
        }
        $.messager.confirm('确认', '确认删除吗?', function(r){
            if (r){
                $.ajax({
                    url: '${ctx}/right/removeRight',
                    method: 'post',
                    data:{trId:record.trId},
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

    $('#searchRight').click(function () {
        var rightName = $('#rightName').val();
        $('#rightTable').treegrid('load',{
            rightName: rightName
        });
    })
</script>
</html>
