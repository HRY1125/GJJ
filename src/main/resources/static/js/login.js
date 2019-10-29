window.onload=function(){

    //经办人姓名验证
    $("#agentName").blur(function () {
        var agentName = $("#agentName").val();
        if (agentName ==null || agentName == ""){
            $("#res_agentName_r").hide();
            $("#res_agentName_w").show();
            $("#agentName_span").css("display","inline").html("经办人姓名不能为空");
        }else {
            $("#res_agentName_r").show();
            $("#res_agentName_w").hide();
            $("#agentName_span").css("display","none");
        }
    });

    //证件名称验证
    $("#select1").blur(function () {
        var papersName = $("#select1").val();
        if (papersName ==null || papersName == ""){
            $("#res_papersName_r").hide();
            $("#res_papersName_w").show();
            $("#papersName_span").css("display","inline").html("证件名称不能为空");
        }else {
            $("#res_papersName_r").show();
            $("#res_papersName_w").hide();
            $("#papersName_span").css("display","none");
        }
    });

    //身份证号码验证
    $("#papersNum").blur(function () {
        var papersNumReg = /(^[1-9]\d{5}(19|([23]\d))\d{2}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}[0-9Xx]$)|(^[1-9]\d{5}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{2}[0-9Xx]$)/;
        var data = $("#papersNum").val();
        var papersName = $("#select1").val();

        if(data==null || data == ""){
            $("#res_papersNum_r").hide();
            $("#res_papersNum_w").show();
            $("#papersNum_span").css("display","inline").html("身份证号不能为空");
        }else {
            if (papersName == '身份证'){
                if (!papersNumReg.test(data)){
                    $("#res_papersNum_r").hide();
                    $("#res_papersNum_w").show();
                    $("#papersNum_span").css("display","inline").html("身份证号码格式不正确");
                }else {
                    $("#res_papersNum_r").show();
                    $("#res_papersNum_w").hide();
                    $("#papersNum_span").css("display","none");
                }
            }
        }
    });

    //手机号码验证
    $("#agentPhone").blur(function () {
        var phoneReg = /^1[34578]\d{9}$/;
        var data = $("#agentPhone").val();
        if(data==null || data == ""){
            $("#res_phone_r").hide();
            $("#res_phone_w").show();
            $("#phone_span").css("display","inline").html("手机号不能为空");
        }else if (!phoneReg.test(data)){
            $("#res_phone_r").hide();
            $("#res_phone_w").show();
            $("#phone_span").css("display","inline").html("手机号码不正确");
        }else {
            $("#res_phone_r").show();
            $("#res_phone_w").hide();
            $("#phone_span").css("display","none")
        }
    });

    //注册邮箱验证
    $("#unitEmail").blur(function () {
        var emailReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        var data = $("#unitEmail").val();
        if(data==null || data == ""){
            $("#res_unitEmail_r").hide();
            $("#res_unitEmail_w").show();
            $("#email_span").css("display","inline").html("邮箱不能为空");
        }else if (!emailReg.test(data)){
            $("#res_unitEmail_r").hide();
            $("#res_unitEmail_w").show();
            $("#email_span").css("display","inline").html("邮箱格式不正确");
        }else {
            $("#res_unitEmail_r").show();
            $("#res_unitEmail_w").hide();
            $("#email_span").css("display","none")
        }
    });

    //密码获得焦点时
    $("#password").focus(function () {
        $("#password_span").css("display","inline")
    });

    //密码验证
    $("#password").blur(function () {
        var passwordReg = /^[A-Za-z0-9_]{5,10}$/;
        var data = $("#password").val();
        if(data==null || data == ""){
            $("#res_password_r").hide();
            $("#res_password_w").show();
            $("#password_span").css("display","inline").html("请输入密码");
        }else if (!passwordReg.test(data)){
            $("#res_password_r").hide();
            $("#res_password_w").show();
            $("#password_span").css("display","inline").html("请确认密码格式正确");
        }else {
            $("#res_password_r").show();
            $("#res_password_w").hide();
            $("#password_span").css("display","none")
        }
    });

    //确认密码验证
    $("#password1").blur(function () {
        var passwordReg = /^[A-Za-z0-9_]{5,10}$/;
        var password = $("#password").val();
        var password1 = $("#password1").val();
        if(password1==null || password1 == ""){
            $("#res_password1_r").hide();
            $("#res_password1_w").show();
            $("#password1_span").css("display","inline").html("请输入确认密码");
        }else if (!passwordReg.test(password1)){
            $("#res_password1_r").hide();
            $("#res_password1_w").show();
            $("#password1_span").css("display","inline").html("请确认密码格式正确");
        }else if (password != password1){
            $("#res_password1_r").hide();
            $("#res_password1_w").show();
            $("#password1_span").css("display","inline").html("两次密码不一致");
        }else {
            $("#res_password1_r").show();
            $("#res_password1_w").hide();
            $("#password1_span").css("display","none")
        }
    });

    //注册单位名称验证
    $("#unitName").blur(function () {
        var data = $("#unitName").val();
        if (data ==null || data == ""){
            $("#res_unitName_r").hide();
            $("#res_unitName_w").show();
            $("#unitName_span").css("display","inline").html("单位名称不能为空");
        }else {
            $.ajax({
                type : "POST",
                contentType: "application/json;charset=UTF-8",
                url : "/sys/isUnitName",
                data : data,
                dataType : "json",
                success : function(result) {
                    var res = result.isExist;
                    if(res==false){
                        $("#res_unitName_r").show();
                        $("#res_unitName_w").hide();
                        $("#unitName_span").css("display","none");

                    }else{
                        $("#res_unitName_r").hide();
                        $("#res_unitName_w").show();
                        $("#unitName_span").css("display","inline").html("单位已注册过");
                    }
                }

            });
        }
    });

    //select下拉框字体颜色设置
    var unSelected = "gray";
    var selected = "#000";
    $("#select1").css("color", unSelected);
    $("option").css("color", selected);
    $("#select1").change(function () {
        var selItem = $(this).val();
        if (selItem == $(this).find('option:first').val()) {
            $(this).css("color", unSelected);
        } else {
            $(this).css("color", selected);
        }
    });

};
