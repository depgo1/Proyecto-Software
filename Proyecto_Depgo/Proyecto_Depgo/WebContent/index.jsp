<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de Inicio de DepGo</title>
<!-- InstanceEndEditable -->
<style type="text/css">
txt {
	font-family: "Arial Black", Gadget, sans-serif;
}
</style>

</head>
<body background="img/fondo.jpeg" >

<table width="200" border="0" align="right">
  <tr>
    <td><img src="img/logo.jpg" width="323" height="63" /></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="439" border="0" align="center">
  <tr>
    <td><img src="img/fondo2.jpg" width="318" height="43" /></td>
  </tr>
</table>
<% String mensaje=(String)request.getAttribute("mensaje"); %>
<table width="438" border="0" align="center" background="img/fondo1.jpg" >
  <tr>
    <td align="center"><!-- InstanceBeginEditable name="EditRegion1" -->
    <form name="login" action="login" method="post">
<table width="432" height="324" border="0"  background="img/333.jpg">
  <tr>
    <td width="40" rowspan="4"></td>
    <td height="77">&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
    
  <tr>
  
    <td width="165" align="center">
      <strong>Usuario </strong>: </td>
    <td width="213"><input name="txt_Usuario" type="text"></td>
  </tr>
  <tr>
    <td height="24" align="center">
      <strong>Contraseña</strong> : </td>
    <td><input name="txt_Contrasena" type="password"></td>
  </tr>
  <tr>
    <td height="189" align="center"><a class="lost-pwd" href="recuperarContrasena.jsp">&iquest;Olvidaste tu usuario y/o clave?</a></td>
    <td><input  type="submit" name="submit" value="Login" class="bt_login" /> <br>
       <%if(mensaje!=null){ %>
        <%=mensaje %>
        <%} %>
    </br>
    </td>
 
  </tr>
</table>
</form>
    <!-- InstanceEndEditable --></td>
  </tr>
</table>
</body>

</html>