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

};