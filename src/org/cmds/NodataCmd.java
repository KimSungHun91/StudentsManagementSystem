package org.cmds;

import javax.servlet.http.HttpServletRequest;

public class NodataCmd implements ICMD {

	@Override
	public void action(HttpServletRequest request) {
		request.setAttribute("contentPage", "pages/nodata.jsp");
	}
}
