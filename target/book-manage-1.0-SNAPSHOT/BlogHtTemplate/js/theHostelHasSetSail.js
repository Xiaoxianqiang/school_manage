/*

@Name：不落阁后台模板源码
@Author：Absolutely
@Site：http://www.lyblogs.cn

*/

layui.define(['laypage', 'layer', 'form', 'pagesize','common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form(),
        laypage = layui.laypage;
    var laypageId = 'pageNav';
    var common = layui.common;//自己封装的ajax

    //提交数据
    form.on("submit(tureRegistered)",function (data) {



        if(data.field.title2==1||data.field.title6==0){
            layer.msg("请填写说明具体原因", { icon: 5 })
        }else {
            //console.log(common.getData())
            //ajax 提交数据
            //  common.ajax(common.onlineIp+'/questionnaire/list', 'post', 'json', {
            //      'startTime':common.getData(),
            //      'endTime':common.getData(),
            //  },function (res) {
            //      console.log(JSON.stringify(res));
            //  })
            common.ajax(common.onlineIp+'questionnaire/add', 'post', 'json', {
                'userId':common.user.id,
                'title1': data.field.title1,
                'title2': data.field.title2,
                'title3': data.field.title3,
                'title4': data.field.title4,
                'title5': data.field.title5,
                'title6': data.field.title6,
                'title7': data.field.title7,
            }, function (res) {
                console.log(JSON.stringify(res));
                layer.msg("提交成功", { icon: 6 , time: 2000},function () {
                    //关闭当前页面
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭

                });
                //form.render();//重载页面
            });
        }
       // console.log(data)
        //title2  1
        // title6  1
        return false;
    })


    exports('theHostelHasSetSail', {});
});