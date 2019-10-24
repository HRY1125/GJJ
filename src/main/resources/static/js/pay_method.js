window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

        form.on('radio(kind)', function(data){
            var value = data.value;
            if(value==0){
                $(".entrust").css("display","block");
                $(".remit").css("display","none");
                $(".check").css("display","none");
                $(".cash").css("display","none");
                $(".finance").css("display","none");
                $(".transfer").css("display","none");
            }else if(value==1){
                $(".entrust").css("display","none");
                $(".remit").css("display","block");
                $(".check").css("display","none");
                $(".cash").css("display","none");
                $(".finance").css("display","none");
                $(".transfer").css("display","none");
            }else if(value==2){
                $(".entrust").css("display","none");
                $(".remit").css("display","none");
                $(".check").css("display","block");
                $(".cash").css("display","none");
                $(".finance").css("display","none");
                $(".transfer").css("display","none");
            }else if(value==3){
                $(".entrust").css("display","none");
                $(".remit").css("display","none");
                $(".check").css("display","none");
                $(".cash").css("display","block");
                $(".finance").css("display","none");
                $(".transfer").css("display","none");
            }else if(value==4){
                $(".entrust").css("display","none");
                $(".remit").css("display","none");
                $(".check").css("display","none");
                $(".cash").css("display","none");
                $(".finance").css("display","block");
                $(".transfer").css("display","none");
            }else if(value==5){
                $(".entrust").css("display","none");
                $(".remit").css("display","none");
                $(".check").css("display","none");
                $(".cash").css("display","none");
                $(".finance").css("display","none");
                $(".transfer").css("display","block");
            }else{
                $(".entrust").css("display","none");
                $(".remit").css("display","none");
                $(".check").css("display","none");
                $(".cash").css("display","none");
                $(".finance").css("display","none");
                $(".transfer").css("display","none");
            }
        });
    });

};