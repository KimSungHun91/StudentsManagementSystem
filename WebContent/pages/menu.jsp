<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="menus">
<p>Menu</p>
<span class="menuStyle" onclick="todo('getAll')"> 고객 리스트</span>

<span class="menuStyle" onclick="todo('input')">고객정보 입력</span>

<span class="menuStyle" onclick="todo('modify')">고객정보 수정</span>

<span class="menuStyle" onclick="todo('delete')">고객정보 삭제</span>
</div>
<form name="menuForm" method="get" action="DispatcherServlet">
	<input type="hidden" name="cmd" />
</form>