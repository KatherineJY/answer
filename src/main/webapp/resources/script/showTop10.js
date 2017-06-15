$(document).ready(function () {
    $.ajax({
        method: "GET",
        url: "user/top10",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(),
        success: function (result) {
            updateTop10(result);
        }
    });

});

var top10Line = $(".rank-holder .line-title");
top10Line.splice(0, 1); // 删除首项

var updateTop10 = function (top10Result) {
    //console.log(top10Result);
    if (top10Result.successful) {
        $(top10Result.body).each(function (index, value) {
            var playName = value.name;
            var id = value.id+"";
            var grade = value.accuracy * 100;
            if( playName.length>5 ) playName = playName.substr(0,5)+"...";
            top10Line.children(".player")[index].innerHTML = playName + " " + id.substr(0,2) + "****" + id.substr(-2,2) || "匿名";
            top10Line.children(".accuracy")[index].innerHTML = grade.toFixed(2) + "%";
            top10Line.children(".time")[index].innerHTML = parseInt(value.time/60) + "分" + value.time%60 + "秒" ;
        });
    }
}