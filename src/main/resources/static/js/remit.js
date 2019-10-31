window.onload=function(){

    layui.use(['table','form','layer'], function(){
        var table = layui.table;
        var form = layui.form;
        var layer = layui.layer;
        var senfenboolean = true;
        var depositBaseboolean = true;
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
                ,{title: '证件名称', width:135, templet: '#select',style: 'height:52px;padding-top:0px'}
                ,{field: 'employeeNationnality', title: '国别', width: 135, edit:'text'}
                ,{field: 'employeePapersNum', title: '证件号码', width: 180, edit:'text'}
                ,{field: 'depositBase', title: '缴存基数', width: 135, edit:'text'}
                ,{field: 'unitDeposite', title: '单位月缴存额', width: 135}
                ,{field: 'employeeDeposite', title: '个人月缴存额', width: 135}
                ,{field: 'depositeTotal', title: '月缴存额合计', width: 135}
                /*,{field: 'wealth', title: '二级管理辅助信息', width: 150
                    , templet: '<div><input type="radio" name="second" value="开通" title="开通">' +
                        '<input type="radio" name="second" value="不开通" title="不开通"></div>'}*/

                ,{field: '', title: '保存/删除', width: 110, fixed: 'right',style: 'height:52px'
                    , toolbar:'<div>' +
                                 '<div class="layui-btn-group">\n' +
                                    '<button type="button" class="layui-btn layui-btn-sm" lay-event="save">\n' +
                                        '<i class="layui-icon">&#xe61f;</i>\n' +
                                    '</button>\n' +
                                    '<button type="button" class="layui-btn layui-btn-sm" lay-event="delete">\n' +
                                        '<i class="layui-icon">&#xe640;</i>\n' +
                                    '</button>\n' +
                                 '</div>' +
                              '</div>'}
            ]]

        });

        table.on('edit(edit)', function(obj){

            console.log(obj.value); //得到修改后的值
            console.log(obj.field); //当前编辑的字段名
            console.log(obj.data); //所在行的所有相关数据

            if(obj.field ==="employeePapersNum" && obj.data.employeePapersName==="身份证"){
                //身份证号吗验证的正则
                var papersNumReg = /(^[1-9]\d{5}(19|([23]\d))\d{2}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}[0-9Xx]$)|(^[1-9]\d{5}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{2}[0-9Xx]$)/;
                if(!papersNumReg.test(obj.value)){
                    layer.open({
                        content:'身份证号码格式不正确！'
                    });
                    senfenboolean=false;
                    $(obj.tr[0].firstChild).next().next().next().next().css("color","red");
                }else {
                    senfenboolean=true;
                    $(obj.tr[0].firstChild).next().next().next().next().css("color","black");
                }
            }

            if(obj.field ==="depositBase"){
                //身份证号吗验证的正则
                var depositBaseReg = /^(0|[1-9][0-9]{0,5})(\.([0][1-9]|[1-9][0-9]|[0][0]|[1-9]))?$/;
                if(!depositBaseReg.test(obj.value)){
                    layer.open({
                        content:'缴存基数格式不正确！'
                    });
                    depositBaseboolean=false;
                    $(obj.tr[0].firstChild).next().next().next().next().next().css("color","red");
                }else {
                    depositBaseboolean=true;
                    $(obj.tr[0].firstChild).next().next().next().next().next().css("color","black");
                }
            }
            /*if(obj.field==="depositBase"){
                //身份证号吗验证的正则
                var papersNumReg = ;
                if(!papersNumReg.test(obj.value)){
                    layer.open({
                        content:'身份证号码格式不正确'});
                    boolean=false;

                }else {
                    boolean=true;
                }
            }*/

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
                if (senfenboolean==false || depositBaseboolean==false){
                    layer.open({
                        content: '尚有不正确的格式未修改,无法保存！'
                    });
                }else {
                    layer.open({
                        content: '是否保存？'
                        , btn: ['是', '否']
                        , yes: function () {
                            if (senfenboolean) {
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
                                            , url: '/remittance/select?UnitRegisterId=' + unitRegistId
                                            , page: {
                                                curr: 1
                                            }
                                            , toolbar: '#toolbar'
                                        });
                                    },
                                });
                            } else {
                                layer.open({
                                    content: '您输入的身份证号不符合规范请重新输入！'
                                });
                            }

                        }
                        , btn2: function () {
                            flag = false;
                        }
                    });
                }

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