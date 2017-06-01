<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报价</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
	<!-- 数据表格 -->
	<table id="tableDevice" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsDevice" url="AllDeviceServlet" singleSelect="true">   
    <thead>
        <tr>
            <th data-options="field:'deviceId',width:100">No</th>   
            <th data-options="field:'deviceCode',width:100">型号</th>
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsDevice">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addDevice()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteDevice()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editDevice()">修改</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="queryDevice()">查看详情</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgDevice" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgDevice-buttons">
		<form id="formDevice" method="post" style="margin:80px 5px 5px 70px" novalidate>
			<div class="fitem">
				<label>型&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="deviceCode" class="easyui-textbox" data-options="required:true">
			</div>
			<br>
			<div class="fitem">
				<label>主&nbsp;&nbsp;&nbsp;&nbsp;体&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="deviceMain" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>泵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="devicePump" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>分散桶容量：</label>
				<input name="deviceCapacity" class="easyui-textbox" required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgDevice-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveDevice()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgDevice').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>