<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
	<div class="container">
		<h1 class="text-center display-6 fw-bold mb-5">Список инвестиционных портфелей</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">№</th>
					<th scope="col">Пользователь</th>
					<th scope="col">Перейти</th>
					<td></td>
				</tr>
			</thead>
			<tbody>
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${usersFromServer}" var="user" >
				<c:set var="count" value="${count + 1}" scope="page"/>
			<tr>
				<td>${count}</td>
				<td>${user.name}</td>
				<td>
					<a href="/portfolio/${user.id}">
						<i class="bi bi-box-arrow-up-right table-sign"></i>
					</a>
				</td>
				<td>
					<c:if test="${isAdmin}">
						<div type="button" data-bs-toggle="modal" data-bs-target="#Modal${user.id}">
							<i class="bi bi-x-octagon-fill table-sign"></i>
						</div>
						<div class="modal fade" id="Modal${user.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Вы точно хотите удалить ${user.name}?</h5>
										<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
										<a href="/users/${user.id}/delete" type="button" class="btn btn-danger">Да, удалить</a>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</td>
			</tr>
			</c:forEach>

		</table>
	</div>
</main>

<jsp:include page="fragments/footer.jsp"/>