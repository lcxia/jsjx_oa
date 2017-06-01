<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维修</title>
<!-- 引入相关文件 -->
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
<!-- 数据表格 -->
	<table id="tableMaintainDetail" class="easyui-datagrid" style="width:auto;height:420px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsMaintainDetail" url="QueryMaintainServlet" singleSelect="true">   
    <thead>   
        <tr>
            <th data-options="field:'maintainDate',width:100">维修日期</th>   
            <th data-options="field:'maintainEvection',width:100">维修出差号</th>
            <th data-options="field:'maintainClient',width:100">维修用户</th>   
            <th data-options="field:'maintainDevice',width:100">维修设备</th>   
            <th data-options="field:'maintainRely',width:100">依赖号</th>
            <th data-options="field:'maintainContinue',width:100">有无后续操作</th>
            <th data-options="field:'maintainPerson',width:100">维修人员</th>   
        </tr>
    </thead>
	</table>     
</body>
</html>