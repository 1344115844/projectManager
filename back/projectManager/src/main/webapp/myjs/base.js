/**
 *@author Veng Su
 *@date 2018/4/15 11:00
 *方法作用：展示图片
 **/
function showImg(path) {
    layer_show("showImg",path);
}
/**
 *@author Veng Su 2018/4/17 21:49
 *方法作用：根据filepath和url下载文件，url为接口地址，ajax模拟表单下载文件
 **/
function downloadFileByForm(filepath,url) {
    console.log("ajaxDownloadSynchronized");
    var url = url;

    var form = $("<form></form>").attr("action", url).attr("method", "post");
    form.append($("<input></input>").attr("type", "hidden").attr("name", "filepath").attr("value", filepath));
    form.appendTo('body').submit().remove();
}
/**
 *@author Veng Su 2018/4/17 22:15
 *方法作用：校验project的funds字段是否为数字
 **/
function validateFund(){
    var reg = new RegExp("^[0-9]+(.[0-9]{1,4})?$");
    var obj = document.getElementById("funds");
    if(!reg.test(obj.value)){
        layer.msg("请输入带4位数字!");
    }
    if(!/^[0-9]+(.[0-9]{1,4})?$/.test(obj.value)){
        layer.msg("请输入带4位数字!");
    }
}