<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Espace Protégé & Opérations Session CRUD</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 30px; background-color: #f4f6f9; color: #333; }
        .card { background: white; border-radius: 8px; padding: 20px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 700px; margin-bottom: 25px; }
        h2 { color: #27ae60; }
        h3 { color: #2980b9; margin-top: 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        label { font-weight: bold; display: block; margin-top: 10px; }
        input[type="text"], select { width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; box-sizing: border-box; }
        button { background-color: #27ae60; color: white; border: none; padding: 10px 20px; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #219150; }
        .alert { background-color: #d1ecf1; color: #0c5460; padding: 12px; border-radius: 4px; margin-bottom: 15px; }
        a { color: #3498db; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Zone Autorisée - Session & Sécurité</h2>
        <% if (request.getAttribute("roleMessage") != null) { %>
            <div class="alert">${roleMessage}</div>
        <% } else { %>
            <div class="alert">Bienvenue dans l'espace protégé ! (Accès validé par le framework)</div>
        <% } %>

        <p><strong>Utilisateur connecté :</strong> <%= session.getAttribute("auth") %></p>
        <p><strong>Rôle :</strong> <%= session.getAttribute("role") %></p>
    </div>

    <!-- Operations CRUD sur la Session -->
    <div class="card">
        <h3>Opérations CRUD sur la Session (via <code>@Session Map&lt;String, Object&gt; fako</code> ou <code>MySession</code>)</h3>

        <% if (request.getAttribute("crudMessage") != null) { %>
            <div class="alert" style="background-color: #e2e3e5; color: #383d41;">${crudMessage}</div>
        <% } %>

        <form action="../session-crud" method="POST">
            <label>Action :</label>
            <select name="action">
                <option value="put">Ajouter / Modifier (put)</option>
                <option value="remove">Supprimer (remove)</option>
                <option value="clear">Vider toute la session (clear)</option>
            </select><br>

            <label>Clé (Key) :</label>
            <input type="text" name="key" placeholder="ex: fako"><br>

            <label>Valeur (Value) :</label>
            <input type="text" name="value" placeholder="ex: testValue"><br>

            <button type="submit">Exécuter l'opération CRUD</button>
        </form>

        <h4>Contenu actuel de la session :</h4>
        <table>
            <tr><th>Clé</th><th>Valeur</th></tr>
            <%
                Enumeration<String> names = session.getAttributeNames();
                while (names.hasMoreElements()) {
                    String name = names.nextElement();
            %>
                <tr>
                    <td><code><%= name %></code></td>
                    <td><%= session.getAttribute(name) %></td>
                </tr>
            <% } %>
        </table>

        <br>
        <a href="login.jsp">&larr; Retour à la page de connexion</a>
    </div>
</body>
</html>
