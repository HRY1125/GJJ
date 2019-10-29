window.onload=function () {

    layui.use(['table','layer'],function () {
        var table = layui.table;
        var layer = layui.layer;

        var unitId = $("#unitId").val();
        table.render({
            elem: '#employ'
            ,height: 500
            ,url: '/SecondAssist/selectSecondAssistByUnitId'
            ,page: true
            ,toolbar: '#toolbar'
            ,cols: [[ //表头
                {field: 'NO.', title: '序号', width:80, hide:true}
                ,{field: 'departmentId', title: '部门编号', width:285, edit:'text'}
                ,{field: 'departmentName', title: '部门名称', width:285, edit:'text'}
                ,{field: 'departmentCode', title: '部门代码', width:285, edit:'text'}
                ,{field: '', title: '保存/删除', width: 183, fixed: 'right'
                    , toolbar:'<div><div class="layui-btn-group">\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="save">\n' +
                        '    <i class="layui-icon">&#xe61f;</i>\n' +
                        '  </button>\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="delete">\n' +
                        '    <i class="layui-icon">&#xe640;</i>\n' +
                        '  </button>\n' + '</div>' +
                        '</div>'}
            ]]
        });

        //头工具栏监听
        table.on('toolbar(edit)', function(obj){
            var event = obj.event;
            var flag = true;

            if(flag){
                $.ajax({
                    type : "POST",
                    contentType: "application/json;charset=UTF-8",
                    url : "/SecondAssist/add",
                    data : "",
                    dataType : "json",
                    success : function(result) {
                        layer.msg(result.retmsg);
                        table.reload('employ',{
                            height: 500
                            ,url: '/SecondAssist/selectSecondAssistByUnitId'
                            ,toolbar: '#toolbar'
                            ,page:{
                                curr:1
                            }
                        });
                    }
                });
            }
        });

        //行工具栏监听
        table.on('tool(edit)',function (obj) {
            var unitRegistId = $("#ipt_urId").val();
            obj.data.unitRegisterId = unitRegistId;
            var data = obj.data;
            console.log(data);
            var event = obj.event;
            var flag = true;
            if(event=='save'){
                layer.open({
                    content:'是否保存？'
                    ,btn:['是','否']
                    ,yes:function () {
                        $.ajax({
                            type: "POST",
                            contentType: "application/json;charset=UTF-8",
                            url: "/SecondAssist/save",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (result) {
                                layer.msg(result.retmsg);
                                table.reload('employ', {
                                    height: 500
                                    , url: '/SecondAssist/selectSecondAssistByUnitId'
                                    , page:{
                                        curr:1
                                    }
                                    , toolbar: '#toolbar'
                                });
                            },
                        });
                    }
                    ,btn2:function () {
                        flag = false;
                    }
                });

            }else if(event=='delete'){
                layer.open({
                    content:'是否删除？'
                    ,btn:['是','否']
                    ,yes:function () {
                        $.ajax({
                            type: "POST",
                            contentType: "application/json;charset=UTF-8",
                            url: "/SecondAssist/delete",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (result) {
                                layer.msg(result.retmsg);
                                table.reload('employ', {
                                    height: 500
                                    , url: '/SecondAssist/selectSecondAssistByUnitId'
                                    , page: {
                                        curr:1
                                    }
                                    , toolbar: '#toolbar'
                                });
                            },
                        });
                    }
                    ,btn2:function () {
                        flag = false;
                    }
                });

            }
        })

    });

}