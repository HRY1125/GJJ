window.onload=function(){

    layui.use(['form','laydate'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        var $ = layui.jquery;

        //时间格式设置
        laydate.render({
            elem: '.laydate',
            format:'yyyy-MM-dd',
            trigger:'click'
        });

        //监听select
        form.on('select(papers)', function(data){
            if ($("#select2").val()=='护照'){
                $("#div_nation").css("display","block");
                $("#ipt_nation").attr("required","required");
            }else{
                $("#div_nation").css("display","none");
                $("#ipt_nation").removeAttr("required");
            }
        });
    });


};