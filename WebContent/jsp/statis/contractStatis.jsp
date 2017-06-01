<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同统计</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
	<!-- 数据表格 -->
	<table id="tableContractStatis" class="easyui-datagrid" style="width:auto;height:335px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsContractStatis" url="AllContractStatisServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'contractStatisId',width:100">No</th>   
            <th data-options="field:'contractStatisDate',width:100">日期</th>
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsContractStatis">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addContractStatis()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteContractStatis()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editContractStatis()">修改</a>
		
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgContractStatis" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgContractStatis-buttons">
		<form id="formContractStatis" method="post" style="margin:10px auto" novalidate>
			<div class="fitem">
				<label>日期：</label>
				<input name="contractStatisDate" class="easyui-textbox" required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgContractStatis-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveContractStatis()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgContractStatis').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>