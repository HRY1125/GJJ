window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

        //监听select
        form.on('select(papers)', function(data){
            if ($("#select1").val()==1){
                $("#div_nation").css("display","block");
            }else{
                $("#div_nation").css("display","none");
            }
        });
    });


};