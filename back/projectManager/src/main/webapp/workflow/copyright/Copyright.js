

function getData() {
    // $.ajax({
    //     type: "POST",
    //     url: "/copyright/selectByUserId.do",
    //     success: function (data) {
    //         var data = JSON.parse(data);
    //         display(data.data.list);
    //         var setTotalCount = data.data.total;//总条数
    //         var startNumber = data.data.pageNum;//当前页数
    //         var totalPages = data.data.navigatepageNums.length;//总页数
    //         $('#box').paging({
    //             initPageNo: startNumber, // 初始页码
    //             totalPages: totalPages, //总页数
    //             totalCount: '合计' + setTotalCount + '条数据', // 条目总数
    //             slideSpeed: 600, // 缓动速度。单位毫秒
    //             jump: true, //是否支持跳转
    //             callback: function(page) { // 回调函数
    //                 console.log(page);
    //             }
    //         });
    //     }
    // });
}

// function display(data) {
//     var str = "";
//     var tbody = window.document.getElementById("tbody");
//     var index =0;
//     for (i in data) {
//         // var overTime =FormatDateTime(data[i].overTime);
//         // var beginTime =FormatDateTime(data[i].beginTime);
//         var awardTime =FormatDateTime(data[i].awardTime);
//         index=parseInt(i)+1;
//         str += "<tr class='text-c'>" +
//             "<td name='caonima' width='25'><input type='checkbox' ></td>" +
//             "<td name='id' width='40'>" + index + "</td>" +
//             "<td name='rightName'width='150'>" + data[i].rightName + "</td>" +
//             "<td name='rank' width='130'>" +  data[i].rank + "</td>" +
//             "<td name='awardTime' width='100'>" + awardTime + "</td>" +
//             "<td name='rightNum' width='100'>" + data[i].rightNum + "</td>" +
//             "<td ><button  class='btn btn-primary radius ' value='"+data[i].copyId+"' onclick="+"jumpEdit(this.value)"+">编辑</button>" +
//             "<button class=' btn btn-danger radius ' value='"+data[i].copyId+"' onclick="+"jumpDelete(this.value)"+">删除</button></td>"+
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
    var url="/copyright/edit?id="+id;

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
            url:"/copyright/delete.do",
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
function copyright_add(title, url, w, h) {
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

    var rightName=$("#rightName").val();
    var awardTime =$("#awardTime").val();
    awardTime=convertDateFromString(awardTime);

    var rank=$("#rank").val();
    var rightNum=$("#rightNum").val();



    $.ajax({
        type:"POST",
        url: "/copyright/uploadAttachment.do",
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
                url:"/copyright/add.do",
                data:{
                    "rightName":rightName, "rank":rank, "awardTime":awardTime, "rightNum":rightNum,
                    "fileId":fileId
                },
                success: function (data) {
                    var user=JSON.parse(data);
                    if (user.status ==200){
                        alert(user.msg);
                        window.parent.location.replace("/copyright/list");
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
    var copyId=parseInt(data['id']);
    $.ajax({
        type:"POST",
        url:"/copyright/selectById.do",
        data:{"copyId":copyId},
        success:function (data) {
            var data = JSON.parse(data);
            $("#copyId").val(data.data.copyId);
            $("#rightName").val(data.data.rightName);
            $("#rank").val(data.data.rank);


            var awardTime=FormatDateTime(data.data.awardTime);
            $("#awardTime").val(awardTime);

            $("#rightNum").val(data.data.rightNum);
        }
    });
}

function update() {

    //设置data数据
    var copyId=$("#copyId").val();
    copyId=parseInt(copyId);

    var upload_file = document.getElementById("file").files[0];
    var formFile = new FormData();
    formFile.append("upload_file", upload_file);
    var data = formFile;

    var rightName=$("#rightName").val();
    var awardTime =$("#awardTime").val();
    awardTime=convertDateFromString(awardTime);

    var rank=$("#rank").val();
    var rightNum=$("#rightNum").val();

    var fileId=null;
    //查看upload_file是否为空
    if(upload_file!=null) {
        //不为空重新上传，拿到返回的fileid
        $.ajax({
            type:"POST",
            url: "/copyright/uploadAttachment.do",
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
                    url:"/copyright/update.do",
                    data:{
                        "copyId":copyId,
                        "rightName":rightName, "rank":rank, "awardTime":awardTime, "rightNum":rightNum,
                        "fileId":fileId
                    },
                    success: function (data) {
                        var user=JSON.parse(data);
                        if (user.status ==200){
                            alert(user.msg);
                            window.parent.location.replace("/copyright/list");
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
            url:"/copyright/update.do",
            data:{
                "copyId":copyId,
                "rightName":rightName, "rank":rank, "awardTime":awardTime, "rightNum":rightNum,
                "fileId":fileId
            },
            success: function (data) {
                var user=JSON.parse(data);
                if (user.status ==200){
                    alert(user.msg);
                    window.parent.location.replace("/copyright/list");
                }else {
                    layer.msg(user.msg, {icon: 2, time: 2000});
                }
            }
        });
    }
}