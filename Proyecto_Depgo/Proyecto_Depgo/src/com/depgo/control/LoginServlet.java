package com.depgo.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.depgo.bean.UsuarioBean;
import com.depgo.factory.DAOFactory;
import com.depgo.factory.Entity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		
		sesion.removeAttribute("usuario");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		UsuarioBean objusuario = new UsuarioBean();
		objusuario.setUsuario(request.getParameter("txt_Usuario"));
		objusuario.setContraseña(request.getParameter("txt_Contrasena"));
	
		Entity<UsuarioBean> usuarioDAO=
			DAOFactory.getFactory(DAOFactory.MYSQL).getUsuarioDAO();
		List<UsuarioBean> usuariobd=usuarioDAO.findByPk(objusuario.getUsuario());
		
		String pagina="";
		String mensaje="";
		if(usuariobd!=null){
				for( UsuarioBean usuario: usuariobd){
			if(usuario.getContraseña().equals(objusuario.getContraseña())){
				if(usuario.getTipo().equals("U")){
					pagina="/indexUsu.jsp";
				}else{
					pagina="/indexAdm.jsp";
				}
				HttpSession session= request.getSession(true);
				session.setAttribute("usuario", usuariobd);
			}else{
				pagina="/index.jsp";
				mensaje ="Ingrese correctamente sus datos";
			}
		}
		}else{
			pagina="/index.jsp";
			mensaje ="No existe usuario";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(pagina).
			forward(request, response);
	}

}
