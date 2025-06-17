<%-- Directive page pour l'encodage et la gestion des erreurs --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%-- Importation de JSTL pour les boucles et conditions --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Détails Utilisateur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <%-- Vérification si l'utilisateur existe dans la session --%>
        <c:if test="${empty currentUser}">
            <%-- Redirection vers le formulaire si aucune donnée --%>
            <c:redirect url="/userServlet"/>
        </c:if>

        <h1 class="text-center mb-4">Détails de l'Utilisateur</h1>
        <div class="card p-4 shadow">
            <h3>Utilisateur Courant</h3>
            <p><strong>Nom :</strong> ${currentUser.nom}</p>
            <p><strong>Email :</strong> ${currentUser.email}</p>
        </div>

        <h3 class="mt-4">Liste des Utilisateurs</h3>
        <c:if test="${not empty users}">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Boucle sur la liste des utilisateurs --%>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.nom}</td>
                            <td>${user.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty users}">
            <p>Aucun utilisateur enregistré.</p>
        </c:if>

        <a href="/UserApps/userServlet" class="btn btn-primary mt-3">Ajouter un autre utilisateur</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>