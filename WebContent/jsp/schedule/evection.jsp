<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出差日程</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
	<!-- 数据表格 -->
	<table id="tableEvection" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsEvection" url="AllEvectionServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'evectionId',width:100">No</th>   
            <th data-options="field:'evectionName',width:100">出差人员</th>
            <th data-options="field:'evectionPlace',width:100">出差地点</th>   
            <th data-options="field:'evectionOut',width:100">出发日期</th>
            <th data-options="field:'evectionBack',width:100">返回日期</th>   
            <th data-options="field:'evectionComment',width:100">备注</th>
        </tr>   
    </thead>
	</table>
<!-- 表格的工具栏 -->
	<div id="toolsEvection">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addEvection()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"onclick="deleteEvection()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editEvection()">修改</a>
	
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgEvection" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgEvection-buttons">
		<form id="formEvection" method="post" style="margin:50px 5px 5px 60px" novalidate>
			
			<div class="fitem">
				<label>出差人员：</label>
				<input name="evectionName" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>出发地点：</label>
				<input name="evectionPlace" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>出发日期：</label>
				<input name="evectionOut" class="easyui-datebox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>返程日期：</label>
				<input name="evectionBack" class="easyui-datebox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="evectionComment" class="easyui-textbox" required="true">
			</div>
		
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgEvection-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEvection()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgEvection').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>