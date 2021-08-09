<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.bean.*" %>
<%
	Student[] list = (Student[])request.getAttribute("list");
%>
<jsp:include page="find.jsp">
	<jsp:param value="getAll" name="cmd"/>
</jsp:include>
<table>
	<caption>¡Ý Client List ¡Ý</caption>
	<thead>
		<tr>
			<th id="idCol">ID</th>
			<th id="nameCol">Name</th>
			<th id="telCol">TelNum</th>
			<th id="gradeCol">Address</th>
			<th id="classCol">Birth</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th colspan="5"><%=(list != null) ? list.length : 0 %> row(s)</th>
		</tr>
	</tfoot>
	<tbody>
	<%
		if(list != null && list.length != 0) {
			for(Student s : list) {	
	%>
		<tr>
			<td><%= s.getS_id() %></td>
			<td><%= s.getS_name() %></td>
			<td><%= s.getS_tel() %></td>
			<td><%= s.getS_grade() %></td>
			<td><%= s.getS_class() %></td>
		</tr>
	<%
			}
		} else {
	%>
		<tr>
			<td colspan="5">no data</td>
		</tr>
	<%
		}
	%>
	</tbody>
</table>
