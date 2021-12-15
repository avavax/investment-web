<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
    <div class="container">
        <h1 class="text-center display-6 fw-bold">Добавление / правка данных об акции</h1>
        <div class="form-edit form-signin--small-padding">
            <form class="mb-3 needs-validation" method="POST" novalidate>
                <input type="hidden" name="userId" value="${stockFromServer.userId}" />
                <input type="hidden" name="id" value="${stockFromServer.id}">
                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="country" class="form-label">Страна</label>
                            <select class="form-select" id="country" required="" name="country">
                                <option value="">Выбрать...</option>
                                <c:forEach items="${countriesFromServer}" var="country">
                                    <option value="${country.id}"
                                        <c:if test="${country.id == stockFromServer.country.id}">
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
                            <label for="sector" class="form-label">Отрасль</label>
                            <select class="form-select" id="sector" required="" name="sector">
                                <option value="">Выбрать...</option>
                                <c:forEach items="${sectorsFromServer}" var="sector">
                                    <option value="${sector.id}"
                                        <c:if test="${sector.id == stockFromServer.sector.id}">
                                            <c:out value=" selected "/>
                                        </c:if>
                                    >${sector.title}</option>
                                </c:forEach>
                            </select>
                            <div class="invalid-feedback">Выберите значение из списка.</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="tiker" class="form-label">Тикер</label>
                            <input type="text" class="form-control" id="tiker" name="symbol" required value="${stockFromServer.symbol}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="company" class="form-label">Компания</label>
                            <input type="text" class="form-control" id="company" name="company" required value="${stockFromServer.company}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="quant" class="form-label">Количество</label>
                            <input type="number" class="form-control" id="quant" name="count" required value="${stockFromServer.count}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="mb-3">
                            <label for="price" class="form-label">Цена приобретения</label>
                            <input type="text" class="form-control" id="price" name="price" required value="${stockFromServer.price}">
                            <div class="invalid-feedback">Поле не может быть пустым.</div>
                        </div>
                    </div>
                </div>
                <input type="submit" class="w-100 btn btn-outline-dark me-2 mt-3" value="Сохранить">
            </form>
            <c:if test="${errors != null}">
                <div class="alert alert-danger" role="alert">
                    Одно или несколько полей введены некорректно!
                </div>
            </c:if>
        </div>
    </div>
</main>

<jsp:include page="fragments/footer.jsp"/>
