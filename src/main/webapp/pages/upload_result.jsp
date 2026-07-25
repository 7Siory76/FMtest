<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.Upload" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultat de l'Upload</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 30px; background-color: #f4f6f9; color: #333; }
        .card { background: white; border-radius: 8px; padding: 20px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 800px; }
        h2 { color: #27ae60; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; color: #2c3e50; }
        .field-name { background-color: #eef7fe; font-weight: bold; }
        a { display: inline-block; margin-top: 20px; color: #3498db; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <div class="card">
        <h2>${title}</h2>

        <%
            Map<String, List<Upload>> filesMap = (Map<String, List<Upload>>) request.getAttribute("filesMap");
            Upload singleFile = (Upload) request.getAttribute("singleFile");
            List<Upload> fileList = (List<Upload>) request.getAttribute("fileList");
        %>

        <% if (filesMap != null && !filesMap.isEmpty()) { %>
            <h3>Fichiers reçus dans Map&lt;String, List&lt;Upload&gt;&gt; :</h3>
            <table>
                <tr>
                    <th>Champ (Input Name)</th>
                    <th>Nom du Fichier</th>
                    <th>Extension</th>
                    <th>Type MIME</th>
                    <th>Taille (octets)</th>
                    <th>Chemin sur le serveur</th>
                </tr>
                <% for (Map.Entry<String, List<Upload>> entry : filesMap.entrySet()) { 
                    for (Upload u : entry.getValue()) { %>
                        <tr>
                            <td class="field-name"><%= entry.getKey() %></td>
                            <td><%= u.getFileName() %></td>
                            <td><%= u.getExtension() %></td>
                            <td><%= u.getContentType() %></td>
                            <td><%= u.getSize() %></td>
                            <td><code><%= u.getPath() %></code></td>
                        </tr>
                    <% } 
                } %>
            </table>
        <% } %>

        <% if (singleFile != null) { %>
            <h3>Fichier unique reçu (Upload) :</h3>
            <table>
                <tr>
                    <th>Nom du Fichier</th>
                    <th>Extension</th>
                    <th>Type MIME</th>
                    <th>Taille (octets)</th>
                    <th>Chemin sur le serveur</th>
                </tr>
                <tr>
                    <td><%= singleFile.getFileName() %></td>
                    <td><%= singleFile.getExtension() %></td>
                    <td><%= singleFile.getContentType() %></td>
                    <td><%= singleFile.getSize() %></td>
                    <td><code><%= singleFile.getPath() %></code></td>
                </tr>
            </table>
        <% } %>

        <% if (fileList != null && !fileList.isEmpty()) { %>
            <h3>Liste de fichiers reçus (List&lt;Upload&gt;) :</h3>
            <table>
                <tr>
                    <th>Nom du Fichier</th>
                    <th>Extension</th>
                    <th>Type MIME</th>
                    <th>Taille (octets)</th>
                    <th>Chemin sur le serveur</th>
                </tr>
                <% for (Upload u : fileList) { %>
                    <tr>
                        <td><%= u.getFileName() %></td>
                        <td><%= u.getExtension() %></td>
                        <td><%= u.getContentType() %></td>
                        <td><%= u.getSize() %></td>
                        <td><code><%= u.getPath() %></code></td>
                    </tr>
                <% } %>
            </table>
        <% } %>

        <a href="upload_form.jsp">&larr; Retour au formulaire d'upload</a>
    </div>
</body>
</html>
