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

<div style="display:none"><input type="text" name="xh" value="${student.xh}"></div>
<table class="layui-table" lay-data="{width: 1200, height:500, url:'listcourse', page:true, id:'idTest'}" lay-filter="demo">
	<thead>
	<tr>
		<th lay-data="{field:'kh', width:224, align:'center', sort: true}">课程号</th>
		<th lay-data="{field:'km', width:184, align:'center'}">课程名</th>
		<th lay-data="{field:'xf', width:174, align:'center'}">学分</th>
		<th lay-data="{field:'xs', width:174, align:'center'}">学时</th>
		<th lay-data="{field:'yxh', width:144, align:'center'}">院系号</th>
		<th lay-data="{fixed: 'right', width:300, align:'center', toolbar: '#barDemo'}"></th>
	</tr>
	</thead>
</table>

<script type="text/html" id="barDemo">
	<a class="layui-btn  layui-btn-normal layui-btn-xs" lay-event="add">选课</a>
</script>

<script src="static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	layui.use(['table','layer'], function(){
		var table = layui.table
				,layer = layui.layer
				,$ = layui.$;
		//监听工具条
		table.on('tool(demo)', function(obj){
			var data = obj.data;
			var stu = ${student.xh};
			if(obj.event === 'add'){
				layer.prompt({title:'请输入教师工号'},function(value){
					window.location.href="hrefselectcourse?kh="+data.kh+"&Gh="+value+"&Xh="+stu+"";
				});
			}
		});
		var $ = layui.$, active = {
			checkname: function(){ //弹出对话框
				layer.prompt({title:'请输入课程号'},function(value){
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