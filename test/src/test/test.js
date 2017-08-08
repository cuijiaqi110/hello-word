function onUpload(){
	if(!validateUpload()) return;
	
	
	//日期
  var dateArray = $("#txtDataTime").val().split("-");
	var bigDate = "";
	$.each(dateArray,function(i,item){
	  bigDate+=item;
	});
	
  //区域编号
  var parentCode=$.trim($("#node").attr("parentCode"));
  //营业所编号
  var nodeCode = $.trim($("#node").attr("code"));
  var bigData = {};
	bigData.baseYYYYMM=bigDate;
	bigData.areaCode=parentCode;
	bigData.officeCode=nodeCode;
  //console.log(JSON.stringify(bigData));return;
  $('#bg').toggle();//进度条
	var commandTranslate={};
  commandTranslate.commandName="uploadSalesEmployeeGoal";
  commandTranslate.contents =JSON.stringify(bigData);
  $("#commandName").val("uploadSalesEmployeeGoal");
	$("#contents").val(JSON.stringify(bigData));
  $("#CommandTranslate").val(JSON.stringify(commandTranslate));
  var url = HOST_ADDRESS+HOST_SF+SERVLET_COMMAND_HANDLER;
   var options = { 
          target:'#uploadframecontrast',   
          url:url,   
          type:'post' , 
          dataType:'json' , 
          success:function(data){
           //alert(JSON.stringify(data));
           $('#bg').toggle();//进度条
	         try{ 
	        	console.log("data------"+data);
	        	 console.log("data.contents------"+data.contents);
	        	 if(data.contents.errorCode!=null){
	        		 alert(data.contents.message);
	        		 return;
	        	 }
	        		 
	        	 
	           if(data.contents != null){
	         
	        //	if(data.contents.message == 'undefined'){
	             data = data.contents;
	             
	             //加入头合计 start
						   if(data.employeeTotalGoals.length>0){
						      $("#Grid1").datagrid("loadData",data.employeeTotalGoals);
									var headerRow = {};
									var headerRowData = data.employeeTotalGoals;
									headerRow.name="合计";
									headerRow.officeGaolAMT=headerRowData[0].officeTotalGaolAMT;
									headerRow.employeeGaolAMT =headerRowData[0].employeeTotalGaolAMT;
									headerRow.employeeGaolRate= '100'; //headerRowData[0].employeeTotalGaolRate;
									headerRow.differenceGaolAMT=headerRowData[0].differenceTotalGaolAMT;
									$("#Grid1").datagrid("insertRow",{
							                 index:0,
							                 row:headerRow
							          });
						   }else{
						     clearGrid1();
						   }
						   
						   //加入头合计 end
						   //加载tree数据
						    if(data.salesEmployeeGoals.length>0){
						      $("#treeGrid1").treegrid("loadData",data.salesEmployeeGoals);
						    }else{
						      clearTreeGrid();
						    }
	           }else{
	            
	              console.log("data------"+data)
	              console.log("data.contents------"+data.contents)
	             
	              console.log("data.message---------------"+data.message)
	           }
	         }catch(err){
	            alert("异常,请与维护人员联系");
	         }
        }
     }; 
        $('#uploadForm').ajaxSubmit(options); 
        return false; 
}