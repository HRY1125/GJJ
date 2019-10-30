window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

        form.verify({
            single:function (value,item) {
                var flag = true;
                if ($(item).is(':checked')){
                    flag = false;
                }
                var brothers = $(item).siblings();
                for(var b in brothers){
                    if ($(brothers[b]).is(':checked')){
                        flag = false;
                    }
                }
                if (flag){
                    return "单选必填项不能为空";
                }
            },

            unitRegistId:function (value, item) {
                if(!(/[1-9]([0-9]{8})/.test(value))){
                    return "请输入正确的单位登记号";
                }
            }
        });
    });

    $(function () {
       $("#ipt_unitId").blur(function () {
           var unitId = $("#ipt_unitId").val();
           $.ajax({
               type : "POST",
               contentType: "application/json;charset=UTF-8",
               url : "/sys/findURId",
               data : unitId,
               dataType : "json",
               success : function(result) {
                   $("#unitName").val(result.unitName);
               }
           });
       });
    });


   /* //经办部门认证
    $("#agentDepartment1").blur(function () {
        var agentDepartment = /^[\u0391-\uFFE5]+${7}$/;
        var data = $("#agentDepartment1").val();
        if(data==null || data == ""){
            $("#agentDepartment1_r").hide();
            $("#agentDepartment1_w").show();
            $("#agentDepartment1_span").css("display","inline").html("业务经办部门不能为空");
        }else if (!agentDepartment.test(data)){
            $("#agentDepartment1_r").hide();
            $("#agentDepartment1_w").show();
            $("#agentDepartment1_span").css("display","inline").html("业务经办部门输入不正确");
        }else {
            $("#agentDepartment1_r").show();
            $("#agentDepartment1_w").hide();
            $("#agentDepartment1_span").css("display","none")
        }
    });*/

    //手机号码验证
    $("#unitPhone1").blur(function () {
        var phoneReg = /^1[34578]\d{9}$/;
        var data = $("#unitPhone1").val();
        if(data==null || data == ""){
            $("#unitPhone_r").hide();
            $("#unitPhone_w").show();
            $("#unitPhone_span").css("display","inline").html("手机号不能为空");
        }else if (!phoneReg.test(data)){
            $("#unitPhone_r").hide();
            $("#unitPhone_w").show();
            $("#unitPhone_span").css("display","inline").html("手机号码不正确");
        }else {
            $("#unitPhone_r").show();
            $("#unitPhone_w").hide();
            $("#unitPhone_span").css("display","none")
        }
    });




};

