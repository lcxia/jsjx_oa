<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<table id="tableQuote" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsQuote" url="AllQuoteServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'quoteId',width:100">No</th>  
            <th data-options="field:'quoteDate',width:100">日期</th>   
            <th data-options="field:'quoteOrder',width:100">报价单号</th>
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsQuote">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addQuote()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteQuote()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editQuote()">修改</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="queryQuote()">查看详情</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgQuote" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgQuote-buttons">
		<form id="formQuote" method="post" style="margin:35px 5px 5px 60px" novalidate>
			<div class="fitem">
				<label>日&nbsp;&nbsp;&nbsp;&nbsp;期&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="quoteDate" class="easyui-datebox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>报价单号：</label>
				<input name="quoteOrder" class="easyui-textbox" data-options="required:true">
			</div>
			<br>
			<div class="fitem">
				<label>公司名称：</label>
				<input name="quoteIndustry" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>机器及部件名称：</label>
				<input name="quoteDevice" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>担&nbsp;&nbsp;&nbsp;&nbsp;当&nbsp;&nbsp;&nbsp;&nbsp;：</label>
				<input name="quoteTake" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>报价内容：</label>
				<input name="quoteContent" class="easyui-textbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>未税金额：</label>
				<input name="quoteNoTaxPrice" class="easyui-numberbox" precision="2" required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgQuote-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveQuote()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgQuote').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>