$(function(){

    function success() {
        $(location).attr('href', '/home');
    }

    $(".todoCheckbox").on("click", function () {
        var todoId = $(this).parent().attr("id");

        $.ajax({
            type: "put",
            url: "/todo/update/" + todoId,
            contentType: "application/json;charset=utf-8",
            success: success()
        })
    });

    $(".glyphicon-trash").on("click", function () {
        var todoId = $(this).parent().attr("id");
        $.ajax({
            type: "delete",
            url: "/todo/deletion/" + todoId,
            success: success()
        })
    });
});
