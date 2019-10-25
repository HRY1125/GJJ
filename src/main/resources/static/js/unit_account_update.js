window.onload=function(){


    layui.use('form', function(){
        var form = layui.form;

    });

    $(function () {
        $("#ipt_unitId").blur(function () {
            var unitRegisterId = $("#ipt_unitId").val();
            $.ajax({
                type : "POST",
                contentType: "application/json;charset=UTF-8",
                url : "/sys/findURId",
                data : unitRegisterId,
                dataType : "json",
                success : function(result) {
                    $("#unitName").val(result.unitName);
                }
            });
            $.ajax({
                type: "POST",
                //async: false,
                url: "/account/selectAccountByUnitRegisterId",
                data: {"unitRegisterId": unitRegisterId},
                dataType: "json",
                success: function (data) {
                    $.each(data, function (index, values) {// 解析出data对应的Object数组

                        if (index === "businessKind") {

                            if (values === "住房公积金") {

                                $("#gjj").attr("checked", "checked");
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
                            if (values === 1) {
                                $("#1yue").attr("checked", "checked");
                            } else if (values === 7) {
                                $("#7yue").attr("checked", "checked");
                            }
                        }
                        else if (index === "isMonthConfirm") {
                            //alert("values");
                            if (values === "是") {
                                $("#yesIsMonthConfirm").attr("checked", "checked");
                            } else if (values === "否") {
                                $("#noIsMonthConfirm").attr("checked", "checked");
                            }
                        }
                        else if (index === "isAcceptService") {
                            // alert("values");
                            if (values === "是") {
                                $("#yesIsAcceptService").attr("checked", "checked");
                            } else if (values === "否") {
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
                        else if (index === "payDay"){

                            if(values === 1){
                                $("#payDay1").attr("selected", "selected");
                            }else if (values === 2) {
                                $("#payDay2").attr("selected", "selected");
                            }else if (values === 3) {
                                $("#payDay3").attr("selected", "selected");
                            }else if (values === 4) {
                                $("#payDay4").attr("selected", "selected");
                            }else if (values === 5) {
                                $("#payDay5").attr("selected", "selected");
                            }else if (values === 6) {
                                $("#payDay6").attr("selected", "selected");
                            }else if (values === 7) {
                                $("#payDay7").attr("selected", "selected");
                            }else if (values === 8) {
                                $("#payDay8").attr("selected", "selected");
                            }else if (values === 9) {
                                $("#payDay9").attr("selected", "selected");
                            }else if (values === 10) {
                                $("#payDay10").attr("selected", "selected");
                            }else if (values === 11) {
                                $("#payDay11").attr("selected", "selected");
                            }else if (values === 12) {
                                $("#payDay12").attr("selected", "selected");
                            }else if (values === 13) {
                                $("#payDay13").attr("selected", "selected");
                            }else if (values === 14) {
                                $("#payDay14").attr("selected", "selected");
                            }else if (values === 15) {
                                $("#payDay15").attr("selected", "selected");
                            }else if (values === 16) {
                                $("#payDay16").attr("selected", "selected");
                            }else if (values === 17) {
                                $("#payDay17").attr("selected", "selected");
                            }else if (values === 18) {
                                $("#payDay18").attr("selected", "selected");
                            }else if (values === 19) {
                                $("#payDay19").attr("selected", "selected");
                            }else if (values === 20) {
                                $("#payDay20").attr("selected", "selected");
                            }else if (values === 21) {
                                $("#payDay21").attr("selected", "selected");
                            }else if (values === 22) {
                                $("#payDay22").attr("selected", "selected");
                            }else if (values === 23) {
                                $("#payDay23").attr("selected", "selected");
                            }else if (values === 24) {
                                $("#payDay24").attr("selected", "selected");
                            }else if (values === 25) {
                                $("#payDay25").attr("selected", "selected");
                            }else if (values === 26) {
                                $("#payDay26").attr("selected", "selected");
                            }else if (values === 27) {
                                $("#payDay27").attr("selected", "selected");
                            }else if (values === 28) {
                                $("#payDay28").attr("selected", "selected");
                            }else if (values === 29) {
                                $("#payDay29").attr("selected", "selected");
                            }else if (values === 30) {
                                $("#payDay30").attr("selected", "selected");
                            }else if (values === 31) {
                                $("#payDay31").attr("selected", "selected");
                            }
                        }
                        else if (index === "firstRemitMonth"){

                            if(values === 1){
                                $("#firstRemitMonth1").attr("selected", "selected");
                            }else if (values === 2) {
                                $("#firstRemitMonth2").attr("selected", "selected");
                            }else if (values === 3) {
                                $("#firstRemitMonth3").attr("selected", "selected");
                            }else if (values === 4) {
                                $("#firstRemitMonth4").attr("selected", "selected");
                            }else if (values === 5) {
                                $("#firstRemitMonth5").attr("selected", "selected");
                            }else if (values === 6) {
                                $("#firstRemitMonth6").attr("selected", "selected");
                            }else if (values === 7) {
                                $("#firstRemitMonth7").attr("selected", "selected");
                            }else if (values === 8) {
                                $("#firstRemitMonth8").attr("selected", "selected");
                            }else if (values === 9) {
                                $("#firstRemitMonth9").attr("selected", "selected");
                            }else if (values === 10) {
                                $("#firstRemitMonth10").attr("selected", "selected");
                            }else if (values === 11) {
                                $("#firstRemitMonth11").attr("selected", "selected");
                            }else if (values === 12) {
                                $("#firstRemitMonth12").attr("selected", "selected");
                            }else if (values === 13) {
                                $("#firstRemitMonth13").attr("selected", "selected");
                            }
                        }
                        else if (index === "accountId") {
                            $("#accountId").val(values);
                        }

                    });


                },
                error: function (data) {
                    alert("有错了");
                }
            });
        });
    });
};
