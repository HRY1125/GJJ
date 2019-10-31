window.onload=function(){

    layui.use(['table','form','layer'], function(){
        var table = layui.table;
        var form = layui.form;
        var layer = layui.layer;
        var unitId = $("#ipt_unitId").val();
        table.render({

            elem: '#employ'
            ,height: 500
            ,url: '/remittance/select?UnitId='+unitId
            ,page: true
            ,toolbar: '#toolbar'
            ,cols: [[ //表头
                /*{field: 'NO.', title: '序号', width:80}
                ,*/{field: 'unitRegisterId', title: '单位登记号', width:135}
                ,{field: 'agentName', title: '经办人姓名', width:135, edit:'text'}
                ,{field: 'agentPapersName', title: '经办人证件名称', width:135, edit:'text'}
                ,{field: 'agentPapersNum', title: '经办人证件号码', width: 180, edit:'text'}
                ,{field: 'nationality', title: '国籍', width: 135, edit:'text'}
                ,{field: 'officePhone', title: '办公电话', width: 135, edit:'text'}
                ,{field: 'agentPhone', title: '手机号码', width: 135, edit:'text'}
                ,{field: 'agentEmail', title: '经办人邮箱', width: 135, edit:'text'}
                ,{field: 'agentType', title: '用户类型', width: 135}
                ,{field: 'ukey', title: '数字证书', width: 135}
                ,{field: 'agentUserName', title: '用户名', width: 135}
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

        form.verify({
            myVerify:function (value, item) { //value：表单的值、item：表单的DOM对象
                if(value==null){
                    return "不能为空";
                }
            }
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
                    url : "/remittance/add?unitId="+$("#ipt_unitId").val(),
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
        });

        //监听select
        form.on('select(papers)', function(data){
            if ($("#select1").val()=='护照'){
                $("#div_nation").css("display","block");
                $("#ipt_nation").attr("required","required");
            }else{
                $("#div_nation").css("display","none");
                $("#ipt_nation").removeAttr("required");
            }
        });

        //监听select
        form.on('select(agentType)', function(data){
            if ($("#select2").val()=='证书用户'){
                $("#div_ukey").css("display","block");
                $("#ipt_ukey").attr("required","required");
                $("#div_username").css("display","none");
                $("#ipt_username").removeAttr("required");
            }else{
                $("#div_ukey").css("display","none");
                $("#ipt_ukey").removeAttr("required");
                $("#div_username").css("display","block");
                $("#ipt_username").attr("required","required");
            }
        });

        //身份证号码验证
        $("#agentPapersNum").blur(function () {
            var papersNumReg = /(^[1-9]\d{5}(19|([23]\d))\d{2}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}[0-9Xx]$)|(^[1-9]\d{5}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{2}[0-9Xx]$)/;
            var data = $("#agentPapersNum").val();
            var papersName = $("#select1").val();

            if(data==null || data == ""){
                $("#agentPapersNum_span").css("display","inline").html("证件号不能为空");
            }else {
                if (papersName == '身份证'){
                    if (!papersNumReg.test(data)){
                        $("#agentPapersNum_span").css("display","inline").html("身份证号码格式不正确");
                    }else {
                        $("#agentPapersNum_span").css("display","none");
                    }
                }
            }
        });

        //办公电话验证
        $("#officePhone").blur(function () {
            var phoneReg = /^(0\d{2,3}-)?\d{7,8}$/;
            var data = $("#officePhone").val();
            if(data==null || data == ""){
                $("#officePhone_span").css("display","inline").html("办公电话不能为空");
            }else if (!phoneReg.test(data)){
                $("#officePhone_span").css("display","inline").html("办公电话不正确");
            }else {
                $("#officePhone_span").css("display","none")
            }
        });

        //手机号码验证
        $("#agentPhone").blur(function () {
            var phoneReg = /^1[34578]\d{9}$/;
            var data = $("#agentPhone").val();
            if(data==null || data == ""){
                $("#agentPhone_span").css("display","inline").html("手机号不能为空");
            }else if (!phoneReg.test(data)){
                $("#agentPhone_span").css("display","inline").html("手机号码不正确");
            }else {
                $("#agentPhone_span").css("display","none")
            }
        });

        //注册邮箱验证
        $("#agentEmail").blur(function () {
            var emailReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+\.([a-zA-Z0-9_-]+)+$/;
            var data = $("#agentEmail").val();
            if(data==null || data == ""){
                $("#agentEmail_span").css("display","inline").html("邮箱不能为空");
            }else if (!emailReg.test(data)){
                $("#agentEmail_span").css("display","inline").html("邮箱格式不正确");
            }else {
                $("#agentEmail_span").css("display","none")
            }
        });
    });
};