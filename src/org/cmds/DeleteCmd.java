package org.cmds;

import javax.servlet.http.HttpServletRequest;

public class DeleteCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		request.setAttribute("contentPage", "pages/find.jsp");
	}
}
