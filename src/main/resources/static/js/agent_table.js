window.onload=function(){

    layui.use(['table','form','layer'], function(){
        var table = layui.table;
        var form = layui.form;
        var layer = layui.layer;
        var agentPapersNumBoolean = true;
        var nationalityBoolean = true;
        var officePhoneBoolean = true;
        var agentPhoneBoolean = true;
        var agentEmailBoolean = true;
        var agentUserNameBoolean = true;
        var ukeyBoolean = true;
        table.render({

            elem: '#agent'
            ,height: 500
            ,url: '/agent/select'
            ,page: true
            ,toolbar: '#toolbar'
            ,done: function (res, curr, count) {
                layui.each($('select'), function (index, item) {
                    var elem = $(item);
                    elem.val(elem.data('value')).parents('div.layui-table-cell').css('overflow', 'visible');
                });
                form.render();
            }
            ,cols: [
                        [ //表头
                /*{field: 'NO.', title: '序号', width:80}
                ,*/{field: 'agentId', title: '经办人编号', width:135}
                ,{field: 'agentName', title: '经办人姓名', width:135, edit:'text'}
                ,{
                    field: 'agentPapersName',
                    title: '经办人证件名称',
                    width:135,
                    // edit:'text',
                    // search:true,
                    // type:'normal',
                    templet:function (d) {
                        // 模板的实现方式也是多种多样，这里简单返回固定的
                        return '<select name="agentPapersName" lay-filter="testSelect" lay-verify="required" data-value="' + d.agentPapersName + '" >\n' +
                            '        <option value=""></option>\n' +
                            '        <option value="身份证">身份证</option>\n' +
                            '        <option value="护照">护照</option>\n' +
                            '      </select>';
                    }}
                ,{field: 'agentPapersNum', title: '经办人证件号码', width: 180, edit:'text'}
                ,{field: 'nationality', title: '国籍', width: 135, edit:'text'}
                ,{field: 'officePhone', title: '办公电话', width: 135, edit:'text'}
                ,{field: 'agentPhone', title: '手机号码', width: 135, edit:'text'}
                ,{field: 'agentEmail', title: '经办人邮箱', width: 135, edit:'text'}
                ,{
                    field: 'agentType',
                            title: '用户类型',
                            width: 135,
                            edit:false,
                            templet:function (d) {
                                // 模板的实现方式也是多种多样，这里简单返回固定的
                                return '<select name="agentType" lay-filter="testSelect" lay-verify="required" data-value="' + d.agentType + '" >\n' +
                                    '        <option value=""></option>\n' +
                                    '        <option value="证书用户" disabled="disabled">证书用户</option>\n' +
                                    '        <option value="非证书用户">非证书用户</option>\n' +
                                    '      </select>';
                            }
                        }
                ,{field: 'ukey', title: '数字证书', width: 240}
                ,{field: 'agentUserName', title: '用户名', width: 135, edit:'text'}
                ,{field: '', title: '保存/删除', width: 110, fixed: 'right'
                    , toolbar:'<div><div class="layui-btn-group">\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="save">\n' +
                        '    <i class="layui-icon">&#xe61f;</i>\n' +
                        '  </button>\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="delete">\n' +
                        '    <i class="layui-icon">&#xe640;</i>\n' +
                        '  </button>\n' + '</div>' +
                        '</div>'}
                        ]
            ]
        });

        // 监听修改update到表格中
        form.on('select(testSelect)', function (data) {
            debugger;
            var elem = $(data.elem);
            var trElem = elem.parents('tr');
            var tableData = table.cache['agent'];
            // 更新到表格的缓存数据中，才能在获得选中行等等其他的方法中得到更新之后的值
            tableData[trElem.data('index')][elem.attr('name')] = data.value;
            // 其他的操作看需求 TODO
        });

        table.on('edit(edit)', function(obj){

            console.log(obj.value); //得到修改后的值
            console.log(obj.field); //当前编辑的字段名
            console.log(obj.data); //所在行的所有相关数据

            if (obj.value === null){
                layer.message(obj.field+"不能为空");
            }


            //身份证号码验证
           if (obj.field==="agentPapersNum") {
                var papersNumReg = /(^[1-9]\d{5}(19|([23]\d))\d{2}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}[0-9Xx]$)|(^[1-9]\d{5}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{2}[0-9Xx]$)/;
                var papersNum = obj.value;

                if(papersNum==null || papersNum === ""){
                    layer.alert("证件号不能为空");
                    agentPapersNumBoolean = false;
                }else {
                    if (obj.data.agentPapersName === '身份证'){
                        if (!papersNumReg.test(papersNum)){
                            layer.alert("身份证号码格式不正确");
                            agentPapersNumBoolean = false;
                        }else {
                            agentPapersNumBoolean = true;
                        }
                    }
                }
            }

           //国籍验证
            if (obj.field === "nationality"){
                if (obj.data.agentPapersName === '护照'){
                    if (obj.value === null || obj.value === ""){
                        layer.alert("国籍不能为空");
                        nationalityBoolean = false;
                    }else {
                        nationalityBoolean = true;
                    }
                }
            }


            //办公电话验证
           if (obj.field === "officePhone"){
                var phoneReg = /^0\d{2,3}-?\d{7,8}$/;
                var officePhone = obj.value;
                if(officePhone==null || officePhone === ""){
                    layer.alert("电话号码不能为空");
                    officePhoneBoolean = false;
                }else if (!phoneReg.test(officePhone)){
                    layer.alert("号码格式应为区号+座机号");
                    officePhoneBoolean = false;
                }else {
                    officePhoneBoolean = true;
                }
           }

            //手机号码验证
            if (obj.field === "agentPhone"){
                var phoneReg = /^1[34578]\d{9}$/;
                var phone = obj.value;
                if(phone==null || phone === ""){
                    layer.alert("手机号不能为空");
                    agentPhoneBoolean=false;
                }else if (!phoneReg.test(phone)){
                    layer.alert("手机号码不正确");
                    agentPhoneBoolean = false;
                }else {
                    agentPhoneBoolean = true;
                }
            }

            //注册邮箱验证
            if (obj.field === "agentEmail"){
                var emailReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+\.([a-zA-Z0-9_-]+)+$/;
                var agentEmail = obj.value;
                if(agentEmail==null || agentEmail === ""){
                    layer.alert("邮箱不能为空");
                    agentEmailBoolean = false;
                }else if (!emailReg.test(agentEmail)){
                    layer.alert("邮箱格式不正确");
                    agentEmailBoolean = false;
                }else {
                    agentEmailBoolean = true;
                }
            }

        });

        form.verify({
            myVerify:function (value, item) { //value：表单的值、item：表单的DOM对象
                if(value==null){
                    return alert("不能为空");
                }
            }
        });

        //头工具栏监听
        table.on('toolbar(edit)', function(obj){
            var event = obj.event;
            var flag = true;

            if(flag){
                $.ajax({
                    type : "POST",
                    contentType: "application/json;charset=UTF-8",
                    url : "/agent/insert",
                    data : "",
                    dataType : "json",
                    success : function(result) {
                        table.reload('agent',{
                            height: 500
                            ,url: '/agent/select'
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
            if (data.agentPapersName ==="护照" || data.agentPapersName ==="身份证"){
                if (data.agentPapersNum == null){
                    layer.alert("请填写证件号码");
                    agentPapersNumBoolean=false;
                }
            }
            if (data.agentPapersName === "护照"){
                if (data.nationality ===null){
                    layer.alert("请填写国籍");
                    nationalityBoolean = false;
                }
            }
            if (data.agentType === "非证书用户"){
                if (data.agentUserName == null){
                    layer.alert("请填写用户名");
                    agentUserNameBoolean=false;
                }
            }
            var event = obj.event;
            var flag = true;
            if(event=='save'){
                if (agentPapersNumBoolean===false|| nationalityBoolean===false|| officePhoneBoolean===false
                    ||agentPhoneBoolean===false|| agentEmailBoolean===false||
                    agentUserNameBoolean===false|| ukeyBoolean===false){
                    alert("有选项不符合填写要求，请认真检查");
                }else {
                    layer.open({
                        content:'是否保存？'
                        ,btn:['是','否']
                        ,yes:function () {
                            $.ajax({
                                type: "POST",
                                contentType: "application/json;charset=UTF-8",
                                url: "/agent/update",
                                data: JSON.stringify(data),
                                dataType: "json",
                                success: function (result) {
                                    layer.msg("保存成功！");
                                    table.reload('agent', {
                                        height: 500
                                        , url: '/agent/select'
                                        , page:{
                                            curr:1
                                        }
                                        , toolbar: '#toolbar'
                                    });
                                }
                            });
                        }
                        ,btn2:function () {
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
                            url: "/agent/delete",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (result) {
                                layer.msg("删除成功！");
                                table.reload('employ', {
                                    height: 500
                                    , url: '/agent/select'
                                    , page: {
                                        curr:1
                                    }
                                    , toolbar: '#toolbar'
                                });
                            }
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

    });
};