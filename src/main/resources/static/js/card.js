window.onload=function(){

    layui.use(['table','form','layer'], function () {
        var table = layui.table;
        var form = layui.form;
        var layer = layui.layer;

        $("#ipt_ur").blur(function () {

            table.render({
                elem: '#employ'
                ,height: 500
                ,url: ''
                ,page: true
                ,cols: [[ //表头
                    /*{field: 'NO.', title: '序号', width:80}
                    ,*/{field: 'employeeId', title: '职工编号', width:135}
                    ,{field: 'employeeName', title: '姓名', width:135, edit:'text'}
                    ,{field: 'employeePapersName', title: '证件名称', width:135, edit:'text'}
                    ,{field: 'employeePapersNum', title: '证件号码', width: 180, edit:'text'}
                    ,{field: 'departmentName', title: '所属部门', width: 135, edit:'text'}
                    ,{field: 'employeeCardRegistStatus', title: '办理状态', width: 135, edit:'text'}
                ]]
            });
        });

    });

}