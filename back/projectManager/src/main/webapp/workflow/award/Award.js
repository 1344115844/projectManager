

function getData() {
    $.ajax({
        type: "POST",
        url: "/award/selectByUserId.do",
        success: function (data) {
            var data = JSON.parse(data);
            display(data.data.list, data.data.total);
        }
    });
}

function display(data, data1) {
    var total = "<strong >共有数据：" + data1 + "条</strong>";
    document.getElementById("total").innerHTML = total;
    var str = "";
    var tbody = window.document.getElementById("tbody");
    var index =0;
    for (i in data) {
        // var overTime =FormatDateTime(data[i].overTime);
        // var beginTime =FormatDateTime(data[i].beginTime);
        var awardTime =FormatDateTime(data[i].awardTime);
        index=parseInt(i)+1;
        str += "<tr class='text-c'>" +
            "<td name='caonima' width='25'><input type='checkbox' ></td>" +
            "<td name='id' width='40'>" + index + "</td>" +
            "<td name='projectName'width='150'>" + data[i].projectName + "</td>" +
            "<td name='awardName' width='130'>" +  data[i].awardName + "</td>" +
            "<td name='awardLevel' width='100'>" + data[i].awardLevel + "</td>" +
            "<td name='awardTime' width='100'>" + awardTime + "</td>" +
            "<td name='awardRank' width='100'>" + data[i].awardRank + "</td>" +
            "<td ><button  class='editAcad btn btn-primary radius ' value='"+data[i].awardId+"' onclick="+"jumpEdit(this.value)"+">编辑</button>" +
            "<button class='deleteAcad btn btn-danger radius ' value='"+data[i].awardId+"' onclick="+"jumpDelete(this.value)"+">删除</button></td>"+
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
    var url="/award/edit?id="+id;
    var w = '800';
    var h='800';
    layer_show('修改', url, w, h);
}

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：删除记录
 **/
function jumpDelete(id) {
    var awardId=parseInt(id);
    layer.confirm('确认要删除吗？',function () {
        $.ajax({
            type:"POST",
            url:"/award/delete.do",
            data:{"awardId":awardId},
            success:function (data) {
                data=JSON.parse(data);
                layer.msg(data.msg, {icon: 1, time: 1000});
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
function award_add(title, url, w, h) {
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

    var projectName=$("#projectName").val();
    var awardName=$("#awardName").val();
    var awardTime =$("#awardTime").val();
    awardTime=convertDateFromString(awardTime);

    var awardLevel=$("#awardLevel").val();
    var awardRank=$("#awardRank").val();


    $.ajax({
        type:"POST",
        url: "/award/uploadAttachment.do",
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
                url:"/award/add.do",
                data:{
                    "projectName":projectName, "awardName":awardName, "awardTime":awardTime, "awardLevel":awardLevel, "awardRank":awardRank,
                    "fileId":fileId
                },
                success: function (data) {
                    var user=JSON.parse(data);
                    if (user.status ==200){
                        alert(user.msg);
                        window.parent.location.replace("/award/list");
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
    var awardId=parseInt(data['id']);
    $.ajax({
        type:"POST",
        url:"/award/selectById.do",
        data:{"awardId":awardId},
        success:function (data) {
            var data = JSON.parse(data);
            $("#awardId").val(data.data.awardId);
            $("#projectName").val(data.data.projectName);
            $("#awardName").val(data.data.awardName);


            var awardTime=FormatDateTime(data.data.awardTime);
            $("#awardTime").val(awardTime);

            $("#awardLevel").val(data.data.awardLevel);
            $("#awardRank").val(data.data.awardRank);
        }
    });
}

function update() {

    //设置data数据
    var awardId=$("#awardId").val();
    awardId=parseInt(awardId);

    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var projectName=$("#projectName").val();
    var awardName=$("#awardName").val();
    var awardTime =$("#awardTime").val();
    awardTime=convertDateFromString(awardTime);

    var awardLevel=$("#awardLevel").val();
    var awardRank=$("#awardRank").val();

    var fileId=null;
    //查看upload_file是否为空
    if(upload_file!=null) {
        //不为空重新上传，拿到返回的fileid
        $.ajax({
            type:"POST",
            url: "/award/uploadAttachment.do",
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
                    url:"/award/update.do",
                    data:{
                        "awardId":awardId,
                        "projectName":projectName, "awardName":awardName, "awardTime":awardTime, "awardLevel":awardLevel, "awardRank":awardRank,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/award/list");
                        }else {
                            layer.msg(user.msg, {icon: 2, time: 2000});
                        }
                    }
                });
            }
        });
    }else {
        //更新academic表单
        $.ajax({
            type:"POST",
            url:"/award/update.do",
            data:{
                "awardId":awardId,
                "projectName":projectName, "awardName":awardName, "awardTime":awardTime, "awardLevel":awardLevel, "awardRank":awardRank,
                "fileId":fileId
            },
            success: function (data) {
                var user=JSON.parse(data);
                if (user.status ==200){
                    alert(user.msg);
                    window.parent.location.replace("/award/list");
                }else {
                    layer.msg(user.msg, {icon: 2, time: 2000});
                }
            }
        });
    }
}