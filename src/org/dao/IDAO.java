package org.dao;

import java.sql.Connection;

import org.bean.Student;

public interface IDAO {
	Connection connect();
	void disconnect(Connection con);
	
	int insert(Connection con, Student student);
	int delete(Connection con, int s_id);
	int update(Connection con, Student student);
	Student[] getAll(Connection con);
	Student[] search(Connection con, int mode, String key);
}
