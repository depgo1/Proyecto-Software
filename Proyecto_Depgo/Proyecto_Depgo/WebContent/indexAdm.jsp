<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.medio {
	text-align: center;
	font-family: "Times New Roman", Times, serif;
	font-weight: bold;
	color: #3E6A8E;
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
<table width="567" border="0" align="center">
  <tr>
    <td width="318" rowspan="2" align="left" valign="bottom"><img src="img/fondo2.jpg" width="318" height="43" /></td>
    <td width="239" bgcolor="#083763">&nbsp;</td>
  </tr>
  <tr>
  	<%@ page import="java.util.Date" %>
   <% Date fecha = new Date(); %>
   <%int mes= fecha.getMonth()+1; %>
   <% String mes1; %>
   
   <%if(mes==1){ %>
   <% mes1="Enero";%>
   <%}else if (mes==2){ %>
   <% mes1="Febrero"; %> 
   <%}else if (mes==3){ %>
   <% mes1="Marzo"; %>
   <%}else if (mes==4){ %>
   <% mes1="Abril"; %>
   <%}else if (mes==5){ %>
   <% mes1="Mayo"; %>
   <%}else if (mes==6){ %>
   <% mes1="Junio"; %>
   <%}else if (mes==7){ %>
   <% mes1="Julio"; %>
   <%}else if (mes==8){ %>
   <% mes1="Agosto"; %>
   <%}else if (mes==9){ %>
   <% mes1="Septiembre"; %>
   <%}else if (mes==10){ %>
   <% mes1="Octubre"; %>
   <%}else if (mes==11){ %>
   <% mes1="Noviembre"; %>
   <%} else{ %>
   <% mes1="Diciembre"; %>
   <%} %>
    <td align="center" bgcolor="#FFCC00"><%= ""+ (fecha.getDay()-3) +" de "+mes1+" del "+ (fecha.getYear()+1900)%></td>
  </tr>
</table>
<table width="565" border="0" align="center" background="img/fondo1.jpg" >
  <tr>
    <td width="451" align="center"><!-- InstanceBeginEditable name="EditRegion1" -->
    
      <table width="356" height="297" border="0" >
        <tr>
          <td colspan="2"  class="medio">Bienvenido al sistema control de pago de servicios para departamento</td>
        </tr>
        <tr>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td width="142" rowspan="3"  align="center" valign="middle"><img src="img/edificio.jpg" width="284" height="199" /></td>
          <td width="97" height="53"><input type="submit" name="depa" id="depa" value="Registro de Servicio" onclick="window.location.href='registroServicio.jsp'" /></td>
        </tr>
        <tr>
          <td valign="top"><input type="submit" name="depa" id="depa" value="Reportes" onclick="window.location.href='reportes.jsp'" /></td>
        </tr>
        <tr>
          <td valign="bottom"><input type="submit" name="depa" id="depa" value="Agregar nuevo Inquilino" onclick="window.location.href='registroInquilino.jsp'" /></td>
        </tr>
      </table>
    <!-- InstanceEndEditable --></td>
  </tr>
</table>
</body>
<!-- InstanceEnd -->
</html>