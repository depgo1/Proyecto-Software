package com.depgo.factory;

import com.depgo.bean.*;
import com.depgo.factory.mysql.*;

public final class MySQLDAOFactory 
extends DAOFactory{

	

	@Override
	public Entity<UsuarioBean> getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioDAO();
	}



}

