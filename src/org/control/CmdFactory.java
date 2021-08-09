package org.control;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import org.cmds.*;

public class CmdFactory {
	private static Hashtable<String, ICMD> cmds;
	
	public static void init() {
		if (cmds == null) {
			cmds = new Hashtable<>();
			cmds.put("getAll", new GetAllCmd());
			cmds.put("modify", new ModifyCmd());
			cmds.put("delete", new DeleteCmd());
			cmds.put("input", new InputCmd());
			cmds.put("doInsert", new doInsertCmd());
			cmds.put("find", new FindCmd());
			cmds.put("doModify", new DoModifyCmd());
			cmds.put("doDelete", new DoDeleteCmd());
			cmds.put("nodata", new NodataCmd());
		}
	}
	
	public static void doAction(HttpServletRequest request, String cmd) {
		cmds.get(cmd).action(request);
	}
}
