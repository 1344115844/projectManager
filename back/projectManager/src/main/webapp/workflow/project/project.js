

function getData() {
    $.ajax({
        type: "POST",
        url: "/project/selectByUserId.do",
        success: function (data) {
            var data = JSON.parse(data);
            display(data.data.list);
            var setTotalCount = data.data.total;//总条数
            var startNumber = data.data.pageNum;//当前页数
            var totalPages = data.data.navigatepageNums.length;//总页数
            $('#box').paging({
                initPageNo: startNumber, // 初始页码
                totalPages: totalPages, //总页数
                totalCount: '合计' + setTotalCount + '条数据', // 条目总数
                slideSpeed: 600, // 缓动速度。单位毫秒
                jump: true, //是否支持跳转
                callback: function(page) { // 回调函数
                    console.log(page);
                }
            });
        }
    });
}

function display(data) {
    var str = "";
    var tbody = window.document.getElementById("tbody");
    var index =0;
    for (i in data) {
        var beginTime =FormatDateTime(data[i].beginTime );
        var overTime =FormatDateTime(data[i].overTime);
        index=parseInt(i)+1;
        str += "<tr class='text-c'>" +
            "<td name='caonima' width='25'><input type='checkbox' ></td>" +
            "<td name='id' width='40'>" + index + "</td>" +
            "<td name='projectName' width='100'>" + data[i].projectName + "</td>" +
            "<td name='projectNumber' width='100'>" + data[i].projectNumber + "</td>" +
            "<td name='projectSource' width='100'>" + data[i].projectSource + "</td>" +
            "<td name='beginTime'width='150'>" + beginTime + "</td>" +
            "<td name='overTime' width='130'>" + overTime + "</td>" +
            "<td name='funds' width='100'>" + data[i].funds + "</td>" +
            "<td name='level' width='100'>" + data[i].level + "</td>" +
            "<td name='isTeamwork' width='100'>" + data[i].isTeamwork + "</td>" +
            "<td name='state' width='100'>" + data[i].state + "</td>" +
            "<td name='projectDirector' width='100'>" + data[i].projectDirector + "</td>" +
            "<td ><button  class='btn btn-primary radius ' value='"+data[i].proId+"' onclick="+"jumpEdit(this.value)"+">编辑</button>" +
            "<button class=' btn btn-danger radius ' value='"+data[i].proId+"' onclick="+"jumpDelete(this.value)"+">删除</button></td>"+
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
    var url="/project/edit?id="+id;

    layer_show('修改', url);
}

/**
 *@author Veng Su
 *@date 2018/4/4 20:05
 *方法作用：删除记录
 **/
function jumpDelete(id) {
    var proId=parseInt(id);
    layer.confirm('确认要删除吗？',function () {
        $.ajax({
            type:"POST",
            url:"/project/delete.do",
            data:{"proId":proId},
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
function project_add(title, url, w, h) {
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

    var projectName="";
    projectName=$("#projectName").val();
    var projectNumber="";projectNumber=$("#projectNumber").val();
    var projectSource="";projectSource=$("#projectSource").val();
    var funds="";funds=$("#funds").val();
    funds=parseFloat(funds);

    var isTeamwork="";isTeamwork=$('input[name="isTeamwork"]:checked').val();
    isTeamwork=parseInt(isTeamwork);
    var state="";state=$('#state option:selected').text();
    var projectDirector="";projectDirector=$('#projectDirector option:selected').text();
    var level="";level=$('input[name="level"]:checked').val();

    var beginTime ="";beginTime=$("#beginTime").val();
    beginTime=convertDateFromString(beginTime);
    var overTime ="";overTime=$("#overTime").val();
    overTime=convertDateFromString(overTime);

    $.ajax({
        type:"POST",
        url: "/project/uploadAttachment.do",
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
                url:"/project/add.do",
                data:{
                    "projectName":projectName, "projectNumber":projectNumber, "projectSource":projectSource, "funds":funds,
                    "level":level,"isTeamwork":isTeamwork,"state":state,"projectDirector":projectDirector,"beginTime":beginTime,"overTime":overTime,
                    "fileId":fileId
                },
                success: function (data) {
                    var user=JSON.parse(data);
                    if (user.status ==200){
                        alert(user.msg);
                        window.parent.location.replace("/project/list");
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

function findmember() {
    $.ajax({
        type:"POST",
        url:"/user/all",
        success:function (data) {
            data=JSON.parse(data);
            data=data.data;
            var str="<option value=\"\" selected>选择课题负责人</option>";
            for (i in data){
                str+="<option value='" +data[i].userId+"' >"+data[i].name+"</option>"
            }
            $("#projectDirector").html(str);

        }
    });
}
function selectData() {
    var data = parseUrl();
    var proId=parseInt(data['id']);
    $.ajax({
        type:"POST",
        url:"/project/selectById.do",
        data:{"proId":proId},
        success:function (data) {
            var data = JSON.parse(data);
            $("#proId").val(data.data.proId);
            $("#projectName").val(data.data.projectName);
            $("#projectNumber").val(data.data.projectNumber);
            $("#projectSource").val(data.data.projectSource);
            $("#funds").val(data.data.funds);
            $("#level").val(data.data.level);
            $("#isTeamwork").val(data.data.isTeamwork);
            $("#state").val(data.data.state);
            $("#projectDirector").val(data.data.projectDirector);
            var wang = data.data.projectDirector;
            // $("#projectDirector").val("ceshi1");
            $("#state").val(data.data.state);

            var beginTime=FormatDateTime(data.data.beginTime);
            $("#beginTime").val(beginTime);
            var overTime=FormatDateTime(data.data.overTime);
            $("#overTime").val(overTime);

            $.ajax({
                type:"POST",
                url:"/user/all",
                success:function (data) {
                    data=JSON.parse(data);
                    data=data.data;
                    var str="<option value=\"\" >选择课题负责人</option>";
                    for (i in data){
                        if(wang == data[i].name){
                            str+="<option value='" +data[i].userId+"' selected='selected'>"+data[i].name+"</option>";
                        }else{
                            str+="<option value='" +data[i].userId+"' >"+data[i].name+"</option>";
                        }
                    }
                    $("#projectDirector").html(str);
                }
            });
        }
    });


// function selectData() {
//     var data = parseUrl();
//     var proId=parseInt(data['id']);
//     $.ajax({
//         type:"POST",
//         url:"/user/all",
//         success:function (data) {
//             data=JSON.parse(data);
//             data=data.data;
//             var wang = data.data.projectDirector;
//
//             var str="<option value=\"\" >选择课题负责人</option>";
//             for (i in data){
//                 if(wang == data[i].name){
//                     str+="<option value='" +data[i].userId+"' selected='selected'>"+data[i].name+"</option>";
//                 }else{
//                     str+="<option value='" +data[i].userId+"' >"+data[i].name+"</option>";
//                 }
//             }
//             $("#projectDirector").html(str);
//             $.ajax({
//                 type:"POST",
//                 url:"/project/selectById.do",
//                 data:{"proId":proId},
//                 success:function (data) {
//                     var data = JSON.parse(data);
//                     $("#proId").val(data.data.proId);
//                     $("#projectName").val(data.data.projectName);
//                     $("#projectNumber").val(data.data.projectNumber);
//                     $("#projectSource").val(data.data.projectSource);
//                     $("#funds").val(data.data.funds);
//                     $("#level").val(data.data.level);
//                     $("#isTeamwork").val(data.data.isTeamwork);
//                     $("#state").val(data.data.state);
//                     $("#projectDirector").val(data.data.projectDirector);
//                     // $("#projectDirector").val("ceshi1");
//                     $("#state").val(data.data.state);
//
//                     var beginTime=FormatDateTime(data.data.beginTime);
//                     $("#beginTime").val(beginTime);
//                     var overTime=FormatDateTime(data.data.overTime);
//                     $("#overTime").val(overTime);
//                 }
//             });
//
//         }
//     });



}

function update() {

    //设置data数据
    var proId=$("#proId").val();
    proId=parseInt(proId);

    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var projectName=$("#projectName").val();
    var projectNumber=$("#projectNumber").val();
    var projectSource=$("#projectSource").val();
    var funds=$("#funds").val();
    funds=parseFloat(funds);
    var isTeamwork=$('#isTeamwork option:selected').val();
    isTeamwork=parseInt(isTeamwork);

    var state=$('#state option:selected').val();
    var projectDirector="";projectDirector=$('#projectDirector option:selected').text();
    var level=$('#level option:selected').val();

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
            url: "/project/uploadAttachment.do",
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
                    url:"/project/update.do",
                    data:{
                        "proId":proId,
                        "projectName":projectName, "projectNumber":projectNumber, "projectSource":projectSource, "funds":funds,
                        "level":level,"isTeamwork":isTeamwork,"state":state,"projectDirector":projectDirector,"beginTime":beginTime,"overTime":overTime,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/project/list");
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
            url:"/project/update.do",
            data:{
                "proId":proId,
                "projectName":projectName, "projectNumber":projectNumber, "projectSource":projectSource, "funds":funds,
                "level":level,"isTeamwork":isTeamwork,"state":state,"projectDirector":projectDirector,"beginTime":beginTime,"overTime":overTime,
                "fileId":fileId
            },
            success: function (data) {
                var user=JSON.parse(data);
                if (user.status ==200){
                    alert(user.msg);
                    window.parent.location.replace("/project/list");
                }else {
                    layer.msg(user.msg, {icon: 2, time: 2000});
                }
            }
        });
    }
}

