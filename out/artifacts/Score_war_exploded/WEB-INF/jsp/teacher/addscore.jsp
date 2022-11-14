<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>录入成绩</title>
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

<table class="layui-table" lay-data="{width: 1130, height:500, url:'stuscore?Gh='+${teacher.gh}, page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
		<th lay-data="{field:'Xh', align:'center', width:100, sort: true}">学号</th>
		<th lay-data="{field:'xm', align:'center', width:140, sort: true}">姓名</th>
		<th lay-data="{field:'km', align:'center', width:180}">课程名</th>
        <th lay-data="{field:'pscj', align:'center', width:100}">平时成绩</th>
		<th lay-data="{field:'kscj', align:'center', width:100}">考试成绩</th>
        <th lay-data="{field:'zpcj', align:'center', width:100}">总评成绩</th>
      <th lay-data="{field:'pjjd', align:'center', width:100}">平均绩点</th>
      <th lay-data="{fixed: 'right', width:300, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-radius layui-btn-xs" lay-event="add_pscj">平时成绩</a>
  <a class="layui-btn layui-btn-radius layui-btn-xs" lay-event="add_kscj">考试成绩</a>
  <a class="layui-btn layui-btn-radius layui-btn-xs" lay-event="add_zpcj">总评成绩</a>
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
      if(obj.event === 'add_pscj'){
        layer.prompt({title:'请输入成绩'},function(value){
          window.location.href="updatepscj?Xh="+data.Xh+"&km="+data.km+"&score="+value+"";
        });
      } else if(obj.event === 'add_kscj'){
        layer.prompt({title:'请输入成绩'},function(value){
          window.location.href="updatekscj?Xh="+data.Xh+"&km="+data.km+"&score="+value+"";
        });
      } else if(obj.event === 'add_zpcj'){
        layer.prompt({title:'请输入成绩'},function(value){
          window.location.href="updatezpcj?Xh="+data.Xh+"&km="+data.km+"&score="+value+"";
        });
      }
    });
    var $ = layui.$, active = {
      checkname: function(){ //弹出对话框
        layer.prompt({title:'请输入名字的一部分'},function(value){
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