$(document).ready(function () {

    $('.date-picker').datepicker({
        minView: "day", //  选择时间时，最小可以选择到那层；默认是‘hour’也可用0表示
        language: 'zh-CN', // 语言
        autoclose: true, //  true:选择时间后窗口自动关闭
        format: 'yyyy-mm-dd', // 文本框时间格式，设置为0,最后时间格式为2017-03-23 17:00:00
        todayBtn: true, // 如果此值为true 或 "linked"，则在日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
        // 窗口可选时间从今天开始
        endDate: new Date()
    });

    $(".dayTest").click(function () {
        $(".date-picker").remove();
        $(".input-group-addon").remove();
        var $leftInput = $('<input name="startDate" class="form-control date-picker form-control-left" style="float: left;display: block;width: 100px;height: 25px;z-index: 5;"/>');
        $(".input-group").append($leftInput);
        var $inputGroupAddon = $('<span class="input-group-addon" style="float: left;display: block;width: 10px;height: 25px;z-index: 5;"></span>');
        $(".input-group").append($inputGroupAddon);
        var $rightInput = $('<input name="endDate" class="form-control date-picker form-control-right" style="float: left;display: block;width: 100px;height: 25px;margin-top: 0px;z-index: 5;"/>');
        $(".input-group").append($rightInput);
        $('.date-picker').datepicker({
            minView: "day", //  选择时间时，最小可以选择到那层；默认是‘hour’也可用0表示
            language: 'zh-CN', // 语言
            autoclose: true, //  true:选择时间后窗口自动关闭
            format: 'yyyy-mm-dd', // 文本框时间格式，设置为0,最后时间格式为2017-03-23 17:00:00
            todayBtn: true, // 如果此值为true 或 "linked"，则在日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
            // 窗口可选时间从今天开始
            endDate: new Date()
        });
    });

    $(".monthTest").click(function () {
        $(".date-picker").remove();
        $(".input-group-addon").remove();
        var $leftInput = $('<input name="startDate" class="form-control date-picker form-control-left" style="float: left;display: block;width: 100px;height: 25px;z-index: 5;"/>');
        $(".input-group").append($leftInput);
        var $inputGroupAddon = $('<span class="input-group-addon" style="float: left;display: block;width: 10px;height: 25px;z-index: 5;"></span>');
        $(".input-group").append($inputGroupAddon);
        var $rightInput = $('<input name="endDate" class="form-control date-picker form-control-right" style="float: left;display: block;width: 100px;height: 25px;margin-top: 0px;z-index: 5;"/>');
        $(".input-group").append($rightInput);
        $('.date-picker').datepicker({
            language: "zh-CN",
            autoclose: true,
            format: "yyyy-mm",
            minViewMode: 1,
            endDate: new Date()
        });
    });

    $(".yearTest").click(function () {
        $(".date-picker").remove();
        $(".input-group-addon").remove();
        var $leftInput = $('<input name="startDate" class="form-control date-picker form-control-left" style="float: left;display: block;width: 100px;height: 25px;z-index: 5;"/>');
        $(".input-group").append($leftInput);
        var $inputGroupAddon = $('<span class="input-group-addon" style="float: left;display: block;width: 10px;height: 25px;z-index: 5;"></span>');
        $(".input-group").append($inputGroupAddon);
        var $rightInput = $('<input name="endDate" class="form-control date-picker form-control-right" style="float: left;display: block;width: 100px;height: 25px;margin-top: 0px;z-index: 5;"/>');
        $(".input-group").append($rightInput);
        $(".date-picker").datepicker({
            language: "zh-CN",
            todayHighlight: true,
            format: 'yyyy-mm',
            autoclose: true,
            startView: 'years',
            maxViewMode:'years',
            minViewMode:'years',
            endDate: new Date()
        });
    });

})
