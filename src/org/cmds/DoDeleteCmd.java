package org.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.dao.IDAO;
import org.dao.MySqlStudentsDAO;

public class DoDeleteCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));

		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		dao.delete(con, s_id);
		dao.disconnect(con);

		request.setAttribute("isRedirect", true);
	}
}
