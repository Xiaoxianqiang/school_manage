<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/view/common/tag.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户信息</title>

    <link rel="stylesheet" href="${baseurl}/lib/layui/css/layui.css" media="all">
</head>
<body class="layui-body-custom layui-layout-body ">
<div class="layui-layout layui-layout-admin">

    <div class="layui-card" style="padding: 10px">
        <div>
            <form class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">登录名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="bookName" placeholder="" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <a class="layui-btn" data-type="reload" lay-submit lay-filter="search">搜索</a>
                        <button type="reset" class="layui-btn layui-btn-primary">
                            重置
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-card">
        <div class="layui-btn-group operateTable" style="margin: 5px">
            <button class="layui-btn" data-type="userAdd">添加用户</button>
        </div>
        <table class="layui-hide" id="tableId" lay-filter="tableFilter"></table>
    </div>

</div>
</div>

<!--操作-->
<script type="text/html" id="tableTool">
    <a class="layui-btn layui-btn-xs" id="restPwd" lay-event="restPwd">重置密码</a>
</script>

<script src="${baseurl}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${baseurl}/lib/layui_custom/Hlayui.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'table', 'form', 'jquery', 'layer', 'laydate','layerCustom'], function () {
        var element = layui.element;
        table = layui.table,
            $ = layui.jquery,
            layerCustom = layui.layerCustom,
            layer = layui.layer,
            laydate = layui.laydate,
            form = layui.form;

        var myTalbe = table.render({
            elem: '#tableId'
            , url: BaseUrl+'sysuser/list'
            , cols: [[
                {field: 'userName', title: '用户名称', sort: true}
                , {field: 'roleName', title: '角色名称'}
                , {title: '操作', toolbar: '#tableTool', fixed: "right", align: "center"}
            ]]
            , page: true
        });

        form.on("submit(search)", function (data) {
            myTalbe.reload({
                where: data.field,
                page: {curr: 1}
            });
            return false;
        });

        table.on("tool(tableFilter)", function (obj) {
            var data = obj.data;
            switch (obj.event) {
                case "restPwd":
                    restPwd(data);
                    break;
            }
        });

        $('.operateTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            switch (type) {
                case "userAdd":
                    userAdd();
                    break;
            }
        });

        function userAdd() {
            layerCustom.open("添加用户", BaseUrl+'sysuser/add', "700px", "350px", function (layero,index) {
            }, function () {
                myTalbe.reload();
            })
        }

        function restPwd(data) {
            layer.prompt({title: '输入重置的密码，并确认', formType: 1}, function(pass, index){
                var url = BaseUrl + "sysuser/updateIgnoreNull";
                var params ={
                    id:data.id,
                    password:pass
                };
                $.post(url, params, function (result) {
                    if (result.success) {
                        layer.close(index);
                        layerCustom.tableSuccessMsg(result.msg);
                    } else {
                        layer.redCryMsg(result.msg)
                        return;
                    }
                }, 'json');
            });
        }
    });
</script>
</body>
</html>
