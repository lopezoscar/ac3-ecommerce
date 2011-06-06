<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel = "stylesheet"  type = "text/css" href = global.css />
<title>Publicacion</title>
</head>
<body>


<%if(session!=null){ %>
<form name = "publicacion" action = "publication" method = "GET">

<fieldset id= "publicacion">
<ul>

<li><label>Titulo</label> <input type = "text" name = "titulo"></li>
<li><label>Nombre Producto</label> <input type = "text" name = "producto"></li>
<li><label>Imagenes </label> <input type="file" name = "imagen"></li>
<li><label>Precio</label><input type = "text" name = "precio"></li>




<li>
<label>Seleccione Categoria:</label>
<input type = "text" name = "categoria">
</li>
<li>
<label>Seleccione Medios de Pago:</label>
<input type = "text" name = "medioPago">
</li>

<li><textarea name ="descripcion">Escribe aqui la descripcion del producto</textarea></li>

<li><input type = "submit" value = "Publicar" name = "publicar"></li>

<li><input type = "reset" value = "Reset" name = "reset"></li>
</ul>
</fieldset>
</form>

<%}else{%>
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
	
<%}%>
	
	
  


</body>
</html>