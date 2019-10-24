window.onload=function(){

    layui.use(['form','laydate'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        var $ = layui.jquery;

        //时间格式设置
        $(".laydate").each(function () {
            laydate.render({
                elem: this,
                type: 'datetime',
                format:'yyyy-MM-dd HH:mm',
                ready: formatminutes,
                trigger:'click'
            });
        });

        //日期时间选择器去掉秒
        function formatminutes(date){
            $($(".laydate-time-list li ol")[2]).find("li").remove();
        }

        //监听select
        form.on('select(papers)', function(data){
            if ($("#select2").val()==1){
                $("#div_nation").css("display","block");
                $("#ipt_nation").attr("required","required");
            }else{
                $("#div_nation").css("display","none");
                $("#ipt_nation").removeAttr("required");
            }
        });
    });


};