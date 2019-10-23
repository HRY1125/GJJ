window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

        //监听select
        form.on('select(papers)', function(data){
            if ($("#select1").val()==1){
                $("#div_nation").css("display","block");
                $("#ipt_nation").attr("required","required");
            }else{
                $("#div_nation").css("display","none");
                $("#ipt_nation").removeAttr("required");
            }
        });
    });


};