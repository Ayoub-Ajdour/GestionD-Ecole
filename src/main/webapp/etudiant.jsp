<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Etudiant</title>
</head>
<body>
<form method="post" >
    <fieldset>
        <legend>Gestion Etudiant :</legend>
        <table>
            <tr>
                <td>
                    ID :
                </td>
                <td>
                    <input type="text" name="idEtudiant" disabled>
                </td>
            </tr>
            <tr>
                <td>
                    nom :
                </td>
                <td>
                    <input type="text" name="nom">
                </td>
            </tr>
            <tr>
                <td>
                    prenom :
                </td>
                <td>
                    <input type="text" name="prenom">
                </td>
            </tr>
            <tr>
                <td>
                    CNE :
                </td>
                <td>
                    <input type="text" name="cne">
                </td>
            </tr>
            <tr>
                <td>
                    Filiere :
                </td>
                <td>
                    <input type="text" name="filiere">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<table>
    <tr>
        <td>
            Id :
        </td>
        <td>
            Nom :
        </td>
        <td>
            Prenom :
        </td>
        <td>
            CNE :
        </td>
        <td>
            Filiere :
        </td>
        <td>
            Modifier :
        </td>
        <td>
            Supprimer :
        </td>
    </tr>
</table>
</body>
</html>
