<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Layui</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	<style type="text/css">
		.layui-table{
			width: 50%;
			margin-left: 25%;
		}
	</style>
</head>
<body>
<br>


<table class="layui-table" lay-data="{width: 1200, height:500, align:'center', url:'coursescore?Xh='+${student.xh}, page:true, id:'idTest'}" lay-filter="demo">
	<thead>
	<tr>
		<th lay-data="{field:'kh', width:250, align:'center', sort: true}">课程号</th>
		<th lay-data="{field:'km', width:350, align:'center'}">课程名</th>
		<th lay-data="{field:'pscj', width:200, align:'center'}">平时成绩</th>
		<th lay-data="{field:'kscj', width:200, align:'center'}">考试成绩</th>
		<th lay-data="{field:'zpcj', width:200, align:'center'}">总评成绩</th>
	</tr>
	</thead>
</table>

<script src="static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	layui.use(['table','layer'], function(){
		var table = layui.table
				,layer = layui.layer
				,$ = layui.$;
		//监听工具条
		var $ = layui.$, active = {
			checkname: function(){ //弹出对话框
				layer.prompt({title:'请输入教师号:'},function(value){
					window.location.href="hrefmohuname?stuname="+value+"";
				});
			}
		};
		$('.demoTable .layui-btn').on('click', function(){
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
	});
</script>

</body>
</html>