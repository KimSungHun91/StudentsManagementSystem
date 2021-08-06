<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="org.dao.*" %>
<%@ page import="org.bean.*" %>

<%
	String cmd = request.getParameter("cmd");
	if(cmd == null) cmd="getAll";
	String contentPage = null;
	boolean isRedirect = false;
	if(cmd.equals("getAll")){
		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		Student[] list = dao.getAll(con);
		dao.disconnect(con);
		request.setAttribute("list", list);
		contentPage = "pages/list.jsp";
	} else if(cmd.equals("modify") || cmd.equals("delete")) {
		contentPage = "pages/find.jsp";
	} else if(cmd.equals("input")) {
		contentPage = "pages/input.jsp";
	} else if(cmd.equals("doInsert")) {
		String s_name = request.getParameter("s_name");
		int s_grade = Integer.parseInt(request.getParameter("s_grade"));
		String s_tel = request.getParameter("s_tel");
		String s_class = request.getParameter("s_class");
		
		Student s = new Student();
		s.setS_name(s_name);
		s.setS_grade(s_grade);
		s.setS_tel(s_tel);
		s.setS_class(s_class);
		
		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		dao.insert(con, s);
		dao.disconnect(con);
		
		isRedirect = true;
	} else if(cmd.equals("find")) {
		String forWhat = request.getParameter("forWhat");
		String category = request.getParameter("category");
		String inputVal = request.getParameter("inputVal");
		
		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		Student[] list = null;
		if(forWhat.equals("getAll")) {
			int mode;
			if(category.equals("s_id")) {
				mode = MySqlConstant.GET_BY_ID;
			} else if(category.equals("s_name")) {
				mode = MySqlConstant.GET_BY_NAME;
			} else {
				mode = MySqlConstant.GET_BY_CLASS;
			}
			list = dao.search(con, mode, inputVal);
			contentPage = "pages/list.jsp";
			request.setAttribute("list", list);
		} else {
			Student[] temp = dao.search(con, MySqlConstant.GET_BY_ID, inputVal);
			
			if(temp.length != 0) {
				if(forWhat.equals("modify")) {
					contentPage = "pages/modify.jsp";
				} else {
					contentPage = "pages/info.jsp";
				}
				request.setAttribute("student", temp[0]);
			} else {
				contentPage = "pages/nodata.jsp";
			}
		}
		dao.disconnect(con);
	} else if(cmd.equals("doModify")) {
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
		
		isRedirect = true;
	} else if(cmd.equals("doDelete")) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		
		IDAO dao = MySqlStudentsDAO.getInstance();
		Connection con = dao.connect();
		dao.delete(con, s_id);
		dao.disconnect(con);
		
		isRedirect = true;
	} else if(cmd.equals("nodata")) {
		contentPage = "pages/nodata.jsp";
	}
	request.setAttribute("contentPage", contentPage);
	
	if(!isRedirect) {
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	} else {
		response.sendRedirect(request.getContextPath());
	}
%>
