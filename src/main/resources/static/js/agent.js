window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

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