// 预览图片
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