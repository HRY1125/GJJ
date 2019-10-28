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

};