window.onload=function(){

    layui.use(['table','form','layer'], function(){
        var table = layui.table;
        var form = layui.form;
        var layer = layui.layer;
        var unitRegistId1000 = $("#ipt_urId").val();
        table.render({

            elem: '#employ'
            ,height: 500
            ,url: '/remittance/select?UnitRegisterId='+unitRegistId1000
            ,page: true
            ,toolbar: '#toolbar'
            ,cols: [[ //表头
                /*{field: 'NO.', title: '序号', width:80}
                ,*/{field: 'employeeId', title: '职工编号', width:135}
                ,{field: 'employeeName', title: '姓名', width:135, edit:'text'}
                ,{field: 'employeePapersName', title: '证件名称', width:135, edit:'text'}
                ,{field: 'employeeNationnality', title: '国别', width: 135, edit:'text'}
                ,{field: 'employeePapersNum', title: '证件号码', width: 180, edit:'text'}
                ,{field: 'depositBase', title: '缴存基数', width: 135, edit:'text'}
                ,{field: 'unitDeposite', title: '单位月缴存额', width: 135, edit:'text'}
                ,{field: 'employeeDeposite', title: '个人月缴存额', width: 135, edit:'text'}
                ,{field: 'depositeTotal', title: '月缴存额合计', width: 135}
                /*,{field: 'wealth', title: '二级管理辅助信息', width: 150
                    , templet: '<div><input type="radio" name="second" value="开通" title="开通">' +
                        '<input type="radio" name="second" value="不开通" title="不开通"></div>'}*/

                ,{field: '', title: '保存/删除', width: 110, fixed: 'right'
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

        table.on('edit(edit)', function(obj){

            console.log(obj.value); //得到修改后的值
            console.log(obj.field); //当前编辑的字段名
            console.log(obj.data); //所在行的所有相关数据

        });

        //头工具栏监听
        table.on('toolbar(edit)', function(obj){
            var event = obj.event;
            var flag = true;
            /*if(event=='add'){
                console.log(form.val("unit"));
                var data = form.val("unit");
                if(data.unitRegisterId==null || data.unitRegisterId==''){
                    layer.msg("单位登记号不能为空");
                    flag = false;
                }else if(data.source==null || data.source==''){
                    layer.msg("资金来源不能为空");
                    flag = false;
                }else if(data.unitRatio==null || data.unitRatio==''){
                    layer.msg("单位比例不能为空");
                    flag = false;
                }else if(data.personRatio==null || data.personRatio==''){
                    layer.msg("个人比例不能为空");
                    flag = false;
                }
            }*/

            if(flag){
                $.ajax({
                    type : "POST",
                    contentType: "application/json;charset=UTF-8",
                    url : "/remittance/add?unitRegisterId="+$("#ipt_urId").val(),
                    data : "",
                    dataType : "json",
                    success : function(result) {
                        table.reload('employ',{
                            height: 500
                            ,url: '/remittance/select?UnitRegisterId='+$("#ipt_urId").val()
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
                            url: "/remittance/update",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (result) {
                                layer.msg("保存成功！");
                                table.reload('employ', {
                                    height: 500
                                    , url: '/remittance/select?UnitRegisterId='+unitRegistId
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
                            url: "/remittance/delete",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (result) {
                                layer.msg("删除成功！");
                                table.reload('employ', {
                                    height: 500
                                    , url: '/remittance/select?UnitRegisterId='+$("#ipt_urId").val()
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
};