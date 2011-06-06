<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel = "stylesheet"  type = "text/css" href = "http://localhost:8080/E-Commerce/global.css" />
<title>ECommerce</title>
</head>
<body id = "home">


<!-- Bloque Encabezado -->
<div id = "encabezado" class = "limpiar">



<div id = "busqueda">
<form action="browser" method = "GET">
<fieldset id = "browser">
<ul>
<li><input type="text" name = "busqueda" />
<input type="submit" name = "buscar" value="buscar"/> 


<a href = "publicacion.html">Vender</a></li>

</ul>
</fieldset>
</form>	
</div>

<!-- Bloque Vender -->
<div id = "vender">
	
</div>




<!-- Fin Blogue Encabezado -->
</div>

<div id = "lateralDerecho" class = "limpiar">



<%

session = request.getSession();
%>
<%if(session==null){%>
<!-- Bloque Login -->
<div id = "loginDiv">	
<form action = "login" method = "POST" >
<fieldset id = "login">
<legend>Login</legend>
<ul>
<li>
	<label>login:</label>
	<input type="text" name = "login"/></li>
<li>
	<label>password:</label>
	<input type="password" name = "pass"/></li>
<li>
	<input type="submit" name = "ingresar" value="ingresar"/></li>
</ul>

</fieldset>
</form>
</div>
	
 <%}
else{%>
<div id = "loginDiv2">
<ul>
	<li><a href = <%session.getAttribute("id_user");%>>Usuario</a></li>
	</ul>
</div>
<%}%>






	
<div id = "registroDiv">
<!-- Si colocamos POST, hay que tener en cuenta que el navegador no puede 
	pedir un recurso, por ende no se puede hacer /register
 -->
 
<form name = "register" action = "register" method = "POST" >

<fieldset id = "registro">

<legend>Registrarse</legend>
<ul>
<li>
	<label>E-Mail:</label>
	<input type="text" name = "mail"/>
</li>
<li>
<label>Password:</label>
	<input type="password" name = "pass"/>
</li>
<li>
	<input type="submit" name = "registrar" value="Registrar"/>
</li>

</ul>
</fieldset>

</form>
</div>

<div id = "suscripciones">
<form action = "suscripcion" method = "POST">
<fieldset>
<legend>Suscripcion a ofertas semanales</legend>
<ul>
<li>
	<label>Mail:</label> <input type="text" name = "mail"/>
</li>
<li>
	<input type="submit" name = "suscripcion" value="Enviame"/>
</li>

</ul>
</fieldset>
</form>
</div>

<!-- Fin Bloque Lateral Derecho -->
</div>




<div id = "lateralIzquierdo" class = "limpiar">





<div id = "categoria">
<select name="Categorias" size="30">
Categorias
<option>Televisores</option>
<option>Hardware</option>
<option>Software</option>

</select>
</div>

<!-- Fin Bloque Lateral Izquierdo -->

<div id = "contenido" class = "limpiar">


<div id = "destacados">
<h1>Publicaciones Destacadas</h1>



</div>

</div>

</div>
</body>
</html>