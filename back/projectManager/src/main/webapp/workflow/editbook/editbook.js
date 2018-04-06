

function getData() {
    $.ajax({
        type: "POST",
        url: "/editbook/selectByUserId.do",
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
        var publishTime =FormatDateTime(data[i].publishTime);
        index=parseInt(i)+1;
        str += "<tr class='text-c'>" +
            "<td name='caonima' width='25'><input type='checkbox' ></td>" +
            "<td name='id' width='40'>" + index + "</td>" +
            "<td name='bookName'width='150'>" + data[i].bookName + "</td>" +
            "<td name='editRank' width='130'>" +  data[i].editRank + "</td>" +
            "<td name='publishTime' width='100'>" + publishTime + "</td>" +
            "<td name='isbn' width='100'>" + data[i].isbn + "</td>" +
            "<td name='publishUnit' width='100'>" + data[i].publishUnit + "</td>" +
            "<td name='byteNum' width='100'>" + data[i].byteNum + "</td>" +
            "<td ><button  class='btn btn-primary radius ' value='"+data[i].editId+"' onclick="+"jumpEdit(this.value)"+">编辑</button>" +
            "<button class=' btn btn-danger radius ' value='"+data[i].editId+"' onclick="+"jumpDelete(this.value)"+">删除</button></td>"+
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
    var url="/editbook/edit?id="+id;

    layer_show('修改', url);
}

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：删除记录
 **/
function jumpDelete(id) {
    var copyId=parseInt(id);
    layer.confirm('确认要删除吗？',function () {
        $.ajax({
            type:"POST",
            url:"/editbook/delete.do",
            data:{"copyId":copyId},
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
function editbook_add(title, url, w, h) {
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

    var bookName=$("#bookName").val();
    var isbn=$("#isbn").val();
    var publishUnit=$("#publishUnit").val();

    var byteNum=$("#byteNum").val();
    byteNum=parseInt(byteNum);

    var publishTime =$("#publishTime").val();
    publishTime=convertDateFromString(publishTime);

    var editRank=$('input[name="editRank"]:checked').val();



    $.ajax({
        type:"POST",
        url: "/editbook/uploadAttachment.do",
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
                url:"/editbook/add.do",
                data:{
                    "bookName":bookName, "isbn":isbn, "publishUnit":publishUnit, "byteNum":byteNum,
                    "publishTime":publishTime,"editRank":editRank,
                    "fileId":fileId
                },
                success: function (data) {
                    var user=JSON.parse(data);
                    if (user.status ==200){
                        alert(user.msg);
                        window.parent.location.replace("/editbook/list");
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
    var editId=parseInt(data['id']);
    $.ajax({
        type:"POST",
        url:"/editbook/selectById.do",
        data:{"editId":editId},
        success:function (data) {
            var data = JSON.parse(data);
            $("#editId").val(data.data.editId);
            $("#bookName").val(data.data.bookName);
            $("#isbn").val(data.data.isbn);
            $("#publishUnit").val(data.data.publishUnit);
            $("#byteNum").val(data.data.byteNum);
            $("#editRank").val(data.data.editRank);

            var publishTime=FormatDateTime(data.data.publishTime);
            $("#publishTime").val(publishTime);


        }
    });
}

function update() {

    //设置data数据
    var editId=$("#editId").val();
    editId=parseInt(editId);

    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var bookName=$("#bookName").val();
    var isbn=$("#isbn").val();
    var publishUnit=$("#publishUnit").val();

    var byteNum=$("#byteNum").val();
    byteNum=parseInt(byteNum);

    var publishTime =$("#publishTime").val();
    publishTime=convertDateFromString(publishTime);

    var editRank=$('input[name="editRank"]:checked').val();

    var fileId=null;
    //查看upload_file是否为空
    if(upload_file!=null) {
        //不为空重新上传，拿到返回的fileid
        $.ajax({
            type:"POST",
            url: "/editbook/uploadAttachment.do",
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
                    url:"/editbook/update.do",
                    data:{
                        "editId":editId,
                        "bookName":bookName, "isbn":isbn, "publishUnit":publishUnit, "byteNum":byteNum,
                        "publishTime":publishTime,"editRank":editRank,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/editbook/list");
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
                    url:"/editbook/update.do",
                    data:{
                        "editId":editId,
                        "bookName":bookName, "isbn":isbn, "publishUnit":publishUnit, "byteNum":byteNum,
                        "publishTime":publishTime,"editRank":editRank,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/editbook/list");
                        }else {
                            layer.msg(user.msg, {icon: 2, time: 2000});
                        }
                    }
                });
    }
}