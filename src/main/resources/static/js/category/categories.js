
$(function () {
  $("#level").change(function () {
	var s = '<option value=' + -1 + '>SELECT</option>';
	var s1 = '<option class="form-control" th:each="categories0 : ${categoriesLevel0}" th:value="${categories0.name}" th:text="${categories0.name}" id="parentNameLevel0"></option>';
	var s2 = '<option class="form-control" th:each="categories1 : ${categoriesLevel1}" th:value="${categories1.name}" th:text="${categories1.name}" id="parentNameLevel1"></option>';
    if ($(this).val() == 0) {
      $("#parentNameDisplay").hide();
      $("#idParentDisplay").show();
      $("#childrenLevelDisplay").show();
      $("#childrenLevel").removeAttr("disabled");
      // $('input[type="radio"][name=isParent][value="no').prop("disabled", false);

    } else if ($(this).val() == 1) {
      $("#parentNameDisplay").show();
      $("#idParentDisplay").show();
      $("#childrenLevelDisplay").show();
      $("#childrenLevel").attr("disabled", "disabled");
      s += s1;
	$('#parentName').html(s);

    } else {
      $("#idParentDisplay").hide();
      $("#childrenLevelDisplay").hide();
      s += s1;
      $('#parentName').html(s);
    }
    $('#parentName').html(s);
  });
  $("#status").attr('checked', 'checked');
  $("#isParent").attr('checked', 'checked');
});
