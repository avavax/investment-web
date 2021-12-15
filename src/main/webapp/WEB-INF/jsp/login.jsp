<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
    <div class="container">
        <div class="form-signin">
            <form method="POST" action="/login">
                <div class="mb-3">
                    <label for="email" class="form-label">Логин (ваш е-майл)</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <input type="submit" class="w-100 btn btn-outline-dark me-2 mt-4" value="Войти">
            </form>
        </div>
    </div>
</main>

<jsp:include page="fragments/footer.jsp"/>
