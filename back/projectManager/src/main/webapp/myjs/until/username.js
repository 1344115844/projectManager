/**
 *@author Veng Su
 *@date 2018/4/11 23:17
 *方法作用：获取用户名并设置用户名
 **/
function getUsername() {
    $.ajax({
        type:"POST",
        url:"/user/getUsername",
        success:function (data) {
            data=JSON.parse(data);

            $("#username").html(data.data);
        }
    });
}
