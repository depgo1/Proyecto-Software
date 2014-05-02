package com.depgo.factory;

import java.util.List;

public interface Entity<T> {

	int insert(T t);
	int update(T t);
	int delete(T t);
	List<T> findByPk(String id);
	T findByPk(Integer id);
	List<T> findAll();
	
}
