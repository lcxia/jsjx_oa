<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务/投诉</title>
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
	<table id="tableServiceComplainDetail" class="easyui-datagrid" style="width:auto;height:420px" data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsServiceComplainDetail" url="QueryServiceComplaineServlet" singleSelect="true">   
    <thead>   
        <tr> 
        	<th data-options="field:'serviceComplainId',width:100">序号</th>
            <th data-options="field:'serviceComplainCode',width:100">服务/投诉号</th> 
            <th data-options="field:'serviceComplainClient',width:100">投诉用户</th>
            <th data-options="field:'serviceComplainDoneDate',width:100">完成日期</th>   
            <th data-options="field:'serviceComplainLetterDate',width:100">收信日期</th>   
            <th data-options="field:'serviceComplainLetterReceive',width:100">收信人</th>
            <th data-options="field:'serviceComplainTake',width:100">服务担当</th>
            <th data-options="field:'serviceComplainDevice',width:100">服务设备</th>   
        </tr>
    </thead>
	</table>     
</body>
</html>