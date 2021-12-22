<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Учёт личных инвестиций</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="icon" href="/images/icon.svg">
</head>

<body>

<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-bar-chart-line" viewBox="0 0 16 16">
                    <path d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1V2zm1 12h2V2h-2v12zm-3 0V7H7v7h2zm-5 0v-3H2v3h2z"/>
                </svg>
            </a>
            <ul class="nav col-12 offset-md-1 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2
                    <c:if test="${currentPage.equals('main')}">
                        <c:out value=" text-secondary "/>
                    </c:if>
                    <c:if test="${!currentPage.equals('main')}">
                        <c:out value=" text-white "/>
                    </c:if>
                ">Главная</a></li>
                <li><a href="/portfolio" class="nav-link px-2
                     <c:if test="${currentPage.equals('myPortfolio')}">
                        <c:out value=" text-secondary "/>
                    </c:if>
                    <c:if test="${!currentPage.equals('myPortfolio')}">
                        <c:out value=" text-white "/>
                    </c:if>
                ">Мой портфель</a></li>
                <li><a href="/about" class="nav-link px-2
                    <c:if test="${currentPage.equals('about')}">
                        <c:out value=" text-secondary "/>
                    </c:if>
                    <c:if test="${!currentPage.equals('about')}">
                        <c:out value=" text-white "/>
                    </c:if>
                 ">О программе</a></li>
            </ul>
            <div class="text-end">
                <a type="button" class="btn btn-outline-light me-2" href="/login">Войти</a>
                <a type="button" class="btn btn-warning" href="/register">Зарегистрироваться</a>
            </div>
        </div>
    </div>
</header>