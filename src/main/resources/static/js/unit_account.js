window.onload=function(){

    layui.use('form', function(){
        var form = layui.form;

    });

    $(function () {
       $("#ipt_unitId").blur(function () {
           var data = $("#ipt_unitId").val();
           alert(data);
           $.ajax({
               //请求方式
               type : "POST",
               //请求的媒体类型
               //contentType: "application/json;charset=UTF-8",
               //请求地址
               url : "",
               //数据，json字符串
               data : JSON.stringify(list),
               //请求成功
               success : function(result) {

               },
           });
       });
    });

};