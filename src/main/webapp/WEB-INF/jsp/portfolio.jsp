<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
    <div class="container">
        <h3 class="fw-bold mb-3 mt-5">Инвестиционный портфель пользователя
            <c:out value="${userFromServer.name}"/>
        </h3>

        <hr class="mb-5 mt-3">
        <h3 class="fw-bold mb-3">Акции</h3>
        <table class="table table-striped mb-3">
            <thead>
            <tr>
                <th scope="col">Страна</th>
                <th scope="col">Тикер</th>
                <th scope="col">Эмитент</th>
                <th scope="col">Отрасль</th>
                <th scope="col">Кол-во</th>
                <th scope="col">Цена покупки, руб.</th>
                <th scope="col">Тек.цена, руб.</th>
                <th scope="col">Тек.стоимость, руб.</th>
                <th scope="col">Изменение, руб.</th>
                <th scope="col">Изменение, %</th>
                <th scope="col">Доля, %</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${stocksPositionsFromServer}" var="stockPosition" >
                <tr>
                    <td>${stockPosition.paper.country.name}</td>
                    <td>${stockPosition.paper.symbol}</td>
                    <td>${stockPosition.paper.company}</td>
                    <td>${stockPosition.paper.sector.title}</td>
                    <td>${stockPosition.paper.count}</td>
                    <td>${stockPosition.paper.price}</td>
                    <td>${stockPosition.currentPrice}</td>
                    <td>${stockPosition.value}</td>
                    <td>${stockPosition.diffCost}</td>
                    <td>${stockPosition.diffPercent}</td>
                    <td>${stockPosition.share}</td>
                    <td>
                        <c:if test="${isAdminOrOwner}">
                            <a href="/stocks/${userFromServer.id}/${stockPosition.paper.id}">
                                <i class="bi bi-pencil-square table-sign"></i>
                            </a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${isAdminOrOwner}">
                        <div type="button" data-bs-toggle="modal" data-bs-target="#Modal${stockPosition.paper.id}">
                            <i class="bi bi-x-octagon-fill table-sign"></i>
                        </div>
                        <div class="modal fade" id="Modal${stockPosition.paper.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Вы точно хотите это удалить?</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
                                        <a href="/stocks/${userFromServer.id}/${stockPosition.paper.id}/delete" type="button" class="btn btn-danger">Да, удалить</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <c:if test="${isAdminOrOwner}">
            <a href="/stocks/${userFromServer.id}" class="btn btn-outline-dark me-2">Добавить акцию</a>
        </c:if>
        <hr class="mb-3 mb-5">

        <h3 class="fw-bold mb-3">Облигации</h3>
        <table class="table table-striped mb-3">
            <thead>
            <tr>
                <th scope="col">Название</th>
                <th scope="col">Страна</th>
                <th scope="col">Эмитент</th>
                <th scope="col">Дата погашения</th>
                <th scope="col">Купон</th>
                <th scope="col">Доходность к погашению</th>
                <th scope="col">Количество</th>
                <th scope="col">Цена покупки</th>
                <th scope="col">Тек.цена</th>
                <th scope="col">Тек.стоимость</th>
                <th scope="col">Изменение, руб.</th>
                <th scope="col">Изменение, %</th>
                <th scope="col">Доля, %</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bondsPositionsFromServer}" var="bondPosition" >
                <tr>
                    <td>${bondPosition.paper.title}</td>
                    <td>${bondPosition.paper.country.name}</td>
                    <td>${bondPosition.paper.company}</td>
                    <td>${bondPosition.paper.maturity}</td>
                    <td>${bondPosition.paper.cupon}</td>
                    <td>${bondPosition.paper.yield}</td>
                    <td>${bondPosition.paper.count}</td>
                    <td>${bondPosition.paper.price}</td>
                    <td>${bondPosition.currentPrice}</td>
                    <td>${bondPosition.value}</td>
                    <td>${bondPosition.diffCost}</td>
                    <td>${bondPosition.diffPercent}</td>
                    <td>${bondPosition.share}</td>
                    <td>
                        <c:if test="${isAdminOrOwner}">
                            <a href="/bonds/${userFromServer.id}/${bondPosition.paper.id}">
                                <i class="bi bi-pencil-square table-sign"></i>
                            </a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${isAdminOrOwner}">
                        <div type="button" data-bs-toggle="modal" data-bs-target="#bondModal${bondPosition.paper.id}">
                            <i class="bi bi-x-octagon-fill table-sign"></i>
                        </div>
                        <div class="modal fade" id="bondModal${bondPosition.paper.id}" tabindex="-1" aria-labelledby="bondModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="bondModalLabel">Вы точно хотите это удалить?</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Отмена</button>
                                        <a href="/bonds/${userFromServer.id}/${bondPosition.paper.id}/delete" type="button" class="btn btn-danger">Да, удалить</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${isAdminOrOwner}">
            <a href="/bonds/${userFromServer.id}" class="btn btn-outline-dark me-2">Добавить облигацию</a>
        </c:if>

    </div>

</main>

<jsp:include page="fragments/footer.jsp"/>