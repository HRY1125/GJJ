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


    var unSelected = "gray";
    var selected = "#000";
    $("#select1").css("color", unSelected);
    $("option").css("color", selected);
    $("#select1").change(function () {
        var selItem = $(this).val();
        if (selItem == $(this).find('option:first').val()) {
            $(this).css("color", unSelected);
        } else {
            $(this).css("color", selected);
        }
    });

};
