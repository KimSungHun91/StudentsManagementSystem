package org.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.bean.Student;
import org.dao.IDAO;
import org.dao.MySqlStudentsDAO;

public class DoModifyCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String s_name = request.getParameter("s_name");
		int s_grade = Integer.parseInt(request.getParameter("s_grade"));
		String s_tel = request.getParameter("s_tel");
		String s_class = request.getParameter("s_class");
		
		Student s = new Student();
		s.setS_id(s_id);
		s.setS_name(s_name);
		s.setS_grade(s_grade);
		s.setS_tel(s_tel);
		s.setS_class(s_class);
		
		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		dao.update(con, s);
		dao.disconnect(con);
		
		request.setAttribute("isRedirect", true);
	}
}
