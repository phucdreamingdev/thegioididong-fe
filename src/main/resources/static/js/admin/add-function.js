var btnAddCategory;
$(document).ready(function() {
	btnAddCategory = $("#addCategory");
	btnAddCategory.click(function() {
		addCategory();
	});
});
function addCategory() {
	$.ajax({
    url: 'http://localhost:8002/admin/categories-add',
    dataType: 'json',
    type: 'post',
    contentType: "application/json; charset=utf-8",
    traditional: true,
    data: JSON.stringify( {
    "name": "PHỤ",
    "logo": "",
    "level": 1,
    "parentName": "Phụ Kiện",
    "status": true,
    "parent": true,
    "childrenLevel": 2
} ),
    processData: false,
    success: function(){
        alert('clicked');
    },
    error: function(){
        alert('non');
    }
});
}

function getCategory() {
	$.ajax({
    url: 'http://localhost:8001/customer/get-all-category-by-level/0',
    dataType: 'json',
    type: 'GET',
  	complete: function(data){
			alert('sucess');
            alert(data)
        },
        success: function(data){
	alert('sucess');
            alert(data)
        },
        error: function(){
        alert('non');
    }

	});
}