package com.depgo.factory.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.depgo.bean.UsuarioBean;
import com.depgo.factory.Entity;
import com.depgo.util.DBConection;

public class MySQLUsuarioDAO 
implements Entity<UsuarioBean> {

	@Override
	public int insert(UsuarioBean objcliente) {
		// TODO Auto-generated method stub
		int rows=-1;
		int id=0;
		Connection con=null;
		try{
			con=DBConection.getConnection();
			String sql="INSERT INTO " +
		"t_usuario (nombre,apellidoP,apellidoM,dni,usuario,contraseña,numPiso,numDep,tipo,correo) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, objcliente.getNombre());
			ps.setString(2, objcliente.getApellidoP());
			ps.setString(3, objcliente.getApellidoM());
			ps.setInt(4, objcliente.getDni());
			ps.setString(5, objcliente.getUsuario());
			ps.setString(6, objcliente.getContraseña());
			ps.setInt(7, objcliente.getNumPiso());
			ps.setInt(8, objcliente.getNumDep());
			ps.setString(9, objcliente.getTipo());
			ps.setString(10, objcliente.getCorreo());
			rows=ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				id=rs.getInt(1);
			} 
			objcliente.setIdUsuario(id);
		}catch(Exception ex){
			DBConection.closeConnection(con);
		}
		return rows;

	}

	@Override
	public int update(UsuarioBean t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UsuarioBean t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UsuarioBean> findByPk(String id) {
		// TODO Auto-generated method stub
		List<UsuarioBean> usuario = new ArrayList<UsuarioBean>();
		UsuarioBean usuariobd = null;
		Connection con=null;
		try{
			con=DBConection.getConnection();
			String sql="SELECT * FROM t_usuario WHERE usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				usuariobd = new UsuarioBean();
				usuariobd.setIdUsuario(rs.getInt("idUsuario"));
				usuariobd.setNombre(rs.getString("nombre"));
				usuariobd.setApellidoP(rs.getString("apellidoP"));
				usuariobd.setApellidoM(rs.getString("apellidoM"));
				usuariobd.setDni(rs.getInt("dni"));
				usuariobd.setUsuario(rs.getString("usuario"));
				usuariobd.setContraseña(rs.getString("contraseña"));
				usuariobd.setTipo(rs.getString("tipo"));
				usuario.add(usuariobd);
			
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			DBConection.closeConnection(con);
		}
		return usuario;
	}

	

	@Override
	public UsuarioBean findByPk(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
