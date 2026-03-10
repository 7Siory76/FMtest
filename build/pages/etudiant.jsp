<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultat Etudiant</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h2>${message}</h2>
    <table border="1">
        <tr><th>Champ</th><th>Valeur</th></tr>
        <tr><td>Nom</td><td>${nom}</td></tr>
        <tr><td>Prenom</td><td>${prenom}</td></tr>
        <tr><td>Age</td><td>${age}</td></tr>
    </table>
    <br>
    <a href="formulaire.html">Retour au formulaire</a>

    <hr>
    <h2>Ajouter un etudiant</h2>
    <form action="../etudiant" method="GET">
        <label>Nom : <input type="text" name="nom"></label><br><br>
        <label>Prenom : <input type="text" name="prenom"></label><br><br>
        <label>Age : <input type="number" name="age"></label><br><br>
        <button type="submit">Envoyer</button>
    </form>
</body>
</html>
