/**
 * 
 */
var url;
function newUser() {
	$('#dlg').dialog('open').dialog('setTitle', 'New User');
	$('#fm').form('clear');
	url = '<%=basePath %>/user/userAdd.do';
}
function editUser() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
		$('#fm').form('load', row);
		url = '<%=basePath %>/user/userUpdate.do?id=' + row.id;
	}
}
function saveUser() {
	$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (!result.errorMsg) {
						$.messager.show({
									title : 'Error',
									msg : result.errorMsg
								});
					} else {
						$('#dlg').dialog('close'); // close the dialog
						$('#dg').datagrid('reload'); // reload the user data
					}
				}
			});
}
function destroyUser() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm',
				'Are you sure you want to destroy this user?', function(r) {
					if (r) {
						$.post('<%=basePath %>/user/userDelete.do', {
									id : row.id
								}, function(result) {
									if (!result.success) {
										$('#dg').datagrid('reload'); // reload the user data
									} else {
										$.messager.show({ // show error message
											title : 'Error',
											msg : result.errorMsg
										});
									}
								}, 'json');
					}
				});
	}
}

function submitSearch() {
	$('#dg').datagrid({
				queryParams : form2Json("searchForm")
	});
}
//将表单数据转为json
function form2Json(id) {
	var arr = $("#" + id).serializeArray();
	var jsonStr = "";
	if (arr.length > 0) {
		jsonStr += "{";
		for (var i = 0; i < arr.length; i++) {
			jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
		}
		jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
		jsonStr += "}"
		var json = JSON.parse(jsonStr);
	}

	return json;
}