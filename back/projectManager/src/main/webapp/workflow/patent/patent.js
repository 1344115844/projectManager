

function getData() {
    $.ajax({
        type: "POST",
        url: "/patent/selectByUserId.do",
        success: function (data) {
            var data = JSON.parse(data);
            display(data.data.list);
        }
    });
}

function display(data) {
    var str = "";
    var tbody = window.document.getElementById("tbody");
    var index =0;
    for (i in data) {
        index=parseInt(i)+1;
        str += "<tr class='text-c'>" +
            "<td name='caonima' width='25'><input type='checkbox' ></td>" +
            "<td name='id' width='40'>" + index + "</td>" +
            "<td name='patentTame'width='150'>" + data[i].patentTame + "</td>" +
            "<td name='patentRank' width='130'>" + data[i].patentRank + "</td>" +
            "<td name='authority' width='100'>" + data[i].authority + "</td>" +
            "<td name='patentForm' width='100'>" + data[i].patentForm + "</td>" +
            "<td name='registrationEnterprise' width='100'>" + data[i].registrationEnterprise + "</td>" +
            "<td name='patentNum' width='100'>" + data[i].patentNum + "</td>" +
            "<td ><button  class='btn btn-primary radius ' value='"+data[i].tentId+"' onclick="+"jumpEdit(this.value)"+">编辑</button>" +
            "<button class=' btn btn-danger radius ' value='"+data[i].tentId+"' onclick="+"jumpDelete(this.value)"+">删除</button></td>"+
            "</tr>";
    }

    tbody.innerHTML = str;
}

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：跳转编辑页面
 **/
function jumpEdit(id) {
    var url="/patent/edit?id="+id;

    layer_show('修改', url);
}

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：删除记录
 **/
function jumpDelete(id) {
    var tentId=parseInt(id);
    layer.confirm('确认要删除吗？',function () {
        $.ajax({
            type:"POST",
            url:"/patent/delete.do",
            data:{"tentId":tentId},
            success:function (data) {
                data=JSON.parse(data);
                layer.msg(data.msg, {icon: 1, time: 2000});
                getData();

            }
        });
    });
}

/**
 *@author Veng Su
 *@date 2018/4/5 9:58
 *方法作用：跳转add页面
 **/
function patent_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

/**
 *@author Veng Su
 *@date 2018/4/5 22:21
 *方法作用：add记录
 **/
function add() {
    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var patentTame=$("#patentTame").val();
    var patentRank=$("#patentRank").val();
    var authority =$("#authority").val();
    var patentForm =$("#patentForm").val();
    var registrationEnterprise =$("#registrationEnterprise").val();
    var patentNum =$("#patentNum").val();





    $.ajax({
        type:"POST",
        url: "/patent/uploadAttachment.do",
        data: data,
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false,
        success: function(data){
            data=JSON.parse(data);
            var fileId=data.data;
            fileId=parseInt(fileId);
            $.ajax({
                type:"POST",
                url:"/patent/add.do",
                data:{
                    "patentTame":patentTame, "patentRank":patentRank, "authority":authority, "patentForm":patentForm,
                    "registrationEnterprise":registrationEnterprise,"patentNum":patentNum,
                    "fileId":fileId
                },
                success: function (data) {
                    var user=JSON.parse(data);
                    if (user.status ==200){
                        alert(user.msg);
                        window.parent.location.replace("/patent/list");
                    }else {
                        layer.msg(user.msg, {icon: 2, time: 2000});
                    }
                }
            });
        },
        error:function () {
            layer.msg("必须上传证件",{icon: 3, time: 2000});
        }
    });
}


function selectData() {
    var data = parseUrl();
    var tentId=parseInt(data['id']);
    $.ajax({
        type:"POST",
        url:"/patent/selectById.do",
        data:{"tentId":tentId},
        success:function (data) {
            var data = JSON.parse(data);
            $("#tentId").val(data.data.tentId);
            $("#patentTame").val(data.data.patentTame);
            $("#authority").val(data.data.authority);
            $("#patentForm").val(data.data.patentForm);
            $("#registrationEnterprise").val(data.data.registrationEnterprise);
            $("#patentNum").val(data.data.patentNum);



        }
    });
}

function update() {

    //设置data数据
    var tentId=$("#tentId").val();
    tentId=parseInt(tentId);

    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var patentTame=$("#patentTame").val();
    var patentRank=$("#patentRank").val();
    var authority =$("#authority").val();
    var patentForm =$("#patentForm").val();
    var registrationEnterprise =$("#registrationEnterprise").val();
    var patentNum =$("#patentNum").val();

    var fileId=null;
    //查看upload_file是否为空
    if(upload_file!=null) {
        //不为空重新上传，拿到返回的fileid
        $.ajax({
            type:"POST",
            url: "/patent/uploadAttachment.do",
            data: data,
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false,
            success: function(data){
                data=JSON.parse(data);
                var fileId=data.data;
                fileId=parseInt(fileId);
                $.ajax({
                    type:"POST",
                    url:"/patent/update.do",
                    data:{
                        "tentId":tentId,
                        "patentTame":patentTame, "patentRank":patentRank, "authority":authority, "patentForm":patentForm,
                        "registrationEnterprise":registrationEnterprise,"patentNum":patentNum,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/patent/list");
                        }else {
                            layer.msg(user.msg, {icon: 2, time: 2000});
                        }
                    }
                });
            }
        });
    }else {

        $.ajax({
            type:"POST",
            url:"/patent/update.do",
            data:{
                "tentId":tentId,
                "patentTame":patentTame, "patentRank":patentRank, "authority":authority, "patentForm":patentForm,
                "registrationEnterprise":registrationEnterprise,"patentNum":patentNum,
                "fileId":fileId
            },
            success: function (data) {
                var user=JSON.parse(data);
                if (user.status ==200){
                    alert(user.msg);
                    window.parent.location.replace("/patent/list");
                }else {
                    layer.msg(user.msg, {icon: 2, time: 2000});
                }
            }
        });
    }
}