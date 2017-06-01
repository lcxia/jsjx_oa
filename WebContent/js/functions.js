//定义2个记录地址的全局变量
var url;
var panel;
/**
 * 添加panel
 */
function addPanel(title,url){
	$('#panel').panel({   
		  title: title, 
		  href:url
		});
}

/**
 * 添加tabs
 */
function addTab(title,url){
	if($('#tab').tabs('exists',title)){
		$('#tab').tabs('select',title);
	}
	else{
		$('#tab').tabs('add',{title:title,href:url,closable:true});
	}
}
function addTab(title,url,panel){
	if($('#tab').tabs('exists',title)){
		$('#tab').tabs('select',title);
	}
	else{
		$('#tab').tabs('add',{title:title,href:url,closable:true});
		addPanel(title+"详情",panel);
	}
}

/**
 * 添加报价dialog
 */
function addQuote(){
	//打开对话框
	$('#dlgQuote').dialog('open').dialog('setTitle','添加报价');
	//清空表单的内容
	$('#formQuote').form('clear');
	//设置保存的地址
	url = "AddQuoteServlet";
}
/**
 * 保存报价的函数
 */
function saveQuote(){
	$('#formQuote').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				//关闭对话框
				$('#dlgQuote').dialog('close');
				//重载数据
				$('#tableQuote').datagrid('reload');
			}
		}})
}

/**
 * 修改报价弹出对话框的信息
 */
function editQuote(){
	var row = $('#tableQuote').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgQuote').dialog('open').dialog('center').dialog('setTitle','修改报价');
		$('#formQuote').form('load',row);//选中行的信息，填充到表格中
		url = 'EditQuoteServlet?quoteId='+row.quoteId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除报价弹出对话框的信息
 */
function deleteQuote(){
	var row = $('#tableQuote').datagrid('getSelected');
	if(row){
		url = 'QueryQuoteServlet?quoteId='+row.quoteId;//将选中行的id传到指定地点
		$('#tableQuoteDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 查询报价详细信息
 */
function queryQuote(){
	var row = $('#tableQuote').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		url = 'QueryQuoteServlet?quoteId='+row.quoteId;//将选中行的id传到指定地点
		$('#tableQuoteDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要查看的数据'});
	}
}

function addEmployee(){
	$('#dlgEmployee').dialog('open').dialog('setTitle','添加营业人员');//打开对话框
	$('#formEmployee').form('clear');//清空表单的内容
	url = "AddEmployeeServlet";//设置保存的地址
}
/**
 * 保存的函数
 */
function saveEmployee(){
	$('#formEmployee').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgEmployee').dialog('close');
				$('#tableEmployee').datagrid('reload');
			}
		}})
}
/**
 * 修改营业人员弹出对话框的信息
 */
function editEmployee(){
	var row = $('#tableEmployee').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgEmployee').dialog('open').dialog('center').dialog('setTitle','修改营业人员');
		$('#formEmployee').form('load',row);//选中行的信息，填充到表格中
		url = 'EditEmployeeServlet?employeeId='+row.employeeId;//将选中行的id传到指定地点
	}
}
/**
 * 删除营业人员弹出对话框的信息
 */
function deleteEmployee(){
	var row = $('#tableEmployee').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteEmployeeServlet',{employeeId:row.employeeId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableEmployee').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

function addServiceComplain(){
	$('#dlgServiceComplain').dialog('open').dialog('setTitle','添加服务/投诉');//打开对话框
	$('#formServiceComplain').form('clear');//清空表单的内容
	url = "AddServiceComplainServlet";//设置保存的地址
}
/**
 * 保存的函数
 */
function saveServiceComplain(){
	$('#formServiceComplain').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgServiceComplain').dialog('close');
				$('#tableServiceComplain').datagrid('reload');
			}
		}})
}
/**
 * 修改服务/投诉弹出对话框的信息
 */
function editServiceComplain(){
	var row = $('#tableServiceComplain').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgServiceComplain').dialog('open').dialog('center').dialog('setTitle','修改服务/投诉');
		$('#formServiceComplain').form('load',row);//选中行的信息，填充到表格中
		url = 'EditServiceComplainServlet?serviceComplainId='+row.serviceComplainId;//将选中行的id传到指定地点
	}
}
/**
 * 删除服务/投诉弹出对话框的信息
 */
function deleteServiceComplain(){
	var row = $('#tableServiceComplain').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteServiceComplainServlet',{serviceComplainId:row.serviceComplainId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableServiceComplain').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 查询服务详细信息
 */
function queryServiceComplain(){
	var row = $('#tableServiceComplain').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		url = 'QueryServiceComplainServlet?serviceComplainId='+row.serviceComplainId;//将选中行的id传到指定地点
		$('#tableServiceComplainDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要查看的数据'});
	}
}


/**
 * 添加合同dialog
 */
function addContract(){
	$('#dlgContract').dialog('open').dialog('setTitle','添加合同');//打开对话框
	$('#formContract').form('clear');//清空表单的内容
	url = "AddContractServlet";//设置保存的地址
}
/**
 * 保存合同的函数
 */
function saveContract(){
	$('#formContract').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgContract').dialog('close');
				$('#tableContract').datagrid('reload');
			}
		}})
}

/**
 * 修改合同弹出对话框的信息
 */
function editContract(){
	var row = $('#tableContract').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgContract').dialog('open').dialog('center').dialog('setTitle','修改合同');
		$('#formContract').form('load',row);//选中行的信息，填充到表格中
		url = 'EditContractServlet?contractId='+row.contractId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除合同弹出对话框的信息
 */
function deleteContract(){
	var row = $('#tableContract').datagrid('getSelected');
	if(row){
		url = 'QueryDeviceServlet?quoteId='+row.quoteId;//将选中行的id传到指定地点
		$('#tableContractDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 查询合同详细信息
 */
function queryContract(){
	var row = $('#tableContract').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		url = 'QueryContractServlet?contractId='+row.contractId;//将选中行的id传到指定地点
		$('#tableContractDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要查看的数据'});
	}
}

/**
 * 添加设备dialog
 */
function addDevice(){
	$('#dlgDevice').dialog('open').dialog('setTitle','添加设备');//打开对话框
	$('#formDevice').form('clear');//清空表单的内容
	url = "AddDeviceServlet";//设置保存的地址
}
/**
 * 保存设备的函数
 */
function saveDevice(){
	$('#formDevice').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgDevice').dialog('close');
				$('#tableDevice').datagrid('reload');
			}
		}})
}

/**
 * 修改设备弹出对话框的信息
 */
function editDevice(){
	var row = $('#tableDevice').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgDevice').dialog('open').dialog('center').dialog('setTitle','修改设备');
		$('#formDevice').form('load',row);//选中行的信息，填充到表格中
		url = 'EditDeviceServlet?deviceId='+row.deviceId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除设备弹出对话框的信息
 */
function deleteDevice(){
	var row = $('#tableDevice').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteDeviceServlet',{deviceId:row.deviceId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableDevice').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 查询设备详细信息
 */
function queryDevice(){
	var row = $('#tableDevice').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		url = 'QueryDeviceServlet?deviceId='+row.deviceId;//将选中行的id传到指定地点
		$('#tableDeviceDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要查看的数据'});
	}
}

function addMaintain(){
	$('#dlgMaintain').dialog('open').dialog('setTitle','添加维修（售后）');//打开对话框
	$('#formMaintain').form('clear');//清空表单的内容
	url = "AddMaintainServlet";//设置保存的地址
}
/**
 * 保存的函数
 */
function saveMaintain(){
	$('#formMaintain').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgMaintain').dialog('close');
				$('#tableMaintain').datagrid('reload');
			}
		}})
}
/**
 * 修改维修（售后）弹出对话框的信息
 */
function editMaintain(){
	var row = $('#tableMaintain').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgMaintain').dialog('open').dialog('center').dialog('setTitle','修改维修（售后）');
		$('#formMaintain').form('load',row);//选中行的信息，填充到表格中
		url = 'EditMaintainServlet?maintainId='+row.maintainId;//将选中行的id传到指定地点
	}
}
/**
 * 删除维修（售后）弹出对话框的信息
 */
function deleteMaintain(){
	var row = $('#tableMaintain').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteMaintainServlet',{maintainId:row.maintainId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableMaintain').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 查询报价详细信息
 */
function queryMaintain(){
	var row = $('#tableMaintain').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		url = 'QueryMaintainServlet?maintainId='+row.maintainId;//将选中行的id传到指定地点
		$('#tableMaintainDetail').datagrid('reload',url);
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要查看的数据'});
	}
}

/**
 * 添加成本dialog
 */
var url;//定义一个记录地址的全局变量
function addCost(){
	$('#dlgCost').dialog('open').dialog('setTitle','添加成本');//打开对话框
	$('#formCost').form('clear');//清空表单的内容
	url = "AddCostServlet";//设置保存的地址
}
/**
 * 保存成本的函数
 */
function saveCost(){
	$('#formCost').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgCost').dialog('close');
				$('#tableCost').datagrid('reload');
			}
		}})
}
/**
 * 修改成本弹出对话框的信息
 */
function editCost(){
	var row = $('#tableCost').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgCost').dialog('open').dialog('center').dialog('setTitle','修改成本');
		$('#formCost').form('load',row);//选中行的信息，填充到表格中
		url = 'EditCostServlet?costId='+row.costId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}
/**
 * 删除成本弹出对话框的信息
 */
function deleteCost(){
	var row = $('#tableCost').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteCostServlet',{costId:row.costId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableCost').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 添加出差日程dialog
 */
var url;
function addEvection(){
	$('#dlgEvection').dialog('open').dialog('setTitle','出差日程');//打开对话框
	$('#formEvection').form('clear');//清空表单的内容
	url = "AddEvectionServlet";//设置保存的地址
}
/**
 * 保存出差日程的函数
 */
function saveEvection(){
	$('#formEvection').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgEvection').dialog('close');
				$('#tableEvection').datagrid('reload');
			}
		}})
}

/**
 * 修改出差日程弹出对话框的信息
 */
function editEvection(){
	var row = $('#tableEvection').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgEvection').dialog('open').dialog('center').dialog('setTitle','修改出差日程');
		$('#formEvection').form('load',row);//选中行的信息，填充到表格中
		url = 'EditEvectionServlet?evectionId='+row.evectionId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除出差日程弹出对话框的信息
 */
function deleteEvection(){
	var row = $('#tableEvection').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteEvectionServlet',{evectionId:row.evectionId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableEvection').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}

/**
 * 添加客户dialog
 */
function addClient(){
	$('#dlgClient').dialog('open').dialog('setTitle','添加客户');//打开对话框
	$('#formClient').form('clear');//清空表单的内容
	url = "AddClientServlet";//设置保存的地址
}
/**
 * 保存客户的函数
 */
function saveClient(){
	$('#formClient').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgClient').dialog('close');
				$('#tableClient').datagrid('reload');
			}
		}})
}

/**
 * 修改客户弹出对话框的信息
 */
function editClient(){
	var row = $('#tableClient').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgClient').dialog('open').dialog('center').dialog('setTitle','修改客户');
		$('#formClient').form('load',row);//选中行的信息，填充到表格中
		url = 'EditClientServlet?clientId='+row.clientId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除客户弹出对话框的信息
 */
function deleteClient(){
	var row = $('#tableClient').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteClientServlet',{clientId:row.clientId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableClient').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}
/**
 * 添加会议报告dialog
 */
function addConference(){
	$('#dlgConference').dialog('open').dialog('setTitle','添加会议报告');//打开对话框
	$('#formConference').form('clear');//清空表单的内容
	url = "AddConferenceServlet";//设置保存的地址
}
/**
 * 保存报价的函数
 */
function saveConference(){
	$('#formConference').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgConference').dialog('close');
				$('#tableConference').datagrid('reload');
			}
		}})
}

/**
 * 修改报价弹出对话框的信息
 */
function editConference(){
	var row = $('#tableConference').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgConference').dialog('open').dialog('center').dialog('setTitle','修改会议报告');
		$('#formConference').form('load',row);//选中行的信息，填充到表格中
		url = 'EditConferenceServlet?conferenceId='+row.conferenceId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除会议报告弹出对话框的信息
 */
function deleteConference(){
	var row = $('#tableConference').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteConferenceServlet',{conferenceId:row.conferenceId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableConference').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}
/**
 * 添加报价统计dialog
 */
function addQuoteStatis(){
	$('#dlgQuoteStatis').dialog('open').dialog('setTitle','添加报价统计');//打开对话框
	$('#formQuoteStatis').form('clear');//清空表单的内容
	url = "AddQuoteStatisServlet";//设置保存的地址
}
/**
 * 保存报价统计的函数
 */
function saveQuoteStatis(){
	$('#formQuoteStatis').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgQuoteStatis').dialog('close');
				$('#tableQuoteStatis').datagrid('reload');
			}
		}})
}

/**
 * 修改报价统计弹出对话框的信息
 */
function editQuoteStatis(){
	var row = $('#tableQuoteStatis').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgQuoteStatis').dialog('open').dialog('center').dialog('setTitle','修改报价统计记录');
		$('#formQuoteStatis').form('load',row);//选中行的信息，填充到表格中
		url = 'EditQuoteStatisServlet?quoteStatisId='+row.quoteStatisId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除报价统计弹出对话框的信息
 */
function deleteQuoteStatis(){
	var row = $('#tableQuoteStatis').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteQuoteStatisServlet',{quoteStatisId:row.quoteStatisId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableQuoteStatis').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}
/**
 * 添加合同统计dialog
 */
function addContractStatis(){
	$('#dlgContractStatis').dialog('open').dialog('setTitle','添加合同统计');//打开对话框
	$('#formContractStatis').form('clear');//清空表单的内容
	url = "AddContractStatisServlet";//设置保存的地址
}
/**
 * 保存的函数
 */
function saveContractStatis(){
	$('#formContractStatis').form('submit',{url:url,onSubmit:function(){return $(this).form('validate');},
		success:function(data){
			var result = eval('('+data+')');
			if(result.errorMsg){$.messager.show({title:'Error',msg:result.errorMsg});}
			else{
				$('#dlgContractStatis').dialog('close');
				$('#tableContractStatis').datagrid('reload');
			}
		}})
}

/**
 * 修改弹出对话框的信息
 */
function editContractStatis(){
	var row = $('#tableContractStatis').datagrid('getSelected');//获得数据表中选中的数据行
	if(row){
		$('#dlgContractStatis').dialog('open').dialog('center').dialog('setTitle','修改合同统计');
		$('#formContractStatis').form('load',row);//选中行的信息，填充到表格中
		url = 'EditContractStatisServlet?contractStatisId='+row.contractStatisId;//将选中行的id传到指定地点
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要修改的数据'});
	}
}

/**
 * 删除弹出对话框的信息
 */
function deleteContractStatis(){
	var row = $('#tableContractStatis').datagrid('getSelected');
	if(row){
		$.messager.confirm('confirm','是否删除？',function(r){
			if(r){
				//$.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('DeleteContractStatisServlet',{contractStatisId:row.contractStatisId},function(data){
					if(data.success){
						$.messager.show({title:'提示',msg:data.errorMsg});
						$('#tableContractStatis').datagrid('reload');
					}
					else{
						$.messager.show({title:'Error',msg:data.errorMsg});
					}
				},'json');
			}
		});
	}
	else{
		$.messager.show({title:'提示',msg:'请选择要删除的数据'});
	}
}