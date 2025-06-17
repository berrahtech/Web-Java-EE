<%-- Directive page pour définir l'encodage et le type de contenu --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Importation de JSTL pour une syntaxe moderne --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Formulaire Utilisateur</title>
    <%-- Inclusion de Bootstrap pour un style moderne --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4">Formulaire d'Inscription</h1>
        <%-- Affichage d'un message d'erreur si présent --%>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        <%-- Formulaire envoyant les données au servlet via POST --%>
        <form action="${pageContext.request.contextPath}/userServlet" method="post" class="card p-4 shadow">
            <div class="mb-3">
                <label for="nom" class="form-label">Nom :</label>
                <input type="text" id="nom" name="nom" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email :</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Soumettre</button>
        </form>
    </div>
    <%-- Script Bootstrap pour la compatibilité --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>