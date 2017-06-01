<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>营业会议报告</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
	<!-- 数据表格 -->
	<table id="tableConference" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsConference" url="AllConferenceServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'conferenceId',width:100">No</th>   
            <th data-options="field:'conferenceCode',width:100">期号</th>   
            <th data-options="field:'conferenceDoneDate',width:100">作成日期</th>
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsConference">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addConference()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteConference()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editConference()">修改</a>
		
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgConference" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgConference-buttons">
		<form id="formConference" method="post" style="margin:10px auto" novalidate>
			<div class="fitem">
				<label>期号：</label>
				<input name="conferenceCode" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>作成日期</label>
				<input name="conferenceDoneDate" class="easyui-textbox" required="true">
			</div>
			
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgConference-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveConference()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgConference').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>