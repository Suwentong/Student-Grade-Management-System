<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改老师信息</title>
	<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css">
	<style type="text/css">
		.layui-form{
			width: 50%;
			margin-left: 10%;
			margin-top: 5%;
		}
		.layui-input-block{
			margin-top: 50px;
		}
		.blank{
			margin-left: 50%;
		}
	</style>
</head>
<body>
<h1 style="margin-left: 200px;color: #009688;margin-top: 40px;">修改老师信息</h1>
	<form class="layui-form" action="updatetea" method="post">
	  <div class="layui-form-item">
	    <label class="layui-form-label">用户名</label>
	    <div class="layui-input-block">
	      <input type="text" name="logn" value="${teacher.gh}" required  lay-verify="required" placeholder="请输入用户名"  class="layui-input">
	    </div>
	  </div>
	  <br>
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码</label>
	    <div class="layui-input-inline">
	      <input type="password" name="pswd" value="${teacher.pswd}" required lay-verify="required" placeholder="请输入密码" class="layui-input">
	   	</div>
	  </div>
	 <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-block">
	      <input type="text" name="xm" value="${teacher.xm}" required  lay-verify="required" placeholder="请输入姓名" class="layui-input">
	    </div>
	  </div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<select name="xb" lay-verify="required">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
		</div>
		<div style="display:none"><input type="text" name="gh" value="${teacher.gh}"></div>
		<div class="layui-form-item">
			<label class="layui-form-label">出生日期</label>
			<div class="layui-input-block">
				<input type="text" name="csrq" value="${teacher.csrq}" required  lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">职称</label>
			<div class="layui-input-block">
				<select name="Zc" lay-verify="required">
					<option value="讲师">讲师</option>
					<option value="副教授">副教授</option>
					<option value="教授">教授</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">基本工资</label>
			<div class="layui-input-block">
				<input type="text" name="jbgz" value="${teacher.jbgz}" required  lay-verify="required" placeholder="请输入基本工资" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">院系号</label>
			<div class="layui-input-block">
				<select name="yxh" lay-verify="required">
					<option value="01">01 - 计算机学院</option>
					<option value="02">02 - 通讯学院</option>
					<option value="03">03 - 材料学院</option>
				</select>
			</div>
		</div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
	      <span class="blank"></span>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	</form>
 <script type="text/javascript" src="static/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
});
</script>
</body>
</html>