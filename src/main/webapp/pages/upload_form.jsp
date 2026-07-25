<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Upload de Fichiers - Framework MVC</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 30px; background-color: #f4f6f9; color: #333; }
        .card { background: white; border-radius: 8px; padding: 20px; margin-bottom: 25px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 600px; }
        h2 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; }
        h3 { margin-top: 0; color: #2980b9; }
        label { font-weight: bold; display: block; margin-top: 10px; }
        input[type="file"], input[type="text"] { margin-top: 5px; margin-bottom: 15px; width: 100%; }
        button { background-color: #3498db; color: white; border: none; padding: 10px 20px; border-radius: 4px; cursor: pointer; font-size: 14px; }
        button:hover { background-color: #2980b9; }
    </style>
</head>
<body>
    <h2>Gestion des Fichiers Uploadés (Framework MVC)</h2>

    <!-- Formulaire 1 : Map<String, List<Upload>> -->
    <div class="card">
        <h3>1. Upload avec Map&lt;String, List&lt;Upload&gt;&gt;</h3>
        <form action="../upload-map" method="POST" enctype="multipart/form-data">
            <label>Fichier Document 1 (name="doc1") :</label>
            <input type="file" name="doc1"><br>

            <label>Fichiers Multiples (name="photos" multiple) :</label>
            <input type="file" name="photos" multiple><br>

            <button type="submit">Envoyer via Map</button>
        </form>
    </div>

    <!-- Formulaire 2 : Upload simple -->
    <div class="card">
        <h3>2. Upload Fichier Unique (Upload)</h3>
        <form action="../upload-single" method="POST" enctype="multipart/form-data">
            <label>Avatar (name="avatar") :</label>
            <input type="file" name="avatar"><br>

            <button type="submit">Envoyer Avatar</button>
        </form>
    </div>

    <!-- Formulaire 3 : List<Upload> -->
    <div class="card">
        <h3>3. Upload Fichiers Multiples (List&lt;Upload&gt;)</h3>
        <form action="../upload-list" method="POST" enctype="multipart/form-data">
            <label>Documents (name="docs" multiple) :</label>
            <input type="file" name="docs" multiple><br>

            <button type="submit">Envoyer la liste</button>
        </form>
    </div>

    <!-- Formulaire 4 : API REST JSON -->
    <div class="card">
        <h3>4. API REST JSON (@Json)</h3>
        <form action="../upload-api" method="POST" enctype="multipart/form-data">
            <label>Fichier à analyser (name="file") :</label>
            <input type="file" name="file" multiple><br>

            <button type="submit">Envoyer (Retour JSON)</button>
        </form>
    </div>
</body>
</html>
