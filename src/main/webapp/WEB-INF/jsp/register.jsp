<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
    <div class="container">
        <h1 class="text-center display-6 fw-bold">Регистрация нового пользователя</h1>
        <div class="form-signin form-signin--small-padding">
            <form class="mb-3 needs-validation" novalidate method="POST">
                <div class="mb-3">
                    <label for="name" class="form-label">Ваше имя (от 5 до 16 символов)</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                    <div class="invalid-feedback">Поле не может быть пустым.</div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">E-mail (будет использован как логин)</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                    <div class="invalid-feedback">Поле не может быть пустым.</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Придумайте пароль (от 5 до 16 символов)</label>
                    <input type="password" class="form-control" name="password" id="password" required>
                </div>
                <div class="mb-3">
                    <label for="password-repeat" class="form-label">Повторите пароль</label>
                    <input type="password" class="form-control" name="repeatPassword" id="password-repeat" required>
                </div>
                 <input type="submit" class="w-100 btn btn-outline-dark me-2" value="Зарегистрировать">
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
