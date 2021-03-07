/**
 * 公用方法
 */
layui.define([ 'jquery' ],  function (exports){ 
    var  $ = layui.jquery;
    var  obj = {
        //封装ajax
        ajax:  function  (url, type, dataType, data, callback) {
            $.ajax({
                url: url,
                type: type,
                contentType: "application/json;charset=UTF-8",
                dataType: dataType,
                data:JSON.stringify(data),
                success: callback
            });
        },
        //系统地址
        onlineIp:"http://localhost:8082",
        //自己缓存的用户
        user:layui.data('data').user,
        //获取时间
        getData:function () {
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() + 1; //获取当前月
            var date = myDate.getDate(); //获取当前日
            return year+"-"+(mon<10?"0"+mon:mon)+"-"+(date<10?"0"+date:date)
        }
    };
    //输出接口
    exports( 'common' , obj);
});

//获取所有的每日规划  成功  翻页
//获取自己的每日规划
// 增  完成
// 修改  修改要修改全部数据
// 删除 完成

//
//审核
//建议
//筛选

//管理员
//完成


