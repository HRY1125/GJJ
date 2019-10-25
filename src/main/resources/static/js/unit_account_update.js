window.onload=function(){


    layui.use('form', function(){
        var form = layui.form;

    });

    $(function () {
        var data = "3";
        $.ajax({
            type: "POST",
            async: false,
            url: "../account/selectAccountByUnitRegisterId",
            data: {"unitRegisterId": "3"},
            dataType: "json",
            success: function (data) {
                $.each(data, function (index, values) {// 解析出data对应的Object数组

                    if (index === "businessKind") {

                        if (values === "住房公积金") {

                            $("#gjj").attr("checked", "checked");
                            alert(values);
                        } else if (values === "住房补贴") {
                            $("#bt").attr("checked", "checked");
                        } else if (values === "住房基金") {
                            $("#jj").attr("checked", "checked");
                        } else if (values === "住房维修基金") {
                            $("#wx").attr("checked", "checked");
                        }
                    }
                    else if (index === "capitalSource") {
                        //alert("values");
                        if (values === "单位自筹") {
                            $("#Dwzc").attr("checked", "checked");
                        } else if (values === "财政拨款") {
                            $("#Czbk").attr("checked", "checked");
                        } else if (values === "财政拨款和单位自筹") {
                            $("#DwzcHeCzbk").attr("checked", "checked");
                        }
                    }
                    else if (index === "isSecondAssist") {
                        //alert("values");
                        if (values === "是") {
                            $("#KaiTong").attr("checked", "checked");
                        } else if (values === "否") {
                            $("#BuKaiTong").attr("checked", "checked");
                        }
                    }
                    else if (index === "allocateUnit") {
                        //alert("values");
                        if (values === "市财政") {
                            $("#Scz").attr("checked", "checked");
                        } else if (values === "区县财政") {
                            $("#QXcz").attr("checked", "checked");
                        }
                    }
                    if (index === "yearListRatify") {
                        //alert("values");
                        if (values === "1") {
                            $("#1yue").attr("checked", "checked");
                        } else if (values === "7") {
                            $("#7yue").attr("checked", "checked");
                        }
                    }
                    else if (index === "isMonthConfirm") {
                        //alert("values");
                        if (values === "1") {
                            $("#yesIsMonthConfirm").attr("checked", "checked");
                        } else if (values === "7") {
                            $("#noIsMonthConfirm").attr("checked", "checked");
                        }
                    }
                    else if (index === "isAcceptService") {
                        // alert("values");
                        if (values === "1") {
                            $("#yesIsAcceptService").attr("checked", "checked");
                        } else if (values === "7") {
                            $("#noIsAcceptService").attr("checked", "checked");
                        }
                    }
                    else if (index === "payMethod") {
                        // alert("values");
                        if (values === "委托收款") {
                            $("#WTSK").attr("checked", "checked");
                        } else if (values === "主动汇款") {
                            $("#ZDHK").attr("checked", "checked");
                        }
                        else if (values === "现金（刷卡）") {
                            $("#XJSK").attr("checked", "checked");
                        }
                        else if (values === "财政统发") {
                            $("#CZTF").attr("checked", "checked");
                        }
                        else if (values === "转账交款") {
                            $("#ZZJK").attr("checked", "checked");
                        }
                        else if (values === "在线支付") {
                            $("#ZXZF").attr("checked", "checked");
                        }
                    }
                    else if (index === "agentDepartment") {
                        $("#YWJBBM").val(values);
                    }
                    else if (index === "unitDepositeRatio") {
                        $("#danweibili").val(values);
                    }
                    else if (index === "unitPhone") {
                        $("#LXDH").val(values);
                    }
                    else if (index === "unitName") {
                        $("#unitName").val(values);
                    }

                });


            },
            error: function (data) {
                alert("有错了");
            }
        });

        $("#ipt_unitId").blur(function () {
            var unitId = $("#ipt_unitId").val();
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=UTF-8",
                url: "",
                data: unitId,
                dataType: "json",
                success: function (result) {
                    $("#unitName").val(result);
                },
                error: function (result) {

                }
            });

        });
    });
};
