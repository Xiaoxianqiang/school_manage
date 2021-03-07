/*

@Name：不落阁后台模板源码
@Author：Absolutely
@Site：http://www.lyblogs.cn

*/

layui.define(['laypage', 'layer', 'form', 'pagesize', 'common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form(),
        laypage = layui.laypage;
    var laypageId = 'pageNav';
    var common = layui.common;//自己封装的ajax
    var current=1, Size=8;//翻页数据
    var name;//查询关键字
    var pages;//翻页的数量


    //页数据初始化
    initilData(current, Size);


    //currentIndex：当前也下标
    //pageSize：页容量（每页显示的条数）
    function initilData(currentIndex, pageSize, name) {
        var index = layer.load(1);
        var data;
        current = currentIndex;
        Size = pageSize;
        //第一次加载自己的数据
        common.ajax(common.onlineIp+'/user/list', 'post', 'json', {
            'roleId': 10002,//学生
            'name': name,
            'pageNum': currentIndex,
            'pageSize': pageSize,
        }, function (res) {
              console.log(JSON.stringify(res));
            if (res.code == 200) {
                data = res.data.list;//赋值数据
                pages= Math.ceil(res.data.length / Size);

                for (var i = 0; i < res.data.length; i++) {
                    data.push({
                        id: data[i].id,
                        name: data[i].name,
                        userNo: data[i].userNo,
                        gender: data[i].gender,
                        roleId: data[i].roleId,
                        classGrade: data[i].classGrade,
                        createTime: data[i].createTime,
                        updateTime: data[i].updateTime
                    });
                }
            } else {
                layer.msg(res.msg, {icon: 5});
            }

        });
        //模拟数据加载
        setTimeout(function () {
            layer.close(index);
            //计算总页数（一般由后台返回）
            pages = Math.ceil(data.length / pageSize);
            var html = '';  //由于静态页面，所以只能作字符串拼接，实际使用一般是ajax请求服务器数据
            html += '<table style="" class="layui-table" lay-even>';
            html += '<colgroup><col width="150"><col width="100"><col><col width="150"><col width="90"><col width="90"><col width="90"><col width="50"><col width="50"></colgroup>';
            html += '<thead><tr><th>用户id</th><th>姓名</th><th>账户</th><th >性别</th><th >班级</th><th >创建时间</th><th >修改时间</th><th colspan="2">操作</th></tr></thead>';
            html += '<tbody>';
            //遍历文章集合
            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                var gender = item.gender == 0 ? '女' : '男';
                console.log()

                html += "<tr>";
                html += "<td>" + item.id + "</td>";
                html += "<td>" + item.name + "</td>";
                html += "<td>" + item.userNo + "</td>";
                html += "<td>" + gender + "</td>";//0 女
                html += "<td>" + item.classGrade + "</td>";
                html += "<td>" + getLocalTime(item.createTime) + "</td>";
                html += "<td>" + getLocalTime(item.updateTime) + "</td>";
                html += '<td><button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.studentUsers.editData(\'' + item.id + '\')"><i class="layui-icon">&#xe642;</i></button></td>';
                html += '<td><button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.studentUsers.deleteData(\'' + item.id + '\')"><i class="layui-icon">&#xe640;</i></button></td>';
                html += "</tr>";
            }
            html += '</tbody>';
            html += '</table>';
            html += '<div id="' + laypageId + '"></div>';

            $('#dataContent').html(html);

            form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
            $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox
            //翻页器
            laypage({
                cont: laypageId,
                pages: pages,
                groups: 8,
                skip: true,
                curr: currentIndex,
                jump: function (obj, first) {
                    current = obj.curr;
                    if (!first) {
                        //重新调用方法
                        initilData(current, Size);
                    }
                }
            });
            //该模块是我定义的拓展laypage，增加设置页容量功能
            //laypageId:laypage对象的id同laypage({})里面的cont属性
            //pagesize当前页容量，用于显示当前页容量
            //callback用于设置pagesize确定按钮点击时的回掉函数，返回新的页容量
            layui.pagesize(laypageId, pageSize).callback(function (newPageSize) {
                //这里不能传当前页，因为改变页容量后，当前页很可能没有数据
                Size = newPageSize
                initilData(1, Size,name);
            });
        }, 500);


    }

    function getLocalTime(nS) {
        return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/, ' ');
    }

    //监听置顶CheckBox
    form.on('checkbox(top)', function (data) {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            if (data.elem.checked) {
                data.elem.checked = false;
            } else {
                data.elem.checked = true;
            }
            layer.msg('操作失败，返回原来状态');
            form.render();  //重新渲染
        }, 300);
    });

    //监听推荐CheckBox
    form.on('checkbox(recommend)', function (data) {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            layer.msg('操作成功');
        }, 300);
    });
    //添加数据
    $('#addArticle').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            layer.msg('打开添加窗口');
        }, 500);
    });

    //formSearch
    form.on('submit(formSearch)', function (data) {
        console.log(data.field.keywords)
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            layer.msg('操作成功');
            initilData(1, 8, data.field.keywords);
        }, 300);
        return false;
    });

    //输出接口，主要是两个函数，一个删除一个编辑
    var studentUsers = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                common.ajax(common.onlineIp+'/user/delete', 'post', 'json', {
                    'id': id,//学生
                }, function (res) {
                    initilData(1, Size);
                    //执行重载
                });
            }, function () {

            });
        },
        editData: function (id) {
            //layer.msg('编辑Id为【' + id + '】的数据');
            //编辑数据
            //打开一个修改页面
            var index = layer.open({
                title: "编辑",
                type: 2,
                skin: 'layui-layer-rim', //加上边框
                area: ['auto'], //宽高
                maxmin: true, //开启最大化最小化按钮
                shadeClose: true,
                content: "/BlogHtTemplate/html/user/userUpdata.html",
                success: function (layero, index) {
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // 向子页面的全局函数child传参
                    iframe.child(id);
                },
                end: function () {
                    //执行重载
                    initilData(1, Size);                }
            })
            layer.full(index);

        }
    };


    exports('studentUsers', studentUsers);
});