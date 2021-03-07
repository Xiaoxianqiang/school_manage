/*

@Name：不落阁后台模板源码
@Author：Absolutely
@Site：http://www.lyblogs.cn

*/

layui.define(['laypage', 'layer', 'form', 'pagesize', 'common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form(),
        laydate = layui.laydate;
    var common = layui.common;//自己封装的ajax

    //日期
    // laydate.render({
    //     elem: '#date'
    // });
    // elem: '#id', //需显示日期的元素选择器
    //     event: 'click', //触发事件
    //     format: 'YYYY-MM-DD hh:mm:ss', //日期格式

    //获取学生id
    var user=layui.data('data').user;

    //提交信息
    form.on("submit(tureRegistered)",function (data) {
        console.log(data.field)
        common.ajax(common.onlineIp+'/arrangements/add', 'post', 'json', {
            'userId': user.id,//学生id
            'plan':data.field.plan,//计划
           // 'createTime':data.field.createTime,
        },function (res) {
            layer.msg("提交成功",{icon:6,time:2000},function () {
                //关闭当前页面
                var index=parent.layer.getFrameIndex(window.name); //获取当前窗口的name
                parent.layer.close(index);
            })


        });
        return false;
    })


    exports('dailyPlan', {});
});