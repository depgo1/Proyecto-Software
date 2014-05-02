package com.depgo.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.depgo.bean.UsuarioBean;

/**
 * Servlet implementation class RecuperarContraseñaServlet
 */
@WebServlet("/recuperarContrasena")
public class RecuperarContrasenaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecuperarContrasenaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UsuarioBean validar(String usuario,String correo){
		 
		  
		  
		  UsuarioBean userdb = null;
		  Connection con=null;
			
			String url="jdbc:mysql://localhost:3306/bddepgo";
			String user="root";
			String password="root";

				try{
					
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.
							getConnection(url, user, password);
					String sql="SELECT * FROM t_usuario WHERE usuario=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, usuario);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						userdb = new UsuarioBean();
						userdb.setIdUsuario(rs.getInt("idUsuario"));
						userdb.setUsuario(rs.getString("usuario"));
						userdb.setNombre(rs.getString("nombre"));
						userdb.setApellidoP(rs.getString("apellidoP"));
						userdb.setApellidoM(rs.getString("apellidoM"));
						userdb.setContraseña(rs.getString("contraseña"));
						userdb.setCorreo(rs.getString("correo"));
					}
				}catch(Exception ex){
					ex.printStackTrace();
					try{if(con!=null)con.close();}catch(Exception e){};
				}
				
				if(userdb!=null){
				
					if(userdb.getCorreo().equals(correo)){
							return userdb;
					}else{
						return null;
					}
				}else{
						return null;
				}

	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario=request.getParameter("txt_Usuario");
		String correo=request.getParameter("txt_Correo");
		
		UsuarioBean objuser = new UsuarioBean();
		
		objuser=validar(usuario,correo);
		String pagina="";
		
		if(objuser!=null){
			try{
				
				Properties props = new Properties();
	            props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.user", "depgo.soporte@gmail.com");
	            props.setProperty("mail.smtp.auth", "true");

	            // Preparamos la sesion
	            Session session = Session.getDefaultInstance(props);

	            // Construimos el mensaje
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(objuser.getCorreo()));
	            message.addRecipient(
	            Message.RecipientType.TO,new InternetAddress(objuser.getCorreo()));
	          
	            message.setSubject("Recuperar Contraseña");
	            message.setText(objuser.getNombre()+" "+objuser.getApellidoP()+" "+objuser.getApellidoM()+" "+"su usuario es: "+objuser.getUsuario()+" y La contraseña es :" + objuser.getContraseña());
	            // Lo enviamos.
	            Transport t = session.getTransport("smtp");
	            t.connect("depgo.soporte@gmail.com","software123");
	            t.sendMessage(message, message.getAllRecipients());
	            // Cierre.
	            t.close();
			}catch (Exception e) {
				e.printStackTrace();

			}
			pagina="/index.jsp";
			request.setAttribute("mensaje", "Se envio sus datos a su correo, verifiquelo");
		}else{
			pagina="recuperarContrasena.jsp";
			request.setAttribute("mensaje", "Escriba correctamente sus datos");	
		}
		
		request.getRequestDispatcher(pagina).
		forward(request, response);

	}


}
