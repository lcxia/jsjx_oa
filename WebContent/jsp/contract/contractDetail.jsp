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
	<table id="tableContractDetail" class="easyui-datagrid" style="width:auto;height:420px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'contractIndustry',width:100">公司名称</th>   
            <th data-options="field:'contractDevice',width:100">机器及部件名称</th>   
            <th data-options="field:'contractOrder',width:100">报价编号</th>
            <th data-options="field:'contractComment',width:100">备注</th>
        </tr>
    </thead>
	</table>     
</body>
</html>