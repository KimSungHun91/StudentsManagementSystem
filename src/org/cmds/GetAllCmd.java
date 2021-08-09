package org.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.bean.Student;
import org.dao.IDAO;
import org.dao.MySqlStudentsDAO;

public class GetAllCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		Student[] list = dao.getAll(con);
		dao.disconnect(con);
		request.setAttribute("list", list);
		request.setAttribute("contentPage", "pages/list.jsp");
	}
}
