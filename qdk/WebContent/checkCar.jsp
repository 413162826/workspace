
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/static/jquery.js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="${path}/static/mycss/checkCar.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Button trigger modal -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body" id="modelBody">
					#myModal #myModal
					<table class="table table-bordered table-striped" id="carDetail">
						<colgroup>
							<col class="col-xs-1">
							<col class="col-xs-7">
						</colgroup>
						<thead>
							<tr>
								<th>Class</th>
								<th>描述</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<div id="showPic"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary ">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	<form action="${path}/check/check" method="get">
		<table class="table table-bordered table-striped" id="CarMsgTable">
			<colgroup>
				<col class="col-xs-1">
				<col class="col-xs-4">
			</colgroup>
			<thead>
				<tr>
					<th id="carId" name="carId">carId</th>
					<th id="carNumber" name="carNumber">carNumber</th>
					<th>详细信息</th>
					<th>审核情况</th>
					<th>remark</th>
					<th>提交</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url : "${path}/check/showCarMsg",
				type : "get",
				success : function(result) {
					console.log(result);
					showBaseData(result);

				}
			});
		});

		function showBaseData(result) {
			var list = result.extend.pageInfo.list;
			console.log(list);
			$.each(list, function(index, item) {
				var carIdTd = $("<td></td>").append(item.carId);
				var carNumberTd = $("<td></td>").append(item.carNumber);
				var detailBtn = $("<button></button>").attr("data-toggle",
						"modal").attr("data-target", "#myModal").attr("type",
						"button").addClass("btn btn-primary detail_msg_btn")
						.append("详细信息");
				//给detailBtn传递car-id
				detailBtn.attr("car-id", item.carId);
				var booleanCheckTd = $("<td></td>").append(
						$("<input></input>").attr("type", "radio").attr("name",
								"radio" + item.carId).attr("id",
								"radio" + item.carId).attr("value", "1"))
						.append("成功").append(
								$("<input></input>").attr("type", "radio")
										.attr("name", "radio" + item.carId)
										.attr("id", "radio" + item.carId).attr(
												"value", "2").attr("checked",
												"checked")).append("失败");
				/* <td><input type="text" id="remark" name="remark" /></td> */
				var remarkTd = $("<td></td>").append(
						$("<input></input>").attr("type", "text").attr("id",
								"remark" + item.carId).attr("name",
								"remark" + item.carId));
				var submitbtn = $("<input></input>").addClass(
						"btn btn-success submit-btn").attr("type", "button")
						.attr("submitId", item.carId).attr("value", "提交");

				$("<tr></tr>").append(carIdTd).append(carNumberTd).append(
						detailBtn).append(booleanCheckTd).append(remarkTd)
						.append(submitbtn).appendTo("#CarMsgTable tbody");

				/* showDetail(item); */
				console.log("index:" + index);
				console.log(item);
			});
		}

		$(document).on("click", ".detail_msg_btn", function() {
			$("#carDetail tbody").empty();
			var carid = $(this).attr("car-id");
			getCarDetailMsg(carid);

		});

		function showDetail(item) {

			var car_id = $("<tr></tr>").append(
					$("<th></th>").attr("scope", "row").append(
							$("<code></code>").append("car_id"))).append(
					$("<td></td>").append(item.extend.pageInfo.carId))
					.appendTo("#carDetail tbody");
			var car_number = $("<tr></tr>").append(
					$("<th></th>").attr("scope", "row").append(
							$("<code></code>").append("car_number"))).append(
					$("<td></td>").append(item.extend.pageInfo.carNumber))
					.appendTo("#carDetail tbody");
			var car_type = $("<tr></tr>").append(
					$("<th></th>").attr("scope", "row").append(
							$("<code></code>").append("car_type"))).append(
					$("<td></td>").append(item.extend.pageInfo.carType))
					.appendTo("#carDetail tbody");
			var car_brand = $("<tr></tr>").append(
					$("<th></th>").attr("scope", "row").append(
							$("<code></code>").append("car_brand"))).append(
					$("<td></td>").append(item.extend.pageInfo.carBrand))
					.appendTo("#carDetail tbody");
			var car_volume = $("<tr></tr>").append(
					$("<th></th>").attr("scope", "row").append(
							$("<code></code>").append("car_volume"))).append(
					$("<td></td>").append(item.extend.pageInfo.carVolume))
					.appendTo("#carDetail tbody");
			//<img src="/i/eg_tulip.jpg"  alt="上海鲜花港 - 郁金香" />
			/* var car_license_front = $("<tr></tr>")
					.append($("<th></th>").append(
							$("<code></code>").append("car_LicenseFront")))
					.append($("<td></td>")
							.append($("<img></img>").attr("src","http://192.168.20.111:8080/images"+ item.extend.pageInfo.carLicenseFront).addClass("car_LicenseFront_img")))
					.appendTo("#carDetail tbody"); */
			
			var showLicense = $("<div></div>").attr("id","license")
			.append($("<p></p>").append("行驶证"))
			.append($("<div></div>").addClass("licenseImg")
					.append($("<a></a>").attr("href","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg").append($("<img></img>").attr("id","img1").attr("src","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg"))))
			.append($("<div></div>").addClass("licenseImg")
					.append($("<a></a>").attr("href","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg").append($("<img></img>").attr("id","img1").attr("src","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg"))))			
			.appendTo("#myModal #showPic");
					
					
			var showCarPic = $("<div></div>").attr("id","carPic")
			.append($("<p></p>").append("车辆近照"))
			.append($("<div></div>").addClass("carImg")
					.append($("<a></a>").attr("href","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg").append($("<img></img>").attr("id","img1").attr("src","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg"))))
			.append($("<div></div>").addClass("carImg")
					.append($("<a></a>").attr("href","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg").append($("<img></img>").attr("id","img1").attr("src","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg"))))
			.append($("<div></div>").addClass("carImg")
					.append($("<a></a>").attr("href","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg").append($("<img></img>").attr("id","img1").attr("src","http://192.168.20.111:8080/images/carLicenseFront/2018-04-28/20180428121022_118031.jpg"))))
			.appendTo("#myModal #showPic");
					
			
			//.appendTo("#myModal #showPic")
		}

		//
		function getCarDetailMsg(id) {
			$.ajax({
				//根据id查询详细信息
				url : "${path}/check/detailMsg/" + id,
				type : "GET",
				success : function(result) {
					showDetail(result);
				}
			})
		}

		//异步提交
		$(document).on(
				"click",
				".submit-btn",
				function() {
					alert("提交成功");
					//获取审核&remark的值
					var remark_id = "#remark" + $(this).attr("submitid");
					var radio_id = "#radio" + $(this).attr("submitid");
					var remark_id_val = $(remark_id).val();
					var radio_id_val = $(radio_id).val();

					var radioName = $(this).attr("name");
					$.ajax({
						type : 'post',
						url : "${path}/check/check/",
						data : 'remark=' + remark_id_val + '&radio='
								+ radio_id_val + '&id='
								+ $(this).attr("submitid"),
						cache : false,
						dataType : 'json',
						success : function(data) {
							console.log(data);
						}
					});

				});
	</script>
</body>
</html>