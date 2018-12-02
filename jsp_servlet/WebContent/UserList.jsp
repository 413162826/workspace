<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- bootstrap-->
<!-- bootstrap-->
<script src="${path}/static/bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script src="${path}/static/bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link
	href="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/css/bootstrap-datepicker3.css"
	rel="stylesheet">
<script
	src="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/js/bootstrap-datepicker.js"></script>
<script
	src="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>

<link
	href="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/css/test.css"
	rel="stylesheet" />
<script
	src="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/js/test.js"></script>
</head>
<body>


	<!-- Add模态框 -->
	<div id="add_model_button" class="modal fade bs-example-modal-lg"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<h1 style="margin-right: 100px;">
					<font size="+20" color="#000000">新增User</font>
				</h1>
				<form class="form-horizontal" style="border: 10px">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">UserID</label>
						<div class="col-sm-10">
							<input type=text class="form-control" id="add_UserID"
								placeholder="UserID">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">UserName</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="add_UserName"
								placeholder="UserName"> <span class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3"
							class=" form-group-title  col-sm-2 control-label">UserBirth</label>
						<div class="input-group date  col-sm-10">
							<input type="text"
								class=" form-control date-picker form-control-left  form-control"
								id="add_UserBirth" placeholder="UserBirth">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">UserSex</label>
						<input type='radio' class='check_item' name="add_UserSex"
							id="add_UserSex" value="M" checked="checked">男 <input
							type='radio' class='check_item' name="add_UserSex"
							id="add_UserSex" value="F">女
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">UserHobby</label>
						<input type="checkbox" name="test" value="摄影" /><span>摄影</span> <input
							type="checkbox" name="test" value="旅游" /><span>旅游</span> <input
							type="checkbox" name="test" value="滑雪" /><span>滑雪</span>
						<!-- <select id="add_UserHobby">
								<option value="摄影">摄影</option> 
								<option value="旅游">旅游</option> 
								<option value="滑雪">滑雪</option> 
							</select> -->
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">UserHobby</label>

						<select id="add_UserHobby">
							<option value="广东工业大学">广东工业大学</option>
							<option value="深圳大学">深圳大学</option>
							<option value="华南理工大学">华南理工大学</option>
						</select>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="add_submit_button" type="submit"
								class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



	<!-- Select模态框 -->
	<!-- <div id="select_model_button" class="modal fade bs-example-modal-lg"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<h1 style="margin-right: 100px;">
					<font size="+20" color="#000000">查询User</font>
				</h1>
				<form class="form-horizontal" style="border: 10px">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">请输入你要查询用户的id：</label>
						<div class="col-sm-10">
							<input type=text class="form-control" id="select_UserID"
								placeholder="UserID">
						</div>
					</div>

					<table class="table table-hover" id="select_user_tables">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Birth</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="select_submit_button" type="submit"
								class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div> -->

	<!-- 查询栏 -->
	<div id="select_div">
		<form class="form-horizontal" style="border: 10px">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">请输入你要查询用户的id：</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="select_UserID"
						placeholder="UserID">
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">请输入你要查询用户的name：</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="select_UserName"
						placeholder="UserName">
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">请输入你要查询用户的School：</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="select_UserSchool"
						placeholder="UserSchool">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="user_select_button" type="button" class="btn btn-info">查询</button>
				</div>
			</div>

		</form>
	</div>
	<!-- 内容栏 -->
	<div>
		<!-- 弹出一条模态框，填写基本信息 -->
		<button type="button" class="btn btn-success" id="user_add_button">增加</button>

		<!--
1.页面展示使用多种形式（radio 、 checkbox 、下拉框、日期选择等）  
2.多种条件查询( 包括匹配模式 )
3.清空当前屏幕，并显示新的数据
 -->
		<!-- <button type="button" class="btn btn-info" id="user_select_button">查询</button> -->

		<table class="table table-hover" id="user_tables">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Birth</th>
					<th>Sex</th>
					<th>Hobby</th>
					<th>School</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<!-- 导航条 -->
	<div class="col-md-6" id="page_nav_area"></div>


	<script type="text/javascript">
	var currentPage = 1;//当前页
	var totalRecoad = 1; //总记录数
	var pageSize = 5;  //后台已经定死了，需要修改dao层
	var lastPage = (totalRecoad%pageSize == 0)?(Math.floor(totalRecoad/pageSize)):(Math.floor(totalRecoad/pageSize)+1);
	
		$(function() {
			//根据查询条件跳转
			toPage(currentPage);
			//$('#user_select_button').trigger("click");
		});

		/* function to_page(pn) {
			$.ajax({
				url : "${path}/userServlet",
				type : "get",
				success : function(result) {
					//解析显示分页信息
					build_user_table(result);
				}
			});
		} */

		//调用servlet展示User列表
		function build_user_table(result) {
			//先清空再构建
			$("#user_tables tbody").empty();

			//使用js的遍历方法
			$.each(JSON.parse(result), function(index, item) {

				//foreach:emps是list对象，item是list的emp对象,index下标
				var userIdTd = $("<td></td>").append(
						$("<span></span>").append(item.id));
				var userNameTd = $("<td></td>").append(
						$("<div></div>").append(item.name)).addClass(
						"edit_name_td");
				var userBirthTd = $("<td></td>").append(
						$("<div></div>").append(item.birth)).addClass(
						"edit_birth_td");
				var userSexTd = $("<td></td>").append(
						$("<div></div>").append(item.sex)).addClass(
						"edit_sex_td");
				var userHobbyTd = $("<td></td>").append(
						$("<div></div>").append(item.hobby)).addClass(
						"edit_hobby_td");
				var userSchoolTd = $("<td></td>").append(
						$("<div></div>").append(item.school)).addClass(
						"edit_school_td");
				/* <button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button> */

				//确认按钮（默认隐藏，点击编辑出现）
				var editSurebtn = $("<button></button>").addClass(
						"btn btn-default btn-sm edit_sure_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("确认");
				editSurebtn.attr("user_edit_sure_button", item.id);

				//编辑按钮
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加自定义属性，来表示当前员工id
				editBtn.attr("user_edit_button", item.id);

				//删除按钮
				var delBtn = $("<button></button>").addClass(
						"btn btn-danger btn-sm delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				//为删除按钮添加自定义属性，来表示当前员工id
				delBtn.attr("user_del_button", item.id);

				//按钮
				var btnTd = $("<td></td>").append(editBtn).append(" ")
				.append(delBtn).append(" ").append(editSurebtn);

				var table_tr_id = "tr" + item.id;

				//append方法执行完返回员原来的原来的元素
				$("<tr></tr>").append(userIdTd).append(userNameTd).append(
						userBirthTd).append(userSexTd).append(userHobbyTd)
						.append(userSchoolTd).append(btnTd).attr("id",
								table_tr_id).appendTo("#user_tables tbody");
				$(".edit_sure_btn").hide();
			});
		}

		//显示新增模态框
		$("#user_add_button").click(function() {

			//弹出模态框
			$("#add_model_button").modal({
				backdrop : "static"
			});
		});

		//提交Add模态框的数据+校验模态框的数据
		$("#add_submit_button").click(
				function() {
					//获得新增数据
					var id = $("#add_UserID").val();
					var name = $("#add_UserName").val();
					var birth = $("#add_UserBirth").val();
					var sex = $("input[name='add_UserSex']:checked").val();
					var check_val = document.getElementsByName("test");
					var hobby = [];
					for (k in check_val) {
						if (check_val[k].checked)
							hobby.push(check_val[k].value);
					}
					var school = $("#add_UserHobby").val();
					//alert("hobby:"+hobby);
					//alert("school"+school);

					var this_url = "${path}/userAdd" + "?id=" + id + "&name="
							+ name + "&birth=" + birth + "&sex=" + sex
							+ "&hobby=" + hobby + "&school=" + school;

					//前段校验(校验规则：校验用户姓名：只能输入4-30个以字母开头的字串)
					var regName = /^[a-zA-Z]{4,30}$/;
					if (!regName.exec(name)) {
						show_validate_msg("#add_UserName", "error", "名字输入不正确");
						return false;
					} else {
						show_validate_msg("#add_UserName", "success", "");
					}
					//后台校验（唯一性约束）
					$.ajax({
						url : this_url,
						type : "POST",
						success : function(result) {
							$("#add_submit_button").modal("hide");
							toPage(1);
						}
					});
				});

		//显示校验结果的提示信息
		function show_validate_msg(ele, status, msg) {
			//移除当前元素校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}

		//显示查询模态框
		$("#user_select_button").click(
				function() {

					var select_id = $("#select_UserID").val();
					var select_name = $("#select_UserName").val();
					var select_school = $("#select_UserSchool").val();
					var page = currentPage;
					var this_url = "${path}/userSelect" + "?id=" + select_id
							+ "&name=" + select_name + "&school="
							+ select_school + "&page=" + page;
					$.ajax({
						url : this_url,
						type : "get",
						success : function(data) {
							var jsonData = eval("("+data+")");
							totalRecoad = jsonData.key1//记录数
							build_user_table(jsonData.key2);//创建导航条
							lastPage = (totalRecoad%pageSize == 0)?(Math.floor(totalRecoad/pageSize)):(Math.floor(totalRecoad/pageSize)+1);
						 	//alert("page:"+ page +",lastPage:"+ lastPage);
							//当前页数如果超过总页数，则返回最后一页
							if(page > lastPage){
								var numLiI = ".numLi"+lastPage; 
								$(numLiI).trigger("click");
							}
							build_page_nav(jsonData.key2);//构建导航条
							build_user_table(jsonData.key2);
						}
					});
					//输入完清空输入框值(不清空，清空的话，分页功能不方便查询数据)
					/* document.getElementById("select_UserID").value = "";
					document.getElementById("select_UserName").value = "";
					document.getElementById("select_UserSchool").value = ""; */
				});

		//编辑按钮
		$(document).on("click", ".edit_btn", function() {
			var edit_id = $(this).attr("user_edit_button");
			var tr_id = "tr" + edit_id;
			var pattern = "#" + tr_id + " td div";
			var pattern_sure_btn = "#" + tr_id + " .edit_sure_btn";
			//$(pattern).contents().unwrap().wrap('<input/>');//标签替换
			$(pattern).replaceWith(function(){
				  return $("<input />").append($(this).contents());
				});
			
			$(pattern_sure_btn).show();	
		})

		//编辑确认按钮
		$(document).on("click", ".edit_sure_btn", function() {
			//"#"+edit_id +" #edit_name_td input" 
			var edit_id = $(this).attr("user_edit_sure_button");
			var pattern_name = "#tr" + edit_id + " .edit_name_td input";
			var pattern_birth = "#tr" + edit_id + " .edit_birth_td input";
			var pattern_sex = "#tr" + edit_id + " .edit_sex_td input";
			var pattern_hobby = "#tr" + edit_id + " .edit_hobby_td input";
			var pattern_school = "#tr" + edit_id + " .edit_school_td input";
			var pattern = "#tr" + edit_id + " td input";
		
			var name = $(pattern_name).val();
			var birth = $(pattern_birth).val();
			var sex = $(pattern_sex).val();
			var hobby = $(pattern_hobby).val();
			var school = $(pattern_school).val();
			
			var this_url = "${path}/userUpdate" + "?id=" + edit_id + "&name=" + name
			+ "&birth=" + birth + "&sex="
			+ sex+ "&hobby=" + hobby + "&school="
			+ school;
			$.ajax({
				url : this_url,
				type : "post",
				success : function(result) {
				}
			});
			 $(".edit_sure_btn").hide();
			 
			 $(pattern).replaceWith(function(){
				  return $("<div />").append($(this).contents());
				});
			 //其实可以不刷新页面的，只是标签替换没得替换值
			 window.location.reload();
		})
		
		//删除按钮
		$(document).on("click", ".delete_btn", function() {
			var id = $(this).attr("user_del_button");
			var this_url = "${path}/userDel" + "?id=" + id;
			$.ajax({
				url : this_url,
				type : "get",
				success : function(result) {
					alert("删除");
					window.location.reload();
				}
			});
		});
		
		//分页功能
		function toPage(pn){
			currentPage = pn;
			$('#user_select_button').trigger("click");
			
		}
		//构建导航条
		function build_page_nav(result){

			//最后一页，不赋值只会等于1
			lastPage = (totalRecoad%pageSize == 0)?(Math.floor(totalRecoad/pageSize)):(Math.floor(totalRecoad/pageSize)+1);
			
			//清空导航
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");

			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));

			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;").attr("href", "#"));

			if (currentPage == 1) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//为元素添加翻上一页事件,首页时间
				firstPageLi.click(function() {
					currentPage = 1;
					//alert(currentPage);
					toPage(currentPage);
				});

				prePageLi.click(function() {
					currentPage = currentPage - 1;
					//alert(currentPage);
					toPage(currentPage);
				});
			}

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;").attr("href", "#"));

			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#").addClass("lastPageLi"));
			
			if (currentPage == lastPage){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				//为元素添加翻下一页事件,末页时间
				nextPageLi.click(function() {
					currentPage = currentPage +1;//currentPage++; 
					//alert(currentPage);
					toPage(currentPage);
				});

				lastPageLi.click(function() {
					currentPage = lastPage;
					//alert(currentPage);
					toPage(currentPage);
				});
			}

			//添加首页前一页
			ul.append(firstPageLi).append(prePageLi);
			
			for (var i=1;i<=lastPage;i++)
			{
				var numLi = $("<li></li>").append($("<a></a>").append(i).addClass("numLi"+i));
				
				if (currentPage == i) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					//遍历完才会按按钮，所以都是i的值都是上限
					currentPage = parseInt($(this).text());    //.text()得到字符串类型
					 //alert(currentPage);
					toPage(currentPage);
				});
				ul.append(numLi);
			}
			
			//添加后一页，下一页
			ul.append(nextPageLi).append(lastPageLi);

			//把ul添加到nav中
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		
	</script>
</body>
</html>