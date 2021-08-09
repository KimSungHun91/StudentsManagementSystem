package org.cmds;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.bean.Student;
import org.dao.IDAO;
import org.dao.MySqlConstant;
import org.dao.MySqlStudentsDAO;

public class FindCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		String forWhat = request.getParameter("forWhat");
		String category = request.getParameter("category");
		String inputVal = request.getParameter("inputVal");

		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		Student[] list = null;
		if (forWhat.equals("getAll")) {
			int mode;
			if (category.equals("s_id")) {
				mode = MySqlConstant.GET_BY_ID;
			} else if (category.equals("s_name")) {
				mode = MySqlConstant.GET_BY_NAME;
			} else {
				mode = MySqlConstant.GET_BY_CLASS;
			}
			list = dao.search(con, mode, inputVal);
			request.setAttribute("contentPage", "pages/list.jsp");
			request.setAttribute("list", list);
		} else {
			Student[] temp = dao.search(con, MySqlConstant.GET_BY_ID, inputVal);

			if (temp.length != 0) {
				if (forWhat.equals("modify")) {
					request.setAttribute("contentPage", "pages/modify.jsp");
				} else {
					request.setAttribute("contentPage", "pages/info.jsp");
				}
				request.setAttribute("student", temp[0]);
			} else {
				request.setAttribute("contentPage", "pages/nodata.jsp");
			}
		}
		dao.disconnect(con);
	}
}
