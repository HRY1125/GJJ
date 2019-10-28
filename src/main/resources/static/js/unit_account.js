window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

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