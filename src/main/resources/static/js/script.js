$(document).ready(function () {
    const MIN = 2;
    const MAX = 2048;
    $("form[name='registration']").validate({
        rules: {
            notebook: {
                required: true,
                minlength: MIN,
                maxlength: MAX
            },
            word: {
                required: true,
                minlength: MIN,
                maxlength: MAX
            }

        },
        messages: {
            notebook: {
                required: "Please provide a notebook entry",
                minlength: "Your entry must be at least "+MIN+" characters long",
                maxlength: "Your entry must be max "+MAX+"  characters long"
            },
            word: {
                required: "Please provide a word",
                minlength: "Your word must be at least "+MIN+"  characters long",
                maxlength: "Your word must be max "+MAX+" characters long"
            }
        },
        submitHandler: function (form,event) {
            event.preventDefault();
            $.ajax({
                url: "/similarity",
                data: {
                    notebook: $("#notebook").val(),
                    word: $("#word").val()
                },
                success: function (result) {
                    $("#frequency span").html(result.frequency);
                    $("#similarWords span").html(JSON.stringify(result.similarWords));
                },
                error: function(result) {
                    alert("Status: " + JSON.stringify(result));
                }
            });
            return false;
        }
    });

});
