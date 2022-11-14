<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改学生信息</title>
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
	<h1 style="margin-left: 200px;color: #009688;margin-top: 40px;">修改学生信息 ${student.xh}</h1>
	<form class="layui-form" action="updatestu">
	  <div class="layui-form-item">
	    <label class="layui-form-label">用户名</label>
	    <div class="layui-input-block">
	      <input type="text" name="logn" required  value="${student.logn}" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码</label>
	    <div class="layui-input-inline">
	      <input type="password" name="pswd" value="${student.pswd}" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
	   	</div>
	  </div>

		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" name="xm" required  value="${student.xm}" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<select name="xb" lay-verify="required" >
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
		</div>
		<div style="display:none"><input type="text" name="xh" value="${student.xh}"></div>
		<div class="layui-form-item">
			<label class="layui-form-label">出生日期</label>
			<div class="layui-input-block">
				<input type="text" name="csrq" required value="${student.csrq}" lay-verify="required" placeholder="请输出生日期" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">籍贯</label>
			<div class="layui-input-block">
				<input type="text" name="jg" required value="${student.jg}" lay-verify="required" placeholder="请输入籍贯" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-block">
				<input type="text" name="sjhm" required value="${student.sjhm}" lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
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