<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报价统计</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
	<!-- 数据表格 -->
	<table id="tableQuoteStatis" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsQuoteStatis" url="AllQuoteStatisServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'quoteStatisId',width:100">No</th>   
            <th data-options="field:'clientName',width:100">公司名称</th>   
            <th data-options="field:'clientType',width:100">公司性质</th>
            <th data-options="field:'quoteStatisDate',width:100">报价统计月份</th>
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsQuoteStatis">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addQuoteStatis()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteQuoteStatis()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editQuoteStatis()">修改</a>
		
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgQuoteStatis" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgQuoteStatis-buttons">
		<form id="formQuoteStatis" method="post" style="margin:10px auto" novalidate>
			<div>
				<label>公司名称：</label>
				<input name="clientName" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>公司性质：</label>
				<input name="clientType" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>报价统计月份：</label>
				<input name="QuoteStatisDate" class="easyui-textbox" required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgQuoteStatis-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveQuoteStatis()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgQuoteStatis').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>