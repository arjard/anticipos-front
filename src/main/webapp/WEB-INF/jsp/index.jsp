<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
 <html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymleaf.org">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
<!-- 		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css"> -->

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="../resources/css/style.css">
	</head>

	<body>

		<div class="wrapper">
			<div class="inner">
				<form action="">
					<h3>Loggin</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
					<label class="form-group">
						<input type="text" class="form-control"  required>
						<span>Usuario</span>
						<span class="border"></span>
					</label>
					<label class="form-group">
						<input type="password" class="form-control"  required>
						<span for="">Contraseña</span>
						<span class="border"></span>
					</label>
					<!-- <label class="form-group" >
						<textarea name="" id="" class="form-control" required></textarea>
						<span for="">Your Message</span>
						<span class="border"></span>
					</label> -->
					<button>Entrar
						<i class="zmdi zmdi-arrow-right"></i>
					</button>

          <a href="#" class="link-pass-recover">Olvide mi Contraseña</a>
				</form>
			</div>
		</div>

	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>