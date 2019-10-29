window.onload=function(){

    layui.use(['form','laydate'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        var $ = layui.jquery;

        //时间格式设置
        laydate.render({
            elem: '.laydate',
            format:'yyyy-MM-dd',
            trigger:'click'
        });

        //监听select
        form.on('select(papers)', function(data){
            if ($("#select2").val()=='护照'){
                $("#div_nation").css("display","block");
                $("#ipt_nation").attr("required","required");
            }else{
                $("#div_nation").css("display","none");
                $("#ipt_nation").removeAttr("required");
            }
        });
    });

    //身份证号码验证
    $("#lpPapersNum").blur(function () {
        var papersNumReg = /(^[1-9]\d{5}(19|([23]\d))\d{2}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}[0-9Xx]$)|(^[1-9]\d{5}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{2}[0-9Xx]$)/;
        var data = $("#lpPapersNum").val();
        var papersName = $("#select2").val();

        if(data==null || data == ""){
            $("#res_lpPapersNum_r").hide();
            $("#res_lpPapersNum_w").show();
            $("#lpPapersNum_span").css("display","inline").html("证件号不能为空");
        }else {
            if (papersName == '身份证'){
                if (!papersNumReg.test(data)){
                    $("#res_lpPapersNum_r").hide();
                    $("#res_lpPapersNum_w").show();
                    $("#lpPapersNum_span").css("display","inline").html("身份证号码格式不正确");
                }else {
                    $("#res_lpPapersNum_r").show();
                    $("#res_lpPapersNum_w").hide();
                    $("#lpPapersNum_span").css("display","none");
                }
            }
        }
    });

};