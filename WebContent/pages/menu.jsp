<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="menus">
<p>Menu</p>
<span class="menuStyle" onclick="todo('getAll')">�л�����Ʈ</span>

<span class="menuStyle" onclick="todo('input')">�л����� �Է�</span>

<span class="menuStyle" onclick="todo('modify')">�л����� ����</span>

<span class="menuStyle" onclick="todo('delete')">�л����� ����</span>
</div>
<form name="menuForm" method="get" action="<%= request.getContextPath() %>/control.jsp">
	<input type="hidden" name="cmd" />
</form>