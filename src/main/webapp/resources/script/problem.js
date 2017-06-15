var correctAnswers = new Array();
$(document).ready(function () {
    if( $.cookie('id') == null ){
        alert("登录一下吧");
    }
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
                    questions[i].childNodes[0].innerText = result.body[i].discription;
                    options[i * 4].parentNode.childNodes[1].innerText = result.body[i].optionA;
                    options[i * 4 + 1].parentNode.childNodes[1].innerText = result.body[i].optionB;
                    options[i * 4 + 2].parentNode.childNodes[1].innerText = result.body[i].optionC;
                    options[i * 4 + 3].parentNode.childNodes[1].innerText = result.body[i].optionD;
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
    var count = 30;
    var correctNumber = 0;
    var accuracy = 0.0;
    for(var i=0;i<count;i++)
        if( correctAnswers[i] == answers[i] )
            correctNumber++;
    accuracy = correctNumber*1.0/count;
    $.cookie("accuracy",accuracy,{path:'/',expires:1000});
    $.cookie("useTime",usetime,{path:'/',expires:1000});

    var sendData = {
        studentId : $.cookie("id"),
        useTime : usetime,
        accuracy : accuracy,
        date : new Date(),
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
});