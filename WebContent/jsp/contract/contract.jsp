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
	<table id="tableContract" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsContract" url="AllContractServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'contractId',width:100">No</th>   
            <th data-options="field:'contractCode',width:100">合同编号</th>   
            <th data-options="field:'contractDate',width:100">日期</th>
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsContract">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addContract()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteContract()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editContract()">修改</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="queryContract()">查看详情</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgContract" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgContract-buttons">
		<form id="formContract" method="post" style="margin:50px 5px 5px 60px" novalidate>
			<div class="fitem">
				<label>合同编号：</label>
				<input name="contractCode" class="easyui-textbox" data-options="required:true">
			</div>
			<br>
			<div class="fitem">
				<label>日&nbsp;&nbsp;&nbsp;&nbsp;期&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="contractDate" class="easyui-datebox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>公司名称：</label>
				<input name="contractIndustry" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>报价编号：</label>
				<input name="contractOrder" class="easyui-textbox" data-options="required:true">
			</div>
			<br>
			<div class="fitem">
				<label>机器及部件名称：</label>
				<input name="contractDevice" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="contractComment" class="easyui-textbox" required="true">
			</div>
		
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgContract-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveContract()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgContract').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>