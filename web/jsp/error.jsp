<%-- Directive page pour définir cette page comme page d'erreur --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Erreur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center text-danger">Une erreur s'est produite !</h1>
        <div class="alert alert-danger">
            <%-- Affichage du message d'erreur ou un message par défaut --%>
            <p><strong>Message :</strong> <%= exception != null ? exception.getMessage() : "Erreur inconnue" %></p>
        </div>
        <a href="/jsp/userForm.jsp" class="btn btn-primary">Retour au formulaire</a>
    </div>
</body>
</html>