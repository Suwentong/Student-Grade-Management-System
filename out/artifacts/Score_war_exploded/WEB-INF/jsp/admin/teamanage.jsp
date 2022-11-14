<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>老师管理</title>
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

<table class="layui-table" lay-data="{width: 1200, height:500, url:'teamanage', page:false, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'Gh', width:100, sort: true, align:'center'}">工号</th>
      <th lay-data="{field:'xm', width:100, align:'center'}">姓名</th>
      <th lay-data="{field:'xb', width:60, align:'center'}">性别</th>
      <th lay-data="{field:'csrq', width:150, align:'center'}">出生日期</th>
      <th lay-data="{field:'Zc', width:100, align:'center'}">职称</th>
      <th lay-data="{field:'jbgz', width:100, align:'center'}">基本工资</th>
      <th lay-data="{field:'yxh', width:100, align:'center'}">院系号</th>
      <th lay-data="{field:'logn', width:100, align:'center'}">登录名</th>
      <th lay-data="{field:'pswd', width:100, align:'center'}">密码</th>
      <th lay-data="{fixed: 'right', width:280, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  <a class="layui-btn layui-btn-warm  layui-btn-xs" lay-event="edit">修改</a>
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
    if(obj.event === 'del'){
    	window.location.href="deltea?id="+data.Gh+"";
    } else if(obj.event === 'edit'){
    	window.location.href="hrefxiutea?Gh="+data.Gh+"";
    }
  });
  var $ = layui.$, active = {
    checkname: function(){ //弹出对话框
    	layer.prompt({title:'请输入名字的一部分'},function(value){
    		window.location.href="hrefmohunametea?teaname="+value+"";
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