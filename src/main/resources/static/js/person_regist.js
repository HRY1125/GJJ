window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

        //监听select
        form.on('select(papers)', function(data){
            var kind = $("#select1").val();
            if (kind == '护照'){
                $("#div_nation").css("display","block");
                $("#ipt_nation").attr("lay-verify","required");
                $("#papersNum").attr("lay-verify","required");
            }else{
                $("#div_nation").css("display","none");
                $("#ipt_nation").removeAttr("lay-verify");
                $("#papersNum").attr("lay-verify","required|identity");
            }
        });
    });


};