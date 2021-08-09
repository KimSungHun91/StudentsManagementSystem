package org.cmds;

import javax.servlet.http.HttpServletRequest;

public interface ICMD {
	void action(HttpServletRequest request);
}
