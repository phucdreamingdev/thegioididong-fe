var btnAddCategory;
$(document).ready(function() {
	btnAddCategory = $("#addCategory");
	btnAddCategory.click(function() {
		addCategory();
	});
});
function addCategory() {
	$.ajax({
		url: 'http://localhost:8001/admin/create-new-category',
		type: 'POST',
		contentType: "application/json",
		dataType: 'json',
		/*data: {"name": "PHUUUU",
  "logo": "",
  "level": 1,
  "parentName": "",
  "status": true,
  "parent": true,
  "childrenLevel": 2},*/

		data: JSON.stringify({
			"name": "LONG",
			"logo": "",
			"level": 1,
			"parentName": "",
			"status": true,
			"parent": true,
			"childrenLevel": 2
		}),
		success: function() {
			alert('clicked');
		},
		error: function(abc) {
			alert('non');
		}
	});
}

function test() {
	$.ajax({
		url: 'http://localhost:8001/customer/test',
		type: 'post',
		success: function() {
			alert('sucess');
		},
		error: function() {
			alert('error');
		}
	});
}
function getCategory() {
	$.ajax({
		url: 'http://localhost:8001/customer/get-all-category-by-level/0',
		dataType: 'json',
		type: 'GET',
		complete: function(data) {
			alert('sucess');
			alert(data)
		},
		success: function(data) {
			alert('sucess');
			alert(data)
		},
		error: function() {
			alert('non');
		}

	});
}