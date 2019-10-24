window.onload=function(){


    layui.use('form', function(){
        var form = layui.form;

    });

    $(function () {
        $.ajax({
            type:"POST",
            url:"../account/selectAccountByUnitRegisterId",
            data:{"unitRegisterId":"1"},
            dataType:"json",
            success:function (data) {
                $.each(data, function(index,values){// 解析出data对应的Object数组
                    if(index==="unitPhone"){
                        alert(values);
                        $("#dianhua").val(values);
                    }
                    if(index==="unitDepositeRatio"){
                        alert(values);
                        $("#danweibili").val(values);
                        $("#gernbili").val(values)
                    }
                    if(index==="agentDepartment"){
                        alert(values);
                        $("#yewujingban").val(values);
                    }
                });


            },
            error : function (data) {
                alert("有错了");
            }
        });
        $("#ipt_unitId").blur(function () {
            var unitId = $("#ipt_unitId").val();
            $.ajax({
                type : "POST",
                contentType: "application/json;charset=UTF-8",
                url : "",
                data : unitId,
                dataType : "json",
                success : function(result) {
                    $("#unitName").val(result);
                },
                error : function (result) {

                }
            });

        });
    });
};
