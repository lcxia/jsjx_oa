<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维修（售后）文档</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
 <table id="tableMaintain" class="easyui-datagrid" style="width:auto;height:335px" data-options="fitColumns:true"  
		pagination="true" toolbar="#toolsMaintain" url="AllMaintainServlet" singleSelect="true">   
    <thead>   
        <tr> 
            <th data-options="field:'maintainId',width:100">序号</th>
            <th data-options="field:'maintainEvection',width:100">维修出差号</th>   
        </tr>   
    </thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsMaintain">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addMaintain()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"onclick="deleteMaintain()">删除</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editMaintain()">修改</a>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="queryMaintain()">查看详情</a>
		
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgMaintain" class="easyui-dialog" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px"
		closed="true" buttons="#dlgMaintain-buttons">
		<form id="formMaintain" method="post" style="margin:50px 5px 5px 60px" novalidate>
			<div class="fitem">
				<label>维修出差号：</label>
				<input name="maintainEvection" class="easyui-textbox" required="true">
			</div>
			</form>
			</div>
			<!-- 对话框的按钮 -->
	<div id="dlgMaintain-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveMaintain()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgMaintain').dialog('close')" style="width:90px">取消</a>
	</div>	
</body>
</html>