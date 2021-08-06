package org.dao;

public interface MySqlConstant {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String UID = "root";
	public static final String UPW = "1234";
	
	public final static int INSERT = 0;
	public final static int DELETE = 1;
	public final static int UPDATE = 2;
	public final static int GET_ALL = 3;
	public final static int GET_BY_CLASS = 4;
	public final static int GET_BY_NAME = 5;
	public final static int GET_BY_ID = 6;
	
	public static final String[] SQLS = {
		"INSERT INTO students (s_name, s_tel, s_grade, s_class) VALUES (?, ?, ?, ?)",
		"DELETE FROM students WHERE s_id=?",
		"UPDATE students SET s_tel=?, s_grade=?, s_class=? WHERE s_id=?",
		"SELECT * FROM students",
		"SELECT * FROM students WHERE s_class=?",
		"SELECT * FROM students WHERE s_name=?",
		"SELECT * FROM students WHERE s_id=?"
	};
}
