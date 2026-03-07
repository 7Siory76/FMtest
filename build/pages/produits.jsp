<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${titre}</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h2>${titre}</h2>
    <p>URL : ${url}</p>

    <table border="1">
        <tr>
            <th>Produit</th>
            <th>Prix (Ar)</th>
        </tr>
        <tr>
            <td>${produit1}</td>
            <td>${prix1}</td>
        </tr>
        <tr>
            <td>${produit2}</td>
            <td>${prix2}</td>
        </tr>
        <tr>
            <td>${produit3}</td>
            <td>${prix3}</td>
        </tr>
    </table>

    <p>Total produits : ${total}</p>
</body>
</html>
