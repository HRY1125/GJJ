window.onload=function(){

    layui.use(['table','form'], function(){
        var table = layui.table;
        var form = layui.form;

        table.render({
            elem: '#employ'
            ,height: 400
            ,url: '/employee/selEmployeeAll1'
            ,page: true
            ,toolbar: '#toolbar'
            ,cols: [[ //表头
                {field: 'NO.', title: '序号', width:80}
                ,{field: 'employeeId', title: '职工编号', width:135, edit:'text'}
                ,{field: 'employeeName', title: '姓名', width:135, edit:'text'}
                ,{field: 'employeePapersName', title: '证件名称', width:135, edit:'text'}
                ,{field: 'employeeNationnality', title: '国别', width: 135, edit:'text'}
                ,{field: 'employeePapersNum', title: '证件号码', width: 180, edit:'text'}
                ,{field: 'score', title: '缴存基数', width: 135, edit:'text'}
                ,{field: 'classify', title: '单位月缴存额', width: 135, edit:'text'}
                ,{field: 'wealth', title: '个人月缴存额', width: 135, edit:'text'}
                ,{field: 'wealth', title: '月缴存额合计', width: 135, edit:'text'}
                ,{field: 'wealth', title: '二级管理辅助信息', width: 150, edit:'text'}
                ,{field: '', title: '保存/删除', width: 110, fixed: 'right', toolbar:'<div><div class="layui-btn-group">\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="save">\n' +
                        '    <i class="layui-icon">&#xe61f;</i>\n' +
                        '  </button>\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="delete">\n' +
                        '    <i class="layui-icon">&#xe640;</i>\n' +
                        '  </button>\n' + '</div></div>'}
            ]]
        });

        table.on('edit(edit)', function(obj){

            table.reload('employ',{
                height: 400
                ,url: '/employee/selEmployeeAll1'
                ,page: true
                ,toolbar: '#toolbar'
            });

            console.log(obj.value); //得到修改后的值
            console.log(obj.field); //当前编辑的字段名
            console.log(obj.data); //所在行的所有相关数据

        });

        /*form.verify({
            myVerify:function (value, item) { //value：表单的值、item：表单的DOM对象
                if(value==null){
                    return "不能为空";
                }
            }
        });*/

        //头工具栏监听
        table.on('toolbar(edit)', function(obj){
            var event = obj.event;
            if(event=='add'){
                console.log(form.val("unit"));
                var data = form.val("unit");
                if(data.unitRegisterId==null || data.unitRegisterId==''){
                    layer.msg("单位登记号不能为空");
                }
            }
        });
        
        //行工具栏监听
        table.on('tool(edit)',function (obj) {
            console.log(obj.data);
            console.log(obj.event);
            var data = obj.data;
            var event = obj.event;
            if(event=='save'){
                layer.msg(event);
            }else if(event=='delete'){
                layer.msg(event);
            }
        })

    });
};