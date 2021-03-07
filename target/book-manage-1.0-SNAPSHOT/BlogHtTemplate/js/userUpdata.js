function child(id) {
    layui.define([ 'layer', 'form','common','jquery'],function (exports) {
        var $ = layui.jquery,
            layer = layui.layer,
            form = layui.form();
        //填补数据
         console.log(id);
        var common=layui.common;

        // $("#name").val(item.name)//name
        // $("#userNo").val(item.userNo)//userNo
        // $("#password").val(item.password)//password
        // $("#classGrade").val(item.classGrade)//password
        // $("input[name=gender][value="+item.gender+"]").prop('checked', true);
        // $("input[name=roleId][value="+item.roleId+"]").prop('checked', true);

        //roleId
        //gender




        // //获取数据
        common.ajax(common.onlineIp+'/user/query', 'post', 'json', {
            'id': id,//学生
        },function (res) {
            console.log(JSON.stringify(res.data));
            var item=res.data;
            $("#name").val(item.name)//name
            $("#userNo").val(item.userNo)//userNo
            $("#password").val(item.password)//password
            $("#classGrade").val(item.classGrade)//password
            $("input[name=gender][value="+item.gender+"]").prop('checked', true);
            $("input[name=roleId][value="+item.roleId+"]").prop('checked', true);
            form.render(); //
        });
        //用户提交修改
        form.on('submit(userUpdata)', function (data) {
            console.log(data.field)
            layer.confirm('确定修改？', {
                btn: ['确定', '取消'] //按钮
            }, function () {//成功
                common.ajax(common.onlineIp+'/user/update', 'post', 'json', {
                    'id':id,//学生
                    'name': data.field.name,
                    'password':  data.field.password,
                    'gender':  data.field.gender,
                    'classGrade':  data.field.classGrade,
                },function (res) {
                    layer.msg("修改成功");
                    form.render(); //
                });
            }, function () {//失败

            });
            return false;
        })
        exports('userUpdata', {});

    })

}
