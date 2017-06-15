$(document).ready(function () {
    if( $.cookie('id') == null ){
        alert("登录一下吧");
    }
    var correctAnswers = new Array();
    $.ajax({
        method: "GET",
        url: "ques/getQues",
        contentType: "application/json",
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.successful) {
                var count = result.body.length;
                for (var i = 0; i < count; i++) {
                    questions[i].setAttribute("ques-id", i);
                    questions[i].childNodes[1].innerText = result.body[i].discription;
                    options[i * 4].parentNode.childNodes[3].innerText = result.body[i].optionA;
                    options[i * 4 + 1].parentNode.childNodes[3].innerText = result.body[i].optionB;
                    options[i * 4 + 2].parentNode.childNodes[3].innerText = result.body[i].optionC;
                    options[i * 4 + 3].parentNode.childNodes[3].innerText = result.body[i].optionD;
                    correctAnswers[i] = result.body[i].answer;
                }
            } 
        }
    });
})

$("#finish").click(function () {
    var curMin = parseInt(minute.getAttribute("data-index"));
    var curs1 = parseInt(second1.getAttribute("data-index"));
    var curs2 = parseInt(second2.getAttribute("data-index"));
    var usetime = curMin * 60 + curs1 * 10 + curs2;
    usetime = 300 - usetime;

    //correct the answers
    var correctNumber = 0;
    var accarcy = 0.0;
    for(var i=0;i<count;i++)
        if( correctAnswers[i] == answers[i] )
            correctNumber++;
    accarcy = correctNumber*1.0/count;

    var sendData = {
        student_id : $.cookie("id"),
        
    }

    $.ajax({
        method: "POST",
        url: "result/submit",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(sendData),
        success: function (result) {
            console.log("here");
        }

    })
    return false;
});