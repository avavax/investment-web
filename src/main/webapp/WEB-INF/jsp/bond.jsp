<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
    <div class="container">
        <h1 class="text-center display-6 fw-bold">Добавление / правка данных о облигации</h1>
        <div class="form-edit form-signin--small-padding">
            <form class="mb-3 needs-validation" method="POST" novalidate>
                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="title" class="form-label">Название</label>
                            <input type="text" class="form-control" id="title" name="title" required value="${bondFromServer.title}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="company" class="form-label">Эмитент</label>
                            <input type="text" class="form-control" id="company" name="company" required value="${bondFromServer.company}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="country" class="form-label">Страна</label>
                            <select class="form-select" id="country" required="" name="country">
                                <option value="">Выбрать...</option>
                                <c:forEach items="${countriesFromServer}" var="country">
                                    <option value="${country.id}"
                                            <c:if test="${country.id == bondFromServer.country.id}">
                                                <c:out value=" selected "/>
                                            </c:if>
                                    >${country.name}</option>
                                </c:forEach>
                            </select>
                            <div class="invalid-feedback">Выберите значение из списка.</div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="price" class="form-label">Цена покупки</label>
                            <input type="text" class="form-control" id="price" name="price" required value="${bondFromServer.price}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="cupon" class="form-label">Купон</label>
                            <input type="text" class="form-control" id="cupon" name="cupon" required value="${bondFromServer.cupon}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="yield" class="form-label">Доходность к погашению</label>
                            <input type="text" class="form-control" id="yield" name="yield" required value="${bondFromServer.yield}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="maturity" class="form-label">Дата погашения (формат yyyy-MM-dd)</label>
                            <input type="date" class="form-control" id="maturity" name="maturity" required value="${bondFromServer.maturity}">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="count" class="form-label">Количество</label>
                            <input type="number" class="form-control" id="count" name="count" required value="${bondFromServer.count}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="symbol" class="form-label">Тикер</label>
                            <input type="text" class="form-control" id="symbol" name="symbol" required value="${bondFromServer.symbol}">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="symbol" class="form-label">Добавить в портфель</label>
                            <input type="submit" class="w-100 btn btn-outline-dark" value="Сохранить">
                        </div>
                    </div>
                </div>
                </form>
            <c:if test="${errors != null}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${errors}"/>
                </div>
            </c:if>
        </div>
    </div>
</main>

<jsp:include page="fragments/footer.jsp"/>
