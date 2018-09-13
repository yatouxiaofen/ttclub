<%--
  Created by IntelliJ IDEA.
  User: LiuSuFen
  Date: 2018/4/26 0026
  Time: 下午 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../include.jsp" %>
<html>
<head>
    <title>添加权限</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/common-childtab.js"></script>
</head>
<body>
<div style="width: 100%;margin-top: 20px;">
    <div style="width:500px;margin:0 auto;">
        <div class="easyui-panel" title="修改时间轴" style="padding:10px;">
            <form id="editForm" method="post">
                <input name="id" value="${timeline.id}">
                <div style="margin-bottom:20px">
                    <div>内容:</div>
                    <input name="content" value="${timeline.content}" class="easyui-textbox" style="width:100%;height:32px">
                </div>
                <div style="margin-bottom:20px">
                    <div>创建时间:</div>
                    <input id="genTime" name="genTime" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser"
                           value="${timeline.genTime}"
                           style="width:100%;height:32px">
                </div>
                <div style="margin-bottom:20px;text-align: right;">
                    <a id="edit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $('#edit').click(function () {
        edit();
    })
    function edit() {
        $.messager.progress();	// display the progress bar
        $('#rightForm').form('submit', {
            url: '${ctx}/timeline/edit',
            onSubmit: function () {
                var isValid = $(this).form('validate');
                if (!isValid) {
                    $.messager.progress('close');	// hide progress bar while the form is invalid
                }
                return isValid;	// return false will stop the form submission
            },
            success: function (data) {
                $.messager.progress('close');	// hide progress bar while submit successfully
                var data = eval('(' + data + ')'); // change the JSON string to javascript object
                alert(data.message)
                if(data.code=='0000') {
                    tabsClose();
                }
            }
        });
    }
</script>
</html>
