var questionNum = 0;
var current_edit = 0;

$(document).ready(
    function hide_control_bar() {
        $(".control-bar").hide();
        $(".question-bar").mouseleave(
            function () {
                $(this).css("background-color", "white");
                $(this).children().children(".control-bar").hide();
            }
        );
        $(".question-bar").mouseover(
            function () {
                $(this).css("background-color", "#c3e1f51e");
                $(this).children().children(".control-bar").show();
            }
        );
    }
);



/*
$(document).ready(
    function(){
        $(".edit-btn").click(
            function (){
                //$(this).parent().parent().parent().children(".question-content-bar").clone().appendTo("#oprate_bar");
                $(this).parents(".question-bar").find(".question-content-bar").clone().appendTo("#oprate_bar");
                var titleContent = $("#oprate_bar").find("h3").text();
                $("#oprate_bar").find("h3").replaceWith("<h3>Question:</h3><input type='text' name='questionTitle' class='form-control' value='"+titleContent+"'>");
                $("#oprate_bar").find("td").each(
                    function(){
                        $(this).children().remove();
                        var optionContent = $(this).text();
                        $(this).replaceWith("<input type='text' name='opiton[1]' class='form-control' value='"+optionContent+"'>");
                    }
                )
            }
        )
    }
)
*/
$(document).ready(
    function () {
    	var tempString = $(".question-bar:last").find(".questionContent").prop("name");
    	console.log(tempString);
    	if(tempString != null){
    		var leftp = tempString.indexOf("[");
            var rightp = tempString.indexOf("]");
            questionNum = tempString.slice(leftp + 1, rightp);
    	}
    	else{
    		questionNum = 0;
    	}
    	window.alert(questionNum);
    	$("#submit_btn").click(fullfill_questionNum);
        $("#add_single").click(add_single);
        $("#add_multi").click(add_multi);
        $("#add_essay").click(add_essay);
        $(".for-edit").hide();
        $(".edit-btn").click(edit_question);
        $(".delete-btn").click(delete_question);
        $(".up-btn").click(question_move_up);
        $(".down-btn").click(question_move_down);
    }
);

function fullfill_questionNum(){
	$("#questionNum").prop("value",questionNum);
}

function edit_question() {
    $("#preview_bar").find("button").prop("disabled","true");
    $("#preview_bar").css("color","#979797a4");
    $("#oprate_bar").empty();
    current_edit = $(this).parents(".question-bar").find(".question-content-bar");
    //console.log($(this).parents(".question-bar").text());
    current_edit.clone().appendTo("#oprate_bar");
    $("#oprate_bar").find(".for-preview").hide();
    $("#oprate_bar").find(".for-edit").show();
    $("#oprate_bar").find("input").unbind().change(update_preview);
    //if ($("#oprate_bar").has(".option-table")) {
        $("#oprate_bar").find("tbody").append("<tr><td></td><td><button class='btn btn-outline-secondary form-control' id='add_option'>添加选项</button><td></tr>");
        $("#add_option").unbind().click(add_option);
        $("#oprate_bar").find(".option-table").find(".for-edit").each(
            function () {
                $(this).append("<td><button class='btn btn-outline-danger delete-option'>删除</button></td>");
                $(".delete-option").click(delete_option);
            }
        );
    //}
    $("#oprate_bar").append("<button class='btn btn-success form-control' id='save_edit'>保存编辑</button>");
    $("#save_edit").unbind().click(save_edit);
}

function delete_question() {
	questionNum -= 1;
    $(this).parents(".question-bar").nextAll(".question-bar").each(update_questionNo_move_up);
    $(this).parents(".question-bar").remove();
}


function question_move_up() {
    var this_question_bar = $(this).parents(".question-bar");
    var prev_question_bar = $(this).parents(".question-bar").prev();
    this_question_bar.each(update_questionNo_move_up);
    prev_question_bar.each(update_questionNo_move_down);
    var temp = this_question_bar.clone();
    this_question_bar.empty();
    prev_question_bar.children().appendTo(this_question_bar);
    prev_question_bar.empty();
    temp.children().appendTo(prev_question_bar);
    $(".edit-btn").unbind().click(edit_question);
    $(".delete-btn").unbind().click(delete_question);
    $(".up-btn").unbind().click(question_move_up);
    $(".down-btn").unbind().click(question_move_down);
}

function question_move_down() {
    var this_question_bar = $(this).parents(".question-bar");
    var next_question_bar = $(this).parents(".question-bar").next();
    this_question_bar.each(update_questionNo_move_down);
    next_question_bar.each(update_questionNo_move_up);
    var temp = this_question_bar.clone();
    this_question_bar.empty();
    next_question_bar.children().appendTo(this_question_bar);
    next_question_bar.empty();
    temp.children().appendTo(next_question_bar);
    $(".edit-btn").unbind().click(edit_question);
    $(".delete-btn").unbind().click(delete_question);
    $(".up-btn").unbind().click(question_move_up);
    $(".down-btn").unbind().click(question_move_down);
}
function update_questionNo_move_up() {
    $(this).find("input").each(
        function () {
            var previousName = $(this).prop("name");
            console.log(previousName);
            var leftp = previousName.indexOf("[");
            var rightp = previousName.indexOf("]");
            var previousNo = previousName.slice(leftp + 1, rightp);
            console.log(previousNo);
            var newNo = +previousNo - 1;
            console.log(newNo);
            var newName = previousName.slice(0, leftp + 1) + newNo + "]";
            console.log(newName);
            $(this).prop("name", newName);
        }
    );
}

function update_questionNo_move_down() {
    $(this).find("input").each(
        function () {
            var previousName = $(this).prop("name");
            console.log(previousName);
            var leftp = previousName.indexOf("[");
            var rightp = previousName.indexOf("]");
            var previousNo = previousName.slice(leftp + 1, rightp);
            console.log(previousNo);
            var newNo = +previousNo + 1;
            console.log(newNo);
            var newName = previousName.slice(0, leftp + 1) + newNo + "]";
            console.log(newName);
            $(this).prop("name", newName);
        }
    );
}

function delete_option() {
    var prev_optionNum = $("#oprate_bar").find(".optionNum").val();
    var new_optionNum = +prev_optionNum - 1;
    $("#oprate_bar").find(".optionNum").val(new_optionNum);
    $(this).parent().parent().prev().remove();
    $(this).parent().parent().remove();
}

function add_option() {
    var prev_optionNum = $("#oprate_bar").find(".optionNum").val();
    var new_optionNum = +prev_optionNum + 1;
    $("#oprate_bar").find(".optionNum").val(new_optionNum);
    $("#oprate_bar").find(".option-table").find(".for-preview:first").clone().insertBefore($("#add_option").parent().parent());
    $("#oprate_bar").find(".option-table").find(".for-edit:first").clone().insertBefore($("#add_option").parent().parent());
    $("input").unbind().change(update_preview);
    $(".delete-option").unbind().click(delete_option);
}

function update_preview() {
    var newtext = $(this).prop("value");
    $(this).parents(".for-edit").prev().children(":last").children().text(newtext);
}

function save_edit() {
    $("#oprate_bar").find(".delete-option").parent().remove();
    $("#add_option").parent().parent().remove();
    $("#save_edit").remove();
    current_edit.empty();
    $("#oprate_bar").children().children().clone().appendTo(current_edit);
    $("#preview_bar").find("button").removeAttr("disabled");
    $("#preview_bar").css("color","#000");
    $("#oprate_bar").empty();
    $(".for-preview").show();
    $(".for-edit").hide();
}

function add_single() {
	questionNum = +questionNum +1;;
    $("#preview_bar").append("<div class='row question-bar'>"
        + "<div class='col-md-12'>"
        + "<div class='row question-content-bar form-group'>"
        + "<div class='col-md-12'>"
        + "<input type='text' name='optionNum[" + questionNum + "]' class='optionNum' value='2' hidden>"
        + "<div class='for-preview'>"
        + "<div>" + "<h5>QuestionContent</h5>" + "</div>"
        + "</div>"
        + "<div class='for-edit'>"
        + "<input type='text' name='questionContent[" + questionNum + "]' id='' value='QuestionContent' class='form-control' >"
        + "</div>"
        + "<div class='for-preview'>"
        + "<p>单选题</p>"
        + "</div>"
        + "<div class='for-edit'>"
        + "<input type='text' name='questionType[" + questionNum + "]' id='' class='form-control' value='单选题' readonly>"
        + "</div>"
        + "<table class='option-table' style='word-break: break-all'>"
        + "<tbody>"
        + "<tr class='for-preview'>"
        + "<td>" + "<p class='iconfont icon-option'>" + "</p>" + "</td>"
        + "<td>" + "<p>Option</p>" + "</td>"
        + "</tr>"
        + "<tr class='for-edit' >"
        + "<td>" + "<p class='iconfont icon-option'>" + "</p>" + "</td>"
        + "<td>" + "<input type='text' name='optionContent[" + questionNum + "]' id='' class='form-control' value='Option'>" + "</td>"
        + "</tr>"
        + "<tr class='for-preview'>"
        + "<td>" + "<p class='iconfont icon-option'>" + "</p>" + "</td>"
        + "<td>" + "<p>Option</p>" + "</td>"
        + "</tr>"
        + "<tr class='for-edit' >"
        + "<td>" + "<p class='iconfont icon-option'>" + "</p>" + "</td>"
        + "<td>" + "<input type='text' name='optionContent[" + questionNum + "]' id='' class='form-control' value='Option'>" + "</td>"
        + "</tr>"
        + "</tbody>"
        + "</table>"
        + "</div>"
        + "</div>"
        + "<div class='row control-bar' >"
        + "<div class='col-md-4'>" + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary up-btn' ><p class='iconfont icon-ic_up_line' style='margin-bottom: 0em;'>上移</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary down-btn' ><p class='iconfont icon-ic_down_line' style='margin-bottom: 0em;'>下移</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary edit-btn'><p class='iconfont icon-ic_edit' style='margin-bottom: 0em;'>编辑</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-danger delete-btn'><p class='iconfont icon-delete' style='margin-bottom: 0em;'>删除</p></button>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "</div>");
    $(".for-preview").show();
    $(".for-edit").hide();
    $(".question-bar").mouseleave(
        function () {
            $(this).css("background-color", "white");
            $(this).children().children(".control-bar").hide();
        }
    );
    $(".question-bar").mouseover(
        function () {
            $(this).css("background-color", "#c3e1f51e");
            $(this).children().children(".control-bar").show();
        }
    );
    $(".edit-btn").click(edit_question);
    $(".delete-btn").click(delete_question);
    $(".up-btn").click(question_move_up);
    $(".down-btn").click(question_move_down);
    console.log(questionNum);
}

function add_multi() {
    questionNum = +questionNum +1;
    $("#preview_bar").append("<div class='row question-bar'>"
        + "<div class='col-md-12'>"
        + "<div class='row question-content-bar form-group'>"
        + "<div class='col-md-12'>"
        + "<input type='text' name='optionNum[" + questionNum + "]' class='optionNum' value='2' hidden>"
        + "<div class='for-preview'>"
        + "<div>" + "<h5>QuestionContent</h5>" + "</div>"
        + "</div>"
        + "<div class='for-edit'>"
        + "<input type='text' name='questionContent[" + questionNum + "]' id='' value='QuestionContent' class='form-control' >"
        + "</div>"
        + "<div class='for-preview'>"
        + "<p>多选题</p>"
        + "</div>"
        + "<div class='for-edit'>"
        + "<input type='text' name='questionType[" + questionNum + "]' id='' class='form-control' value='多选题' readonly>"
        + "</div>"
        + "<table class='option-table' style='word-break: break-all'>"
        + "<tbody>"
        + "<tr class='for-preview'>"
        + "<td>" + "<p class='iconfont icon-multi-option'>" + "</p>" + "</td>"
        + "<td>" + "<p>Option</p>" + "</td>"
        + "</tr>"
        + "<tr class='for-edit' >"
        + "<td>" + "<p class='iconfont icon-multi-option'>" + "</p>" + "</td>"
        + "<td>" + "<input type='text' name='optionContent[" + questionNum + "]' id='' class='form-control' value='Option'>" + "</td>"
        + "</tr>"
        + "<tr class='for-preview'>"
        + "<td>" + "<p class='iconfont icon-multi-option'>" + "</p>" + "</td>"
        + "<td>" + "<p>Option</p>" + "</td>"
        + "</tr>"
        + "<tr class='for-edit' >"
        + "<td>" + "<p class='iconfont icon-multi-option'>" + "</p>" + "</td>"
        + "<td>" + "<input type='text' name='optionContent[" + questionNum + "]' id='' class='form-control' value='Option'>" + "</td>"
        + "</tr>"
        + "</tbody>"
        + "</table>"
        + "</div>"
        + "</div>"
        + "<div class='row control-bar' >"
        + "<div class='col-md-4'>" + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary up-btn' ><p class='iconfont icon-ic_up_line' style='margin-bottom: 0em;'>上移</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary down-btn' ><p class='iconfont icon-ic_down_line' style='margin-bottom: 0em;'>下移</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary edit-btn'><p class='iconfont icon-ic_edit' style='margin-bottom: 0em;'>编辑</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-danger delete-btn'><p class='iconfont icon-delete' style='margin-bottom: 0em;'>删除</p></button>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "</div>");
    $(".for-preview").show();
    $(".for-edit").hide();
    $(".question-bar").mouseleave(
        function () {
            $(this).css("background-color", "white");
            $(this).children().children(".control-bar").hide();
        }
    );
    $(".question-bar").mouseover(
        function () {
            $(this).css("background-color", "#c3e1f51e");
            $(this).children().children(".control-bar").show();
        }
    );
    $(".edit-btn").click(edit_question);
    $(".delete-btn").click(delete_question);
    $(".up-btn").click(question_move_up);
    $(".down-btn").click(question_move_down);
    console.log(questionNum);
}

function add_essay(){
	questionNum = +questionNum +1;
    $("#preview_bar").append("<div class='row question-bar'>"
        + "<div class='col-md-12'>"
        + "<div class='row question-content-bar form-group'>"
        + "<div class='col-md-12'>"
        + "<div class='for-preview'>"
        + "<div>" + "<h5>QuestionContent</h5>" + "</div>"
        + "</div>"
        + "<div class='for-edit'>"
        + "<input type='text' name='questionContent[" + questionNum + "]' id='' value='QuestionContent' class='form-control' >"
        + "</div>"
        + "<div class='for-preview'>"
        + "<p>简答题</p>"
        + "</div>"
        + "<div class='for-edit'>"
        + "<input type='text' name='questionType[" + questionNum + "]' id='' class='form-control' value='简答题' readonly>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "<div class='row control-bar' >"
        + "<div class='col-md-4'>" + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary up-btn' ><p class='iconfont icon-ic_up_line' style='margin-bottom: 0em;'>上移</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary down-btn' ><p class='iconfont icon-ic_down_line' style='margin-bottom: 0em;'>下移</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-secondary edit-btn'><p class='iconfont icon-ic_edit' style='margin-bottom: 0em;'>编辑</p></button>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<button class='btn btn-outline-danger delete-btn'><p class='iconfont icon-delete' style='margin-bottom: 0em;'>删除</p></button>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "</div>");
    $(".for-preview").show();
    $(".for-edit").hide();
    $(".question-bar").mouseleave(
        function () {
            $(this).css("background-color", "white");
            $(this).children().children(".control-bar").hide();
        }
    );
    $(".question-bar").mouseover(
        function () {
            $(this).css("background-color", "#c3e1f51e");
            $(this).children().children(".control-bar").show();
        }
    );
    $(".edit-btn").click(edit_question);
    $(".delete-btn").click(delete_question);
    $(".up-btn").click(question_move_up);
    $(".down-btn").click(question_move_down);
    console.log(questionNum);
}