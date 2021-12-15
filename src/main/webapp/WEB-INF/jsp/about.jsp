<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

<main class="main-content">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-8">
                <h1 class="text-center display-6 fw-bold mb-5">О программе</h1>
                <p>Учебный проект разработанный в рамках курса «Введение в разработку корпоративных приложений на Java». Университет Иннополис </p>

                <p>Пользователь может зарегистрироваться, указав имя, email (будет использоваться как логин) и пароль.
                    Зарегистрированный пользователь может вести учёт личных инвестиций, добавляя, редактируя и удаляя ценные бумаги (CRUD).
                    Также он может просматривать инвестиционные портфели других участников системы и делиться url-ссылкой на свой портфель.
                    Незарегистрированный пользователь может только просматривать портфели участников.
                <p> В системе предусмотрена учётная запись админа, который может редактировать портфели любых пользователей.</p>
                <p>Приложение позволяет учитывать два вида ценных бумаг - акции и облигации.
                Приложение отображает текущую стоимость активов за счёт API БКС и подсчитывает полученную прибыль / убыток по каждой позиции.</p>
                <div class="row">
                    <div class="col-4">
                        <div class="list-group" id="list-tab" role="tablist">
                            <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Ощие данные</a>
                            <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Работа с БД</a>
                            <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Фронтенд и шаблонизаторы</a>
                            <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Внешние API</a>
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
                                <ul>
                                    <li>Язык Java 8</li>
                                    <li>Фреймворк Spring Boot</li>
                                    <li>Авторизация и аутентификация Spring Security</li>
                                    <li>Среда разработки Intellij IDEA</li>
                                    <li>Деплой Heroku, Tomcat</li>
                                    <li>Сборка Maven</li>
                                </ul>
                            </div>
                            <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
                                <ul>
                                    <li>Postgres</li>
                                    <li>JDBC</li>
                                    <li>ORM Hibernate</li>
                                    <li>Spring Data JPA</li>
                                </ul>
                            </div>
                            <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">
                                <ul>
                                    <li>JSP</li>
                                    <li>JSTL</li>
                                    <li>Bootstrap</li>
                                </ul>
                            </div>
                            <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">
                                <ul>
                                    <li>API БКС - получение курса ценной бумаги</li>
                                    <li>API ЦБ РФ - получение курса рубля</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="fragments/footer.jsp"/>