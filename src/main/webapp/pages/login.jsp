<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentification & Rôles - Framework MVC</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 30px; background-color: #f4f6f9; color: #333; }
        .card { background: white; border-radius: 8px; padding: 20px; margin-bottom: 25px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 550px; }
        h2 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; }
        h3 { margin-top: 0; color: #2980b9; }
        label { font-weight: bold; display: block; margin-top: 10px; }
        input[type="text"], select { margin-top: 5px; margin-bottom: 15px; width: 100%; padding: 8px; box-sizing: border-box; }
        button { background-color: #3498db; color: white; border: none; padding: 10px 20px; border-radius: 4px; cursor: pointer; font-size: 14px; }
        button:hover { background-color: #2980b9; }
        .alert-success { background-color: #d4edda; color: #155724; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
        .alert-error { background-color: #f8d7da; color: #721c24; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
        a { text-decoration: none; color: #3498db; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Gestion de la Sécurité & Authentification</h2>

    <% if (request.getAttribute("loginMessage") != null) { %>
        <div class="alert-success">${loginMessage}</div>
    <% } %>

    <% if (request.getAttribute("loginError") != null) { %>
        <div class="alert-error">${loginError}</div>
    <% } %>

    <!-- Formulaire de Connexion -->
    <div class="card">
        <h3>1. Connexion / Authentification</h3>
        <form action="../login" method="POST">
            <label>Nom d'utilisateur :</label>
            <input type="text" name="username" placeholder="ex: Rakoto" required><br>

            <label>Rôle :</label>
            <select name="role">
                <option value="chef">chef</option>
                <option value="prof">prof</option>
                <option value="etudiant">etudiant</option>
            </select><br>

            <button type="submit">Se connecter (Stockage Session)</button>
        </form>
    </div>

    <!-- Test des Routes Protegees -->
    <div class="card">
        <h3>2. Tester les Annotations de Sécurité</h3>
        <p>Utilisateur connecté : <strong><%= session.getAttribute("auth") != null ? session.getAttribute("auth") : "Non connecté" %></strong></p>
        <p>Rôle actuel en session : <strong><%= session.getAttribute("role") != null ? session.getAttribute("role") : "Aucun" %></strong></p>
        <ul>
            <li><a href="../profile">GET /profile</a> (Protégé par <code>@Authorized</code>)</li>
            <li><a href="../espace-chef">GET /espace-chef</a> (Protégé par <code>@Role("chef")</code>)</li>
            <li><a href="../espace-prof">GET /espace-prof</a> (Protégé par <code>@Role("prof")</code>)</li>
        </ul>
        <% if (session.getAttribute("auth") != null) { %>
            <a href="../logout" style="color:red;">Déconnexion (session.invalidate())</a>
        <% } %>
    </div>
</body>
</html>
