<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/view/common/tag.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>书籍列表</title>

    <link rel="stylesheet" href="${baseurl}/lib/layui/css/layui.css" media="all">
</head>
<body class="layui-body-custom layui-layout-body ">
<div class="layui-layout layui-layout-admin">

    <div class="layui-card" style="padding: 10px">
        <div>
            <form class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-form-item layui-inline">
                        <label class="layui-form-label">书籍名称</label>
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
        <c:if test="${loginUser.roleId == 1}">
            <div class="layui-btn-group operateTable" style="margin: 5px">
                <button class="layui-btn" data-type="bookAdd">新增</button>
            </div>
        </c:if>

        <table class="layui-hide" id="tableId" lay-filter="tableFilter"></table>
    </div>

</div>
</div>

<!--操作-->
<script type="text/html" id="tableTool">
    <c:if test="${loginUser.roleId != 1}">
        <a class="layui-btn layui-btn-xs" id="buyBook" lay-event="buyBook">购买</a>
    </c:if>
    <c:if test="${loginUser.roleId == 1}">
    <a class="layui-btn layui-btn-xs" id="bookEdit" lay-event="bookEdit">修改</a>
    </c:if>
</script>

<script src="${baseurl}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${baseurl}/lib/layui_custom/Hlayui.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'table', 'form', 'jquery', 'layer','layerCustom'], function () {
        var element = layui.element;
        table = layui.table,
            $ = layui.jquery,
            layerCustom = layui.layerCustom,
            layer = layui.layer,
            form = layui.form;

        var myTalbe = table.render({
            elem: '#tableId'
            , url: BaseUrl+'book/list'
            , cols: [[
                {type:'checkbox', fixed: 'left'}
                ,  {field: 'bookName', title: '书籍名称', sort: true}
                , {field: 'bookPrice', title: '书籍价格', sort: true}
                , {field: 'bookSummary', title: '书籍简介'}
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
                case "bookEdit":
                    bookEdit(data);
                    break;
                case "buyBook":
                    buyBook(data);
                    break;
            }
        });

        $('.operateTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            switch (type) {
                case "bookAdd":
                    bookAdd();
                    break;
            }
        });


        function bookAdd() {
            layerCustom.open("添加书籍", BaseUrl+'book/add', "700px", "450px", function (layero,index) {
                //var body = layui.layer.getChildFrame('body', index);
                // let iframeWin = window[layero.find("iframe")[0]["name"]];
                // //iframeWin.initForm(data);
                // var name = iframeWin.document.getElementById("name");
                // name.value = "这真的是一个好的消息";
                // var body = layer.getChildFrame('body');
                // body.find("#name").val("这真的是一个好的消息");
            }, function () {
                myTalbe.reload();
            })
        }

        function bookEdit(data) {
            layerCustom.open("修改书籍", BaseUrl+'/book/edit', "700px", "450px", function (layero,index) {
                var iframeWin = window[layero.find("iframe")[0]["name"]];
                iframeWin.initForm(data);
            }, function () {
                myTalbe.reload();
            })
        }

        // function buyBook() {
        //     var checkStatus = table.checkStatus('tableId')
        //         ,data = checkStatus.data;
        //
        //     if (data.length === 0) {
        //         layerCustom.yellowQuestionMsg("请选择一条数据")
        //         return;
        //     }
        //     var url = BaseUrl+"buyBook/insert";
        //     var param ={
        //         buyBookVos:JSON.stringify(data)
        //     }
        //     $.post(url,param,function (result) {
        //         if (result.success) {
        //             layerCustom.tableSuccessMsg(result.msg)
        //         }else {
        //
        //         }
        //     },"json");
        // }

        function buyBook(data) {
            if (data.length === 0) {
                layerCustom.yellowQuestionMsg("请选择一条数据")
                return;
            }
            var url = BaseUrl+"buybook/insert";
            var param ={
                bookId:data.id,
                bookName:data.bookName
            };
            // alert(JSON.stringify(param))
            $.post(url,param,function (result) {
                if (result.success) {
                    layerCustom.tableSuccessMsg(result.msg);
                }else {
                    layerCustom.redCryMsg(result.msg);
                }
            },"json");
        }

    });
</script>
</body>
</html>
