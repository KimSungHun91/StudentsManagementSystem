package org.cmds;

import javax.servlet.http.HttpServletRequest;

public class ModifyCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		request.setAttribute("contentPage", "pages/find.jsp");
	}
}
