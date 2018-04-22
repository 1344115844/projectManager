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

//上传前预览图片
function previewImg(file, imgId){
    if(file.value==""){
        return;
    }
    var img = document.getElementById(imgId);
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.readAsDataURL(file.files[0]);
        reader.onload = function(evt){
            var reg = /^data:base64,/;
            var res = evt.target.result;
            if(reg.test(res)){
                res = res.replace(reg, "data:"+file.files[0].type+";base64,");
            }
            img.src = res;
            s = res;
        };
    } else {
        img.src = file.value;
    }
}
/**
 *@author Veng Su
 *@date 2018/4/11 23:17
 *方法作用：获取用户名并设置用户名
 **/
function getUsername(url) {
    var url =url
    $.ajax({
        type:"POST",
        url:url,
        success:function (data) {
            data=JSON.parse(data);

            $("#username").html(data.data);
        }
    });
}