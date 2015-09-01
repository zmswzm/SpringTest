<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>WEB-INF/jsp/treatment.css">
<script type="text/javascript" src="<%=basePath %>js/treatment.js"></script>
<style type="text/css">
<
style type ="text/css">#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
</style>
<title>分级诊疗平台</title>
</head>
<body>
	<div class="easyui-tabs">
		<div title="转出申请" style="padding: 10px">
			<div id="tb" style="padding: 2px 5px;">
			<form action="" id="searchForm">
			<input type="hidden" name="page" value="1"/>
			<input type="hidden" name="rows" value="10"/>
				患者姓名: <input name="patient_name" class="easyui-textbox" style="width: 110px">
				转入医疗机构: <input name="in_medical" class="easyui-combobox" style="width: 110px">
				申请状态：<input name="referral_status" class="easyui-combobox" style="width: 110px"></br>
				转出时间：<input name="start_time" class="easyui-datebox" style="width: 110px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				至
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input name="end_time" class="easyui-datebox" style="width: 110px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a  class="easyui-linkbutton" iconCls="icon-search" onclick="submitSearch()">搜索</a>
			</form>
			</div>
			<table id="dg" title="转出申请列表" class="easyui-datagrid"
				style="height: 380px" url="<%=basePath %>treatment/listExe.do"
				toolbar="#toolbar" pagination="true" rownumbers="true"
				fitColumns="true" singleSelect="true">

				<thead>
					<tr>
						<th field="REFERRAL_CODE">${page}${rows}序号</th>
						<th field="NAME">患者姓名</th>
						<th field="ID_NO">身份证号码</th>
						<th field="AGE">年龄</th>
						<th field="SEX">性别</th>
						<th field="COST_CODE">待遇类别</th>
						<th field="IN_MEDICAL">转入医疗结构</th>
						<th field="EXPECT_DATE">拟转入时间</th>
						<th field="APPLY_STATUS">申请类别</th>
						<th field="CREATE_DATE">申请时间</th>
						<th field="REFERRAL_STATUS">申请状态</th>
						<th field="RECORD_STATUS">报到状态</th>
					</tr>
				</thead>
			</table>

			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newUser()">增加</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
			</div>

			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">转诊信息</div>
				<form id="fm" method="post" novalidate>
					<div class="fitem">
						<label>Name:</label> <input name="name" class="easyui-textbox"
							required="true">
					</div>
					<div class="fitem">
						<label>Phone:</label> <input name="phone" class="easyui-textbox">
					</div>
					<div class="fitem">
						<label>Email:</label> <input name="email" class="easyui-textbox">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton c6"
					iconCls="icon-ok" onclick="saveUser()" style="width: 90px">Save</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">Cancel</a>
			</div>
		</div>
		<div title="转入审核" style="padding: 10px">
		<div id="tb1" style="padding: 2px 5px;">
				患者姓名: <input class="easyui-textbox" style="width: 110px">
				转入医疗机构: <input class="easyui-combobox" style="width: 110px">
				申请状态：<input class="easyui-combobox" style="width: 110px"> </br>
				转出时间：<input class="easyui-datebox" style="width: 110px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				至
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input class="easyui-datebox" style="width: 110px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			</div>
			<table id="dg1" title="转入审核列表" class="easyui-datagrid"
				style="height: 380px" url=""
			    pagination="true" rownumbers="true"
				fitColumns="true" singleSelect="true">

				<thead>
					<tr>
						<th field="id">序号</th>
						<th field="name">患者姓名</th>
						<th field="ID">身份证号码</th>
						<th field="age">年龄</th>
						<th field="sex">性别</th>
						<th field="treat">待遇类别</th>
						<th field="in">转入医疗结构</th>
						<th field="in_time">拟转入时间</th>
						<th field="type">申请类别</th>
						<th field="apply_time">申请时间</th>
						<th field="apply_status">申请状态</th>
						<th field="check_in_time">报到状态</th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="转入报到" style="padding: 10px">
		<div id="tb1" style="padding: 2px 5px;">
				患者姓名: <input class="easyui-textbox" style="width: 110px">
				转入医疗机构: <input class="easyui-combobox" style="width: 110px">
				申请状态：<input class="easyui-combobox" style="width: 110px"> </br>
				转出时间：<input class="easyui-datebox" style="width: 110px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				至
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input class="easyui-datebox" style="width: 110px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
			</div>
			<table id="dg1" title="转入审核列表" class="easyui-datagrid"
				style="height: 380px" url=""
			    pagination="true" rownumbers="true"
				fitColumns="true" singleSelect="true">

				<thead>
					<tr>
						<th field="id">序号</th>
						<th field="name">患者姓名</th>
						<th field="ID">身份证号码</th>
						<th field="age">年龄</th>
						<th field="sex">性别</th>
						<th field="treat">待遇类别</th>
						<th field="in">转入医疗结构</th>
						<th field="in_time">拟转入时间</th>
						<th field="type">申请类别</th>
						<th field="apply_time">申请时间</th>
						<th field="apply_status">申请状态</th>
						<th field="check_in_time">报到状态</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>


</body>
</html>