function changeTo(now) {
    if (index == now) return;
    questions[now - 1].className = "question que-onshow";
    queNumber[now - 1].className = "number number-onshow";
    questions[index - 1].className = "question";
    queNumber[index - 1].className = "number";
    index = now;
}

function clearSibling(currentP) {
    var active = currentP.getElementsByClassName("answer-on");
    if (active.length == 0) return;
    active[0].className = "btnn answer-off";
}

$(document).ready(function () {
    var cnt = 30;
    for(var i=1;i<=cnt;i++){
        var questionItem = $('<div></div>');
        questionItem.addClass("question");
        if( i==1 ) questionItem.addClass("que-onshow");
        questionItem.attr("ques-index",i);
        questionItem.attr("ques-id",0);

        var title = $('<p></p>');
        title.addClass("ques-title");
        questionItem.append(title);

        var characters = new Array('A','B','C','D');
        for(var j=1;j<=4;j++){
            var option = $('<div></div>');
            option.addClass("answer");
            option.attr("answer-inde",characters[j-1]);
            var chBtn = $('<div></div>');
            chBtn.addClass("btnn");
            chBtn.addClass("answer-off");
            chBtn.text(characters[j-1]);
            var pItem = $('<p></p>');
            option.append(chBtn);
            option.append(pItem);
            questionItem.append(option);
        }
        $(".question-board").append(questionItem);

        var numberItem = $('<div></div>');
        numberItem.addClass("item");
        numberItem.addClass("number");
        if(i==1) numberItem.addClass("number-onshow");
        numberItem.text(i);
        $(".number-box").append(numberItem);

    }
    questions = document.getElementsByClassName("question");
    var prev = document.getElementById("prev");
    var next = document.getElementById("next");
    queNumber = document.getElementsByClassName("number");
    
    var current = document.querySelector(".number-onshow");
    index = parseInt(current.childNodes[0].nodeValue);

    for (var i = 1; i <= cnt; i++) {
        queNumber[i - 1].onclick = function () { changeTo(parseInt(this.childNodes[0].nodeValue)); }
    }


    prev.onclick = function (e) {
        if (index == 1) return;
        changeTo(index - 1);
    }

    next.onclick = function (e) {
        if (index == cnt) return;
        changeTo(index + 1);
    }

    var btn = document.getElementById("finish");
    var answerInput = document.getElementById("answer-input");
    options = document.getElementsByClassName("btnn");
    var answers = new Array('E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E');

    var len = options.length;
    for (var i = 0; i < len; i++)
        options[i].onclick = function (e) {
            clearSibling(this.parentNode.parentNode);
            this.className = "btnn answer-on";
            var whichOpt = this.parentNode.getAttribute("answer-inde");
            var whichQue = parseInt(this.parentNode.parentNode.getAttribute("ques-index"));
            answers[whichQue - 1] = whichOpt;
        }

    var timeInput = document.getElementById("time-input");
})






