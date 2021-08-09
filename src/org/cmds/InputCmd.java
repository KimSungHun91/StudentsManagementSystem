package org.cmds;

import javax.servlet.http.HttpServletRequest;

public class InputCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		request.setAttribute("contentPage", "pages/input.jsp");
	}
}
