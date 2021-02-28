<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/view/common/tag.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>购书申请</title>

    <link rel="stylesheet" href="${baseurl}/lib/layui/css/layui.css" media="all">
</head>
<body class="layui-body-custom layui-layout-body ">
<div class="layui-layout layui-layout-admin">

    <div class="layui-card" style="padding: 10px">
        <div>
            <form class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">书名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="bookName" placeholder="" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">申请人</label>
                        <div class="layui-input-inline">
                            <input type="text" name="registerUserName" placeholder="" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">申请人角色</label>
                        <div class="layui-input-inline">
                            <input type="text" name="roomSpace" placeholder="" class="layui-input">
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
            <button class="layui-btn" data-type="bookApply">登记书籍</button>
        </div>
        <table class="layui-hide" id="tableId" lay-filter="tableFilter"></table>
    </div>

</div>
</div>

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
            , url: BaseUrl+'bookRegister/list'
            , cols: [[
                {field: 'bookName', title: '书籍名称', sort: true}
                , {field: 'registerUserName', title: '申请人'}
                , {field: 'registerRoleName', title: '申请人角色', sort: true,}
                , {field: 'registerTime', title: '登记时间'}
                , {field: 'comment', title: '购书信息'}
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


        $('.operateTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            switch (type) {
                case "bookApply":
                    bookApply();
                    break;
            }
        });

        function bookApply() {
            layerCustom.open("登记书籍", BaseUrl+'bookRegister/add', "700px", "350px", function (layero,index) {
                //
            }, function () {
                myTalbe.reload();
            })
        }
    });
</script>
</body>
</html>
