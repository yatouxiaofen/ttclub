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
    <title>角色权限列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.5.4.5/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
</head>
<body>
    <ul id="rightTree" class="easyui-tree"
        data-options="url:'${ctx}/role/roleRightList?roleId=${roleId}',checkbox:true"></ul>
    <div>
        <a id="putRightBtn" class="" href="javascript:void(0)">保存</a>
    </div>
    <script type="text/javascript">
        $('#putRightBtn').click(function () {
            /**
             * 获取权限树所有选中状态和圆心状态数据
             * @type {*|jQuery}
             */
            var roleRights = $('#rightTree').tree('getChecked',['checked','indeterminate']);
                //$('#rightTree').tree('getChecked');
            var rightIds = '';
            $.each(roleRights,function (i,c) {
                rightIds += c.id+",";
            })
            var roleId = ${roleId};
            rightIds = rightIds.substring(0, rightIds.length-1);
            $.ajax({
                url: '${ctx}/role/putRoleRights',
                method: 'post',
                data:{roleId:roleId,rightIds:rightIds},
                dataType:'json',
                success:function (data) {
                    if(data.code=='0000'){
                        alert('操作成功！');
                        $("#putRightDlg").dialog("close");
                    }else {
                        alert(data.message);
                    }
                }
            })
        });
    </script>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
</html>
