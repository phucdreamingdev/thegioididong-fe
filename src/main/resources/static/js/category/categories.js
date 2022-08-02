

$(function () {
  $("#level").change(function () {
    if ($(this).val() == 0) {
      $("#parentName").hide();
      $("#idParentDisplay").show();
      $("#childrenLevelDisplay").show();
      $("#childrenLevel").removeAttr("disabled");
      // $('input[type="radio"][name=isParent][value="no').prop("disabled", false);

    } else if ($(this).val() == 1) {
      $("#parentName").show();
      $("#idParentDisplay").show();
      $("#childrenLevelDisplay").show();
      $("#childrenLevel").attr("disabled", "disabled");
      $("#parentNameLevel0").val();

    } else {
      $("#idParentDisplay").hide();
      $("#childrenLevelDisplay").hide();
      $("#parentNameLevel1").val();
    }
  });
  $("#status").attr('checked', 'checked');
  $("#isParent").attr('checked', 'checked');
});
