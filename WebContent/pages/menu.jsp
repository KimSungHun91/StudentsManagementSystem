<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="menus">
<p>Menu</p>
<span class="menuStyle" onclick="todo('getAll')"> �� ����Ʈ</span>

<span class="menuStyle" onclick="todo('input')">������ �Է�</span>

<span class="menuStyle" onclick="todo('modify')">������ ����</span>

<span class="menuStyle" onclick="todo('delete')">������ ����</span>
</div>
<form name="menuForm" method="get" action="DispatcherServlet">
	<input type="hidden" name="cmd" />
</form>