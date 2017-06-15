var count = 0;

function createProblemInfo(className, innerText) {
    var item = $('<div></div>');
    item.addClass("problem-info");
    item.addClass(className);
    item.text(innerText);
    return item;
}

function addProblemItem(categoryText, discriptionText, optionAText, optionBText, optionCText, optionDText, answerText) {
    var problemItem = $('<div></div>');
    problemItem.attr("data-index", count);
    problemItem.addClass("problem-item");

    var category = createProblemInfo("category", categoryText);
    var discription = createProblemInfo("discription", discriptionText);
    var optionA = createProblemInfo("optionA", optionAText);
    var optionB = createProblemInfo("optionB", optionBText);
    var optionC = createProblemInfo("optionC", optionCText);
    var optionD = createProblemInfo("optionD", optionDText);
    var answer = createProblemInfo("answer", answerText);
    var edit = createProblemInfo("edit", "编辑");
    var deleteBtn = createProblemInfo("delete", "删除");

    problemItem.append(category);
    problemItem.append(discription);
    problemItem.append(optionA);
    problemItem.append(optionB);
    problemItem.append(optionC);
    problemItem.append(optionD);
    problemItem.append(answer);
    problemItem.append(edit);
    problemItem.append(deleteBtn);
    $(".problem-list").append(problemItem);

    edit.click(function () {
        editItem = this;
        $(".edit-board").css('display', 'flex');

        var editBtn = $('<div></div>');
        editBtn.addClass("sure-btn");
        editBtn.addClass("edit-problem");
        editBtn.text("修 改");
        $(".edit-board").append(editBtn);

        editBtn.click(function () {
            var sendData1 = {
                discription: editItem.parentNode.childNodes[1].innerHTML,
            }
            $.ajax({
                method: "POST",
                url: "ques/deleteQues",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(sendData1),
                success: function (result) {}
            })

            editItem.parentNode.childNodes[0].innerHTML = $("input[name='category']").val();
            editItem.parentNode.childNodes[1].innerHTML = $("input[name='discription']").val();
            editItem.parentNode.childNodes[2].innerHTML = $("input[name='optionA']").val();
            editItem.parentNode.childNodes[3].innerHTML = $("input[name='optionB']").val();
            editItem.parentNode.childNodes[4].innerHTML = $("input[name='optionC']").val();
            editItem.parentNode.childNodes[5].innerHTML = $("input[name='optionD']").val();
            editItem.parentNode.childNodes[6].innerHTML = $("input[name='answer']").val();
            $(".edit-board>.edit-problem").remove();
            $(".edit-board").css('display', 'none');

            var sendData = {
                category: $("input[name='category']").val(),
                discription: $("input[name='discription']").val(),
                optionA: $("input[name='optionA']").val(),
                optionB: $("input[name='optionB']").val(),
                optionC: $("input[name='optionC']").val(),
                optionD: $("input[name='optionD']").val(),
                answer: $("input[name='answer']").val(),
            }

            $.ajax({
                method: "POST",
                url: "ques/addQues",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(sendData),
                success: function (result) {}
            })
        });
    });

    deleteBtn.click(function () {
        deleteItem = this;
        var sendData1 = {
                discription: deleteItem.parentNode.childNodes[1].innerHTML,
            }
            $.ajax({
                method: "POST",
                url: "ques/deleteQues",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(sendData1),
                success: function (result) {}
            })
        deleteItem.parentNode.style.display = 'none';
    });
}

function updateProblems(result) {
    if (result.successful) {
        $(result.body).each(function (index, value) {
            addProblemItem(value.category, value.discription, value.optionA, value.optionB, value.optionC, value.optionD, value.answer);
        });
    }
}

$(document).ready(function () {
    $.ajax({
        method: "GET",
        url: "ques/getAllQues",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(),
        success: function (result) {
            updateProblems(result);
        }
    });
});

function closeAddBtn() {
    $(".edit-board").css('display', 'none');
    $(".add-btn").text("添 加 题 目");
    $(".edit-board>.add-problem").remove();
}

$(".add-btn").click(function () {
    if ($(".edit-board").css('display') == "none") {
        $(".edit-board").css('display', 'flex');
        $(".add-btn").text("关 闭");

        var btn = $('<div></div>');
        btn.addClass("sure-btn");
        btn.addClass("add-problem");
        btn.text("添 加 此 题");
        $(".edit-board").append(btn);
        btn.click(function () {
            count = count + 1;
            addProblemItem(
                $("input[name='category']").val(), $("input[name='discription']").val(),
                $("input[name='optionA']").val(), $("input[name='optionB']").val(),
                $("input[name='optionC']").val(), $("input[name='optionD']").val(),
                $("input[name='answer']").val()
            );

            var sendData = {
                category: $("input[name='category']").val(),
                discription: $("input[name='discription']").val(),
                optionA: $("input[name='optionA']").val(),
                optionB: $("input[name='optionB']").val(),
                optionC: $("input[name='optionC']").val(),
                optionD: $("input[name='optionD']").val(),
                answer: $("input[name='answer']").val(),
            }

            $.ajax({
                method: "POST",
                url: "ques/addQues",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(sendData),
                success: function (result) {}
            })

            closeAddBtn();
        });
    }
    else {
        closeAddBtn();
    }
})