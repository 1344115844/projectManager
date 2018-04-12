/**
 *@author Veng Su
 *@date 2018/4/5 11:48
 *方法作用：字符串转date对象
 **/
function convertDateFromString(dateString) {
    if (dateString) {
        var date = new Date(dateString.replace(/-/,"/"))
        return date;
    }
}
/**
 *@author Veng Su
 *@date 2018/4/5 11:48
 *方法作用：unix时间戳转成普通时间
 **/
function FormatDateTime(UnixTime) {
    var date = new Date(parseInt(UnixTime));
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d ;
};
