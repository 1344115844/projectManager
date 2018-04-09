

function getData() {
    // $.ajax({
    //     type: "POST",
    //     url: "/study/selectByUserId.do",
    //     success: function (data) {
    //         var data = JSON.parse(data);
    //         display(data.data.list);
    //     }
    // });
}

// function display(data) {
//     var str = "";
//     var tbody = window.document.getElementById("tbody");
//     var index =0;
//     for (i in data) {
//         var beginTime =FormatDateTime(data[i].beginTime );
//         var overTime =FormatDateTime(data[i].overTime);
//         index=parseInt(i)+1;
//         str += "<tr class='text-c'>" +
//             "<td name='caonima' width='25'><input type='checkbox' ></td>" +
//             "<td name='id' width='40'>" + index + "</td>" +
//             "<td name='beginTime'width='150'>" + beginTime + "</td>" +
//             "<td name='overTime' width='130'>" + overTime + "</td>" +
//             "<td name='studyForm' width='100'>" + data[i].school + "</td>" +
//             "<td name='studyForm' width='100'>" + data[i].studyContent + "</td>" +
//             "<td ><button  class='btn btn-primary radius ' value='"+data[i].stuId+"' onclick="+"jumpEdit(this.value)"+">编辑</button>" +
//             "<button class=' btn btn-danger radius ' value='"+data[i].stuId+"' onclick="+"jumpDelete(this.value)"+">删除</button></td>"+
//             "</tr>";
//     }
//
//     tbody.innerHTML = str;
// }

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：跳转编辑页面
 **/
function jumpEdit(id) {
    var url="/study/edit?id="+id;

    layer_show('修改', url);
}

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：删除记录
 **/
function jumpDelete(id) {
    var stuId=parseInt(id);
    layer.confirm('确认要删除吗？',function () {
        $.ajax({
            type:"POST",
            url:"/study/delete.do",
            data:{"stuId":stuId},
            success:function (data) {
                data=JSON.parse(data);
                if(data.status==200){
                    layer.msg(data.msg, {icon: 1, time: 3000});

                }else {
                    layer.msg(data.msg, {icon: 2, time: 3000});
                }
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
function study_add(title, url, w, h) {
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

    var school=$("#school").val();
    var studyContent=$("#studyContent").val();

    var beginTime=$("#beginTime").val();
    beginTime=convertDateFromString(beginTime);
    var overTime=$("#overTime").val();
    overTime=convertDateFromString(overTime);


    $.ajax({
        type:"POST",
        url: "/study/uploadAttachment.do",
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
                url:"/study/add.do",
                data:{
                    "school":school, "beginTime":beginTime, "overTime":overTime, "studyContent":studyContent,
                    "fileId":fileId
                },
                success: function (data) {
                    var user=JSON.parse(data);
                    if (user.status ==200){
                        alert(user.msg);
                        window.parent.location.replace("/study/list");
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
    var stuId=parseInt(data['id']);
    $.ajax({
        type:"POST",
        url:"/study/selectById.do",
        data:{"stuId":stuId},
        success:function (data) {
            var data = JSON.parse(data);
            $("#stuId").val(data.data.stuId);

            $("#school").val(data.data.school);
            $("#studyContent").val(data.data.studyContent);

            var beginTime=FormatDateTime(data.data.beginTime);
            $("#beginTime").val(beginTime);
            var overTime=FormatDateTime(data.data.overTime);
            $("#overTime").val(overTime);


        }
    });
}

function update() {

    //设置data数据
    var stuId=$("#stuId").val();
    stuId=parseInt(stuId);

    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var school=$("#school").val();
    var studyContent=$("#studyContent").val();
    var beginTime=$("#beginTime").val();
    beginTime=convertDateFromString(beginTime);
    var overTime=$("#overTime").val();
    overTime=convertDateFromString(overTime);

    var fileId=null;
    //查看upload_file是否为空
    if(upload_file!=null) {
        //不为空重新上传，拿到返回的fileid
        $.ajax({
            type:"POST",
            url: "/study/uploadAttachment.do",
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
                    url:"/study/update.do",
                    data:{
                        "stuId":stuId,
                        "school":school, "beginTime":beginTime, "overTime":overTime, "studyContent":studyContent,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/study/list");
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
            url:"/study/update.do",
            data:{
                "stuId":stuId,
                "school":school, "beginTime":beginTime, "overTime":overTime, "studyContent":studyContent,
                "fileId":fileId
            },
            success: function (data) {
                var user=JSON.parse(data);
                if (user.status ==200){
                    alert(user.msg);
                    window.parent.location.replace("/study/list");
                }else {
                    layer.msg(user.msg, {icon: 2, time: 2000});
                }
            }
        });
    }
}
