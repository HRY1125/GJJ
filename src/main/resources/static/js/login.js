window.onload=function(){

    $("#unitName").blur(function () {
        var data = $("#unitName").val();
        $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "/sys/isUnitName",
            data : data,
            dataType : "json",
            success : function(result) {
                var res = result.isExist;
                if(res==false){
                    $("#res_unitName_r").show();
                    $("#res_unitName_w").hide();
                }else{
                    $("#res_unitName_r").hide();
                    $("#res_unitName_w").show();
                }
            }

        });
    });

}