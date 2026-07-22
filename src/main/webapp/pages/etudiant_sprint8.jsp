<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Sprint 8 bis & Sprint 9</title>
    <style>
        body { font-family: sans-serif; margin: 30px; }
        .card { border: 1px solid #ccc; padding: 20px; border-radius: 8px; margin-bottom: 20px; width: 450px; }
        input { margin-bottom: 10px; padding: 6px; width: 90%; }
        button { padding: 8px 16px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #0056b3; }
        a { text-decoration: none; color: #007bff; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Sprint 8 bis - Formulaire d'objets imbriques</h2>

    <div class="card">
        <h3>Formulaire Employee (Image 1)</h3>
        <form action="../some-method" method="POST">
            <label>e.name :</label><br>
            <input name="e.name" value="Jean Rakoto"><br>
            <label>e.department[0].name :</label><br>
            <input name="e.department[0].name" value="Informatique"><br>
            <label>e.department[1].name :</label><br>
            <input name="e.department[1].name" value="RH"><br>
            <button type="submit">Submit</button>
        </form>
    </div>

    <div class="card">
        <h3>Formulaire Etudiant imbrique</h3>
        <form action="../etudiant/save" method="POST">
            <label>e.nom :</label><br>
            <input name="e.nom" value="Rasoa"><br>
            <label>e.prenom :</label><br>
            <input name="e.prenom" value="Marie"><br>
            <label>e.age :</label><br>
            <input name="e.age" type="number" value="22"><br>
            <label>e.departement[0].nom :</label><br>
            <input name="e.departement[0].nom" value="Gestion"><br>
            <button type="submit">Enregistrer Etudiant</button>
        </form>
    </div>

    <h2>Sprint 9 - API REST (JSON)</h2>
    <ul>
        <li><a href="../etudiant/api/list" target="_blank">GET /etudiant/api/list</a> (Liste d'objets JSON avec count et data)</li>
        <li><a href="../etudiant/api/1" target="_blank">GET /etudiant/api/1</a> (Objet unique JSON)</li>
        <li><a href="../etudiant/api/mv" target="_blank">GET /etudiant/api/mv</a> (ModelView au format JSON)</li>
    </ul>
</body>
</html>
