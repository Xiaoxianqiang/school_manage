/*

@Name：不落阁后台模板源码 
@Author：Absolutely 
@Site：http://www.lyblogs.cn

*/

layui.define(['element', 'layer', 'form','common'], function (exports) {
    var form = layui.form();
    var $ = layui.jquery;
    //自定义验证
    form.verify({
        passWord: [/^[\S]{6,12}$/, '密码必须6到12位'],
        account: function (value) {
            if (value.length <= 0 || value.length > 30) {
                return "账号"
            }
            var reg = /^[a-zA-Z0-9]*$/;
            if (!reg.test(value)) {
                return "账号只能为英文或数字";
            }
        },
        result_response: function (value) {
            if (value.length < 1) {
                return '请点击人机识别验证';
            }
        },
    });

    var common = layui.common;


    //监听登陆
    form.on('submit(login)', function (data) {
        var index = layer.load(1);//等待的样式123
        setTimeout(function () {
            layer.close(index);
            //模拟登陆
            common.ajax(common.onlineIp+'/user/login', 'post', 'json', {
                     'userNo': data.field.userNo,
                     'password': data.field.password,
                      'code':data.field.code
                 }, function (res) {
                     console.log(JSON.stringify(res));
                     if(res.code==200){
                         //存入数据
                         layui.data('data', {
                             key: 'user'
                             ,value: res.data
                         });
                         layer.msg('登陆成功，正在跳转......', { icon: 6 });
                         layer.closeAll('page');
                         setTimeout(function () {
                             //进入管理系统 判断身份
                            // if(res.roleId==10000){//管理员
                                 location.href = "/BlogHtTemplate/html/main.html";
                             //}
                         }, 1000);
                     }else {
                         layer.msg(res.msg, { icon: 5 });

                     }
                 });

        }, 400);
        return false;
    });
    //监听注册切换按钮 registered
    form.on('submit(registered)', function (data) {
        //弹开新的注册页面
        layer.closeAll('page');
        registered();
        return false;
    })

    //检测键盘按下
    $('body').keydown(function (e) {
        if (e.keyCode == 13) {  //Enter键
            if ($('#layer-login').length <= 0) {
                login();
            } else {
                $('button[lay-filter=login]').click();
            }
        }
    });

    $('.enter').on('click', login);
    //注册页面生成
    function registered(){
        var url="/BlogHtTemplate/html/registered.html" //注册页面路径
        layer.open({
            id: 'registered',
            type: 1,
            title: false,
            shade: 0.4,
            shadeClose: true,
            area: ['480px', '500px'],
            closeBtn: 0,
            anim: 1,
            skin: 'pm-layer-login',
            content: '\n' +
                '    <form class="layui-form" action="">\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">姓名</label>\n' +
                '            <div class="layui-input-inline pm-login-input">\n' +
                '                <input type="text" name="name" lay-verify="required" placeholder="请输入姓名" value="" autocomplete="off"\n' +
                '                       class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">性别</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="radio" name="gender" value="0" title="女">\n' +
                '                <input type="radio" name="gender" value="1" title="男" checked>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">班级</label>\n' +
                '            <div class="layui-input-inline pm-login-input">\n' +
                '                <input type="text" name="classGrade" lay-verify="required" placeholder="请输入班级" value="" autocomplete="off"\n' +
                '                       class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">账号</label>\n' +
                '            <div class="layui-input-inline pm-login-input">\n' +
                '                <input type="text" name="userNo" lay-verify="account" placeholder="请输入账号" value="" autocomplete="off"\n' +
                '                    class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">密码</label>\n' +
                '            <div class="layui-input-inline pm-login-input">\n' +
                '                <input type="password" name="password" lay-verify="passWord" placeholder="请输入密码" value=""\n' +
                '                    autocomplete="off" class="layui-input">\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">身份</label>\n' +
                '            <div class="layui-input-block">\n' +
                '                <input type="radio" name="roleId" value="10001" title="辅导员">\n' +
                '                <input type="radio" name="roleId" value="10002" title="学生" checked>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item">\n' +
                '            <label class="layui-form-label">验证码</label>\n' +
                '            <div class="layui-input-inline pm-login-input">\n' +
                '                <input class="input-val " type="password" name="code"  lay-verify="required" placeholder="请输入验证码" value=""\n' +
                '                    autocomplete="off" class="layui-input" style="width: 55%;" >\n' +
                '                    <img src="/user/auth/code" id="canvas" width="100" height="43" title="点击更换验证码" onclick="this.src=\'/user/auth/code\'"></img>\n' +
                '\n' +
                '            </div>\n' +
                '        </div>\n' +
                '        <div class="layui-form-item" style="margin-top:25px;margin-bottom:0;">\n' +
                '            <div class="layui-input-block">\n' +
                '                <button class="layui-btn" style="width:230px;" lay-submit="" lay-filter="tureRegistered">注册</button>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </form>'
        });
        layui.form().render();;
    }
    //注册提交
    form.on('submit(tureRegistered)', function (data) {
        var index = layer.load(1);//等待的样式123
        setTimeout(function () {
            layer.close(index);
            //模拟登陆
            common.ajax(common.onlineIp+'/user/add', 'post', 'json', {
                'name':data.field.name,
                'userNo': data.field.userNo,
                'password': data.field.password,
                'roleId': data.field.roleId,
                'code':data.field.code,
                'gender':data.field.gender,
                'classGrade':data.field.classGrade,
            }, function (res) {
                console.log(JSON.stringify(res));
                if(res.code==200){
                    //存入数据
                    layui.data('data', {
                        key: 'user'
                        ,value:  {
                            'name':data.field.name,
                            'userNo': data.field.userNo,
                            'password': data.field.password,
                            'roleId': data.field.roleId,
                            'code':data.field.code,
                            'gender':data.field.gender,
                            'classGrade':data.field.classGrade,
                        }
                    });
                    layer.msg('注册成功，正在跳转......', { icon: 6 });
                    layer.closeAll('page');
                    setTimeout(function () {
                        //进入管理系统
                        location.href = "/BlogHtTemplate/html/main.html";
                    }, 1000);
                }else {
                    layer.msg(res.msg, { icon: 5 });

                }
            });

        }, 400);
        return false;
    })


    function login() {
        var loginHtml = ''; //静态页面只能拼接，这里可以用iFrame或者Ajax请求分部视图。html文件夹下有login.html

        loginHtml += '<form class="layui-form" action="">';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">账号</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input type="text" name="userNo" lay-verify="registered" placeholder="请输入账号" value="afc2a25870ab4818a010d00fff3789b5" autocomplete="off" class="layui-input">';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">密码</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input type="password" name="password" lay-verify="passWord" placeholder="请输入密码" value="453543" autocomplete="off" class="layui-input">';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">验证码</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input class="input-val "  style="width: 55%;" type="text" name="code"   placeholder="请输入验证码" value="" autocomplete="off" class="layui-input" >';
        loginHtml += '<img src="/user/auth/code" id="canvas" width="100" height="43" title="点击更换验证码" onclick="this.src=\'/user/auth/code\'"></img>';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item" style="margin-top:25px;margin-bottom:0;display: flex;justify-content: space-between;">';
        loginHtml += '<div class="layui-input-inline">';
        loginHtml += ' <button class="layui-btn" style="width:210px;" lay-submit="" lay-filter="login">登录</button>';
        loginHtml += ' </div>';
        loginHtml += '<div class="layui-input-inline">';
        loginHtml += ' <button class="layui-btn layui-btn-primary" style="width:210px;" lay-submit="" lay-filter="registered">注册</button>';
        loginHtml += ' </div>';
        loginHtml += ' </div>';
        loginHtml += '</form>';

        layer.open({
            id: 'layer-login',
            type: 1,
            title: false,
            shade: 0.4,
            shadeClose: true,
            area: ['480px', '270px'],
            closeBtn: 0,
            anim: 1,
            skin: 'pm-layer-login',
            content: loginHtml
        });
        layui.form().render('checkbox');
    }

    exports('index', {});
});

