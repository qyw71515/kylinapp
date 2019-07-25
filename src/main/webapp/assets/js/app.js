(function($) {
  'use strict';

  $(function() {
    var $fullText = $('.admin-fullText');
    $('#admin-fullscreen').on('click', function() {
      $.AMUI.fullscreen.toggle();
    });

    $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
      $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
    });
  });
})(jQuery);

function check(type,url){
	var uTel = $("#uTel").val().trim();
	var uPWD = $("#uPWD").val().trim();
	var uPWDConfirm = $("#uPWDConfirm").val().trim();
	var secCode = $("#secCode").val().trim();
	
				if("uTel"==type){
					
					if(uTel.length!=11){
						 $("#uTelAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>电话号码格式不合法</small>");
						 $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
						 $("#getSecCode").attr("disabled","disabled");
					}else{
						ajaxCheckTelRep(uTel,url);
					}
				}
				if("uPWD"==type){
					
					if(uPWD.length<6||uPWD.length>12){
						 $("#uPWDAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>长度在6-12位之间</small>");
					}else{
						 $("#uPWDAlert").html("<br/>");
					}
				}
				if("uPWDConfirm"==type){
					
					if(uPWD!=uPWDConfirm){
						 $("#uPWDConfirmAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>密码不一致</small>");
					}else{
						 $("#uPWDConfirmAlert").html("<br/>");
					}
				}
				if("secCode"==type){
					
					if(secCode.length!=4){
						 $("#secCodeAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>长度是4位</small>");
					}else{
						 $("#secCodeAlert").html("<br/>");
					}
				}
				
				if(uTel.length==11&&secCode.length==4&&uPWD==uPWDConfirm&&uPWD.length>5&&uPWD.length<12){
					
					$("#save").removeAttr("disabled");
					$("#save").attr("class","am-btn am-btn-primary am-btn-block");
				}else{
					
					$("#save").attr("disabled","disabled");
					$("#save").attr("class","am-btn am-btn-default am-btn-block");
				}
			}

function sendSMS(url){
	var uTel = $("#uTel").val().trim();
	
		var count = 60;
    var countdown = setInterval(CountDown, 1000);
   
    $.ajax({
		  type: 'POST',
		  url:url,
		  data: {
			  "telNumber":uTel,
		  },
		  success:  function(data) {
				try {
					
				} catch (e) {
             	     alert("error");
				}
			},
		
			error: function (jqXHR, textStatus, errorThrown) {
				 alert("网络错误");
	        },
		});
		
    function CountDown() {
                    $("#getSecCode").attr("disabled","disabled");
										$("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
										$("#getSecCode").html("再次获取(" + count + "秒)");
                    if (count == 0) {
                        $("#getSecCode").removeAttr("disabled");
                        $("#getSecCode").attr("class","am-btn am-btn-primary");
                        $("#getSecCode").html("获取短信验证码");
                        clearInterval(countdown);
                    }
                    count--;
                }
	
}

function userSignIn(url) {
	var uTel = $("#uTel").val().trim();
	var uPWD = $("#uPWD").val().trim();
	var uPWDConfirm = $("#uPWDConfirm").val().trim();
	var secCode = $("#secCode").val().trim();
	$.ajax({
		  type: 'POST',
		  url:url,
		  data: {
				"telnumber" : uTel,
				"password" : uPWD,
				"secCode" : secCode
		  },
		  success:  function(data) {
				try {
					if(data == "1"){
						 $("#uTelAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>电话号码已存在，<a href='"+base+"user/login'>跳转登录</a></small>");
						 $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
						 $("#getSecCode").attr("disabled","disabled");
						 
					     $("#save").attr("disabled","disabled");
						 $("#save").attr("class","am-btn am-btn-default am-btn-block");
					}else if(data == "2"){
						 $("#secCodeAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>验证码错误</small>");
						 
                    }else if(data == "3"){
                    	 alert("注册成功");
                    	 window.location.href = base+'vote';
                    }else{
                    	 $("#secCodeAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>未知错误</small>");
                    	 $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
						 $("#getSecCode").attr("disabled","disabled");
                    }
				} catch (e) {
               	     $("#secCodeAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>网络错误</small>");
               	     $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
					 $("#getSecCode").attr("disabled","disabled");
				}
			},
		
			error: function (jqXHR, textStatus, errorThrown) {
				$("#secCodeAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>网络错误</small>");
          	     $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
				 $("#getSecCode").attr("disabled","disabled");
	        },
		});
}

function ajaxCheckTelRep(telnumber,url) {

	$.ajax({
		  type: 'POST',
		  url:url,
		  data: {
				"telnumber" : telnumber
		  },
		  success:  function(data) {
				try {
					if(data == "1"){
						 $("#uTelAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>电话号码已存在，<a href='"+base+"user/login'>跳转登录</a></small>");
						 $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
						 $("#getSecCode").attr("disabled","disabled");
					}else if(data == "2"){
						 $("#uTelAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-success'>电话号码可以申请</small>");
						 $("#getSecCode").removeAttr("disabled");
	                     $("#getSecCode").attr("class","am-btn am-btn-primary");
                    }else{
                    	 $("#uTelAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>未知错误</small>");
                    	 $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
						 $("#getSecCode").attr("disabled","disabled");
                    }
				} catch (e) {
               	     $("#uTelAlert").html("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<small class='am-text-danger'>网络错误</small>");
               	     $("#getSecCode").attr("class","am-btn am-btn-default am-btn-block");
					 $("#getSecCode").attr("disabled","disabled");
				}
			},
		
			error: function (jqXHR, textStatus, errorThrown) {
	            
	        },
		});
}
	


function intiPageList(url) {
	var title = $("#title").val();
	var type = $("#type").val();
	if("all"==type){
		type = "";
	}
	var pageno = $("#pageno").val();
	$.ajax({
		  type: 'POST',
		  url:url,
		  data: {
			  "title" : title,
			  "type" : type
		  },
		  success:  function(data) {
				try {
					$("#showPage").empty();
					var count = data;
					var page = (count/15)+1;
					for(var i=1;i<page;i++){
						if(i==pageno){
							var items = '<li class="am-active"><a onclick="a('+i+')">'+i+'</a></li>'
						}else{
							var items = '<li><a onclick="a('+i+')">'+i+'</a></li>'
						}
						
						$("#showPage").append(items);
					}
				} catch (e) {
             	    
				}
			},
		
			error: function (jqXHR, textStatus, errorThrown) {
	            
	        },
		});
}

function getVoteListByPage(url) {

	
	var title = $("#title").val();
	var type = $("#type").val();
	var pageno = $("#pageno").val();
	
	if("all"==type){
		type = "";
	}
	$.ajax({
				type : "POST",
				url:url,
				data: {
					"pageno" : pageno,
					"title" : title,
					"type" : type
				},
				dataType : "json",
				success : function(data) {
					
					$("#showtable").empty();
					$.each(data, function(i, result) {
						url = url.replace("getVoteListByPage","update");
						var items = '<tr><td><input type="checkbox" value="'+result.id+'" name="voteid"/></td><td>'+result.question+'</td><td>'
												+ '<a href="#">'+result.active+'</a></td>'
												+ '<td>'+result.type+'</td>'
												+ '<td class="am-hide-sm-only">'+result.qa+'</td>'
												+ '<td class="am-hide-sm-only">'+result.qb+'</td>'
												+ '<td class="am-hide-sm-only">'+result.qc+'</td>'
												+ '<td class="am-hide-sm-only">'+result.qd+'</td>'
												+ '<td><div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs">'
												+ '<button class="am-btn am-btn-default am-btn-xs am-text-secondary" ><a href='+url+'?id='+result.id+'><span class="am-icon-pencil-square-o"></span> 编辑</a></button>'
												+ '<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="active('+result.id+')"><span class="am-icon-copy"></span> 激活</button>'
												+ '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="del('+result.id+')"><span class="am-icon-trash-o"></span> 删除</button>'
												+ '</div></div></td></tr>'
												

										$("#showtable").append(items);
						});

				},
				error : function() {

				}
			});
}
	
function ajaxactive(base,number,type,i){
	
	$.ajax({
		  type: 'POST',
		  url:base+"vote/active",
		  data: {
			  "number" : number,
			  "type" : type
			  
		  },
		  success:  function(data) {
			  try {
					if(data == "1"){
						alert("成功激活"+i+"条记录");
						getVoteListByPage(base+"vote/getVoteListByPage");
						intiPageList(base+"vote/getCount");
					}else if(data == "2"){
						alert("成功取消激活"+i+"条记录");
						getVoteListByPage(base+"vote/getVoteListByPage");
						intiPageList(base+"vote/getCount");
					}else{
						alert("active失败");
					}
				} catch (e) {
					alert("失败");
				}
			},
		
			error: function (jqXHR, textStatus, errorThrown) {
				alert("error");
	        },
		});
}
