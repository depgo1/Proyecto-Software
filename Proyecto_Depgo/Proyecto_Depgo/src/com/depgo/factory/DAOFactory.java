package com.depgo.factory;

import com.depgo.bean.*;

public abstract class DAOFactory {
	public static final int MYSQL=1;
	
	public static DAOFactory getFactory(int opcion){
		switch (opcion) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			break;
		}
		return null;
	}
	
	public abstract Entity<UsuarioBean> getUsuarioDAO();
}

