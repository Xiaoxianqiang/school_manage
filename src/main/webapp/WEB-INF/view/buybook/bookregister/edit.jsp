<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/view/common/tag.jsp" %>
<html>
<head>
    <title>库存修改</title>
    <link rel="stylesheet" href="${baseurl}/lib/layui/css/layui.css" media="all">
</head>
<body>
<form class="layui-form" action="" lay-filter="editForm" style="margin-top: 30px">
    <div class="layui-form-item">
        <input type="hidden" name="id">
            <label class="layui-form-label">回复</label>
            <div class="layui-input-block">
                <input type="text" name="comment" required lay-verify="required" autocomplete="off"
                       placeholder="请输入回复信息"
                       class="layui-input" style="width: 70%">
            </div>
    </div>
    <div class="layui-form-item" style="margin-left: 110px">
        <div class="layui-input-block">
            <butaton class="layui-btn" lay-submit lay-filter="add">立即提交</butaton>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="${baseurl}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${baseurl}/lib/layui_custom/Hlayui.js" charset="utf-8"></script>
<script>
    var initData;

    function initForm(data) {
        var jsonString = JSON.stringify(data);
        initData = JSON.parse(jsonString);
    }

    layui.use(['form', 'jquery', 'element', 'layer', 'laydate','layerCustom'], function () {
        var element = layui.element;
        $ = layui.jquery,
            layer = layui.layer,
            layerCustom = layui.layerCustom,
            laydate = layui.laydate,
            form = layui.form;

        form.val("editForm", initData);

        form.on('submit(add)', function (data) {
            var url = BaseUrl + "bookRegister/updateIgnoreNull";
            //
            $.post(url, data.field, function (result) {
                if (result.success) {
                    layer.msg(result.msg, function () {
                        parent.layer.close(parent.layer.getFrameIndex(window.name));
                    })
                } else {
                    layer.msg(result.msg)
                    return;
                }
            }, 'json');

            return false;
        });
    });
</script>
</body>
</html>