window.onload=function () {

    layui.use(['table','layer'],function () {
        var table = layui.table;
        var layer = layui.layer;

        var unitId = $("#unitId").val();
        table.render({
            elem: '#employ'
            ,height: 500
            ,url: '/SecondAssist/selectSecondAssistByUnitId?unitId='+unitId
            ,page: true
            ,toolbar: '#toolbar'
            ,cols: [[ //表头
                /*{field: 'NO.', title: '序号', width:80}
                ,*/{field: '', title: '部门编号', width:135}
                ,{field: 'employeeName', title: '部门名称', width:135, edit:'text'}
                ,{field: 'employeePapersName', title: '部门代码', width:135, edit:'text'}
                ,{field: '', title: '保存/删除', width: 110, fixed: 'right'
                    , toolbar:'<div><div class="layui-btn-group">\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="save">\n' +
                        '    <i class="layui-icon">&#xe61f;</i>\n' +
                        '  </button>\n' +
                        '  <button type="button" class="layui-btn layui-btn-sm" lay-event="delete">\n' +
                        '    <i class="layui-icon">&#xe640;</i>\n' +
                        '  </button>\n' + '</div>' +
                        '</div>'}
            ]]
        });

    });

}