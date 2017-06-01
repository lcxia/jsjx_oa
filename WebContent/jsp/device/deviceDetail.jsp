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
	<table id="tableDeviceDetail" class="easyui-datagrid" style="width:auto;height:420px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" singleSelect="true">   
    <thead>   
        <tr>   
            <th data-options="field:'deviceMain',width:100">主体</th>
            <th data-options="field:'devicePump',width:100">泵</th>   
            <th data-options="field:'deviceCapacity',width:100">分散桶容量</th>
            <th data-options="field:'deviceA',width:100">A</th>
            <th data-options="field:'deviceB',width:100">B</th>   
            <th data-options="field:'deviceC',width:100">C</th>
            <th data-options="field:'deviceD',width:100">D</th>   
            <th data-options="field:'deviceE',width:100">E</th>
        </tr>
    </thead>
	</table>     
</body>
</html>