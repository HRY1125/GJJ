window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

        form.on('radio(kind)', function(data){
            var value = data.value;
            if(value=='委托收款'){
                $(".entrust").css("display","block");
                $(".entrust_ipt").attr("lay-verify","required");
                $(".remit").css("display","none");
                $(".remit_ipt").removeAttr("lay-verify");
                $(".check").css("display","none");
                $(".check_ipt").removeAttr("lay-verify");
                $(".cash").css("display","none");
                $(".cash_ipt").removeAttr("lay-verify");
                $(".finance").css("display","none");
                $(".finance_ipt").removeAttr("lay-verify");
                $(".transfer").css("display","none");
                $(".transfer_ipt").removeAttr("lay-verify");
            }else if(value=='主动汇款'){
                $(".entrust").css("display","none");
                $(".entrust_ipt").removeAttr("lay-verify");
                $(".remit").css("display","block");
                $(".remit_ipt").attr("lay-verify","required");
                $(".check").css("display","none");
                $(".check_ipt").removeAttr("lay-verify");
                $(".cash").css("display","none");
                $(".cash_ipt").removeAttr("lay-verify");
                $(".finance").css("display","none");
                $(".finance_ipt").removeAttr("lay-verify");
                $(".transfer").css("display","none");
                $(".transfer_ipt").removeAttr("lay-verify");
            }else if(value=='转账支票'){
                $(".entrust").css("display","none");
                $(".entrust_ipt").removeAttr("lay-verify");
                $(".remit").css("display","none");
                $(".remit_ipt").removeAttr("lay-verify");
                $(".check").css("display","block");
                $(".check_ipt").attr("lay-verify","required");
                $(".cash").css("display","none");
                $(".cash_ipt").removeAttr("lay-verify");
                $(".finance").css("display","none");
                $(".finance_ipt").removeAttr("lay-verify");
                $(".transfer").css("display","none");
                $(".transfer_ipt").removeAttr("lay-verify");
            }else if(value=='现金(刷卡)'){
                $(".entrust").css("display","none");
                $(".entrust_ipt").removeAttr("lay-verify");
                $(".remit").css("display","none");
                $(".remit_ipt").removeAttr("lay-verify");
                $(".check").css("display","none");
                $(".check_ipt").removeAttr("lay-verify");
                $(".cash").css("display","block");
                $(".cash_ipt").attr("lay-verify","required");
                $(".finance").css("display","none");
                $(".finance_ipt").removeAttr("lay-verify");
                $(".transfer").css("display","none");
                $(".transfer_ipt").removeAttr("lay-verify");
            }else if(value=='财政统发'){
                $(".entrust").css("display","none");
                $(".entrust_ipt").removeAttr("lay-verify");
                $(".remit").css("display","none");
                $(".remit_ipt").removeAttr("lay-verify");
                $(".check").css("display","none");
                $(".check_ipt").removeAttr("lay-verify");
                $(".cash").css("display","none");
                $(".cash_ipt").removeAttr("lay-verify");
                $(".finance").css("display","block");
                $(".finance_ipt").attr("lay-verify","required");
                $(".transfer").css("display","none");
                $(".transfer_ipt").removeAttr("lay-verify");
            }else if(value=='转账交款'){
                $(".entrust").css("display","none");
                $(".entrust_ipt").removeAttr("lay-verify");
                $(".remit").css("display","none");
                $(".remit_ipt").removeAttr("lay-verify");
                $(".check").css("display","none");
                $(".check_ipt").removeAttr("lay-verify");
                $(".cash").css("display","none");
                $(".cash_ipt").removeAttr("lay-verify");
                $(".finance").css("display","none");
                $(".finance_ipt").removeAttr("lay-verify");
                $(".transfer").css("display","block");
                $(".transfer_ipt").attr("lay-verify","required");
            }else{
                $(".entrust").css("display","none");
                $(".entrust_ipt").removeAttr("lay-verify");
                $(".remit").css("display","none");
                $(".remit_ipt").removeAttr("lay-verify");
                $(".check").css("display","none");
                $(".check_ipt").removeAttr("lay-verify");
                $(".cash").css("display","none");
                $(".cash_ipt").removeAttr("lay-verify");
                $(".finance").css("display","none");
                $(".finance_ipt").removeAttr("lay-verify");
                $(".transfer").css("display","none");
                $(".transfer_ipt").removeAttr("lay-verify");
            }
        });

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

    //汇款账号验证
    $("#remitUnitAccount1").blur(function () {
        var phoneReg = /^\d{19}$/g;
        var data = $("#remitUnitAccount1").val();
        if(data==null || data == ""){
            $("#remitUnitAccount_r").hide();
            $("#remitUnitAccount_w").show();
            $("#remitUnitAccount_span").css("display","inline").html("汇款账号不能为空");
        }else if (!phoneReg.test(data)){
            $("#remitUnitAccount_r").hide();
            $("#remitUnitAccount_w").show();
            $("#remitUnitAccount_span").css("display","inline").html("汇款账号不正确");
        }else {
            $("#remitUnitAccount_r").show();
            $("#remitUnitAccount_w").hide();
            $("#remitUnitAccount_span").css("display","none")
        }
    });

    //委托收款单位账号验证
    $("#receiptUnitAccount1").blur(function () {
        var phoneReg = /^\d{19}$/g;
        var data = $("#receiptUnitAccount1").val();
        if(data==null || data == ""){
            $("#receiptUnitAccount_r").hide();
            $("#receiptUnitAccount_w").show();
            $("#receiptUnitAccount_span").css("display","inline").html("收款账号不能为空");
        }else if (!phoneReg.test(data)){
            $("#receiptUnitAccount_r").hide();
            $("#receiptUnitAccount_w").show();
            $("#receiptUnitAccount_span").css("display","inline").html("收款账号不正确");
        }else {
            $("#receiptUnitAccount_r").show();
            $("#receiptUnitAccount_w").hide();
            $("#receiptUnitAccount_span").css("display","none")
        }
    });


};