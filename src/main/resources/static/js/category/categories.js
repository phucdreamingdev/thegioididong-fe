// $(function () {
//     $("#level").change(function () {
//         if ($(this).val() == 0) {
//             $("#parentName").attr("disabled", "disabled");
//         } else {
//             $("#parentName").removeAttr("disabled");
//         }
//     });
// });

$(function () {
    $("#level").change(function () {
        if ($(this).val() == 0) {
            $("#parentName").hide();
            $("#idParentDisplay").show();
            $("#childrenLevelDisplay").show();
            $("#childrenLevel").removeAttr("disabled");
            $('input[type="radio"][name=isParent][value="no').prop('disabled', false);
            $('input[type=radio][name=isParent]').change(function () {
                if (this.value == 'yes') {
                    $("#childrenLevelDisplay").show()
                }
                else if (this.value == 'no') {
                    $("#childrenLevelDisplay").hide()
                }
            });
        } else if ($(this).val() == 1) {
            $("#parentName").show();
            $("#idParentDisplay").show();
            $('input[type="radio"][name=isParent][value="no').prop('disabled', true);
            $("#childrenLevelDisplay").show();
            $("#childrenLevel").val(2);
            $("#childrenLevel").attr("disabled", "disabled");
        } else {
            $("#idParentDisplay").hide();
            $("#childrenLevelDisplay").hide();
        }
    });
});


