<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String cmd = request.getParameter("cmd");
%>
<div>
	<form action="<%= request.getContextPath() %>/control.jsp">
		<table>
			<tr>
				<td>
					�˻� : 
				</td>
				<td>
					<select name="category">
						<option value="s_id">ID</option>
						<% if(cmd.equals("getAll")) { %>
						<option value="s_name">Name</option>
						<option value="s_class">Class</option>
						<% } %>
					</select>
				</td>
				<td>
					���� : 
				</td>
				<td>
					<input type="text" name="inputVal" />
				</td>
				<td>
					<input type="submit" value="go" />				
				</td>
			</tr>
		</table>
		<input type="hidden" name="cmd" value="find" />
		<input type="hidden" name="forWhat" value="<%= cmd %>" />
	</form>
</div>