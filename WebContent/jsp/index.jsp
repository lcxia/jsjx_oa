<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/ui-sunny/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
</head>
<body style="background:#e8e8e8">
<div id="accordion" class="easyui-layout" style="width:1000px; height:650px; margin-right:auto; margin-left:auto; position:absolute; top:50%;left:50%; margin:-325px 0 0 -500px;">
    <div data-options="region:'north'" style="height:100px;" >
    	<h2>井上机械（营业部）办公自动化系统</h2>
    	<b>您好！${sessionScope.user.employeeName }&nbsp;&nbsp;&nbsp;&nbsp;<a href="../index.jsp">退出</a></b>
    </div>
    <div data-options="region:'west',title:'管理目录',split:true" style="width:200px;">
    	<ul id="acc" class="easyui-tree">
    	<li> 
        	<a href="#" onclick="addTab('报价','quote/quote.jsp','quote/quoteDetail.jsp')">报价</a>
    	</li>
    	<li>
        	<a href="#" onclick="addTab('合同','contract/contract.jsp','contract/contractDetail.jsp')">合同</a>
    	</li>
    	<li state="closed">
        <span>统计</span>
        <ul>
            <li>
                <a href="#" onclick="addTab('报价统计','statis/quoteStatis.jsp')">报价统计</a>   
            </li>
            <li>   
                <a href="#" onclick="addTab('合同统计','statis/contractStatis.jsp')">合同统计</a>   
            </li>
            <li>
                <a href="#" onclick="addTab('营业会议报告','statis/conference.jsp')">营业会议报告</a>   
            </li>
        </ul>
    	</li>
    	<li>
        	<a href="#" onclick="addTab('客户','client/client.jsp')">客户</a>  
    	</li>
    	<li>
        	<a href="#" onclick="addTab('成本','cost/cost.jsp')">成本</a>
    	</li>
    	<li state="closed">   
        <span>文档管理</span>
        <ul>
            <li>
                <a href="#" onclick="addTab('服务文档','document/serviceComplain.jsp','document/serviceComplainDetail.jsp')">服务/投诉文档</a>  
            </li>
            <li>
                <a href="#" onclick="addTab('维修文档','document/maintain.jsp','document/maintainDetail.jsp')">维修(售后)文档</a>   
            </li>
        </ul>
    	</li>
        <li>
            <a href="#" onclick="addTab('出差日程','schedule/evection.jsp')">出差日程</a>  
        </li>
       	<li>
            <a href="#" onclick="addTab('设备','device/device.jsp','device/deviceDetail.jsp')">设备</a>  
        </li>
    	<li>
        	<a href="#" onclick="addTab('营业人员','employee/employee.jsp')">营业人员</a>
    	</li>
    	</ul>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
    	<div id="tab" class="easyui-tabs">   
    	<div title="welcome" href="url" closable="true" style="padding:0px;display:none;"></div> 
		</div>
    </div>
    <div data-options="region:'south',split:true" style="height:173px;">
    	<div id="panel" class="easyui-panel" style="width:998px;height:166px;background:#fafafa;"   
        data-options="closable:true,collapsible:true,maximizable:true"> 
                    
		</div>
    </div>
</div>
</body>
</html>