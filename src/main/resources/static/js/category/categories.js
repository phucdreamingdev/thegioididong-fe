$(function () {
  $("#statusLv0T").attr("checked", "checked");
  $("#statusLv1T").attr("checked", "checked");
  $("#statusLv2T").attr("checked", "checked");

  $("#isParent0T").attr("checked", "checked");
  $("#isParent1T").attr("checked", "checked");
});

$(function () {
  $("#isParent0 input[type=radio]").change(function () {
    if (this.value == 1) {
      $("#childrenLevel0").attr("disabled", false);
      $("#childrenLevel0Display").show();
    } else if (this.value == 0) {
      $("#childrenLevel0").attr("disabled", true);
      $("#childrenLevel0Display").hide();
    }
  });
});

$(function () {
  $("#isParent1 input[type=radio]").change(function () {
    if (this.value == 1) {
      $("#childrenLevel1Display").show();
    } else if (this.value == 0) {
      $("#childrenLevel1Display").hide();
    }
  });
});
formCategoryLv0;

$(function () {
  $("#btnLevel0").click(function () {
    $("#levelHide0").hide();
    $("#formCategoryLv0").show();
    $("#formCategoryLv1").hide();
    $("#formCategoryLv2").hide();
  });
  $("#btnLevel1").click(function () {
    $("#levelHide1").hide();
    $("#formCategoryLv0").hide();
    $("#formCategoryLv1").show();
    $("#formCategoryLv2").hide();
  });
  $("#btnLevel2").click(function () {
    $("#levelHide2").hide();
    $("#formCategoryLv0").hide();
    $("#formCategoryLv1").hide();
    $("#formCategoryLv2").show();
  });

  window.onload = function () {
    $("#formCategoryLv0").hide();
    $("#formCategoryLv1").hide();
    $("#formCategoryLv2").hide();
  };

  $(document).ready(function () {
    $("#formCategoryLv0").hide();
    $("#formCategoryLv1").hide();
    $("#formCategoryLv2").hide();
  });

  $("#formCategoryLv0", "#formCategoryLv1", "#formCategoryLv2").submit(
    function (event) {}
  );
});
