
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Filiere</title>
</head>
<body>
<form method="post" action="filiere/save">
    <fieldset>
        <legend>Gestion Filiere :</legend>
        <table>
            <tr>
                <td>
                    ID :
                </td>
                <td>
                    <input type="text" disabled="true" name="id"
                           value="${filiereBean.filiere.idFiliere}">

                </td>
            </tr>
            <tr>
                <td>
                    Code :
                </td>
                <td>
                    <input type="text"  name="code"
                           value="${filiereBean.filiere.code}">


                </td>
            </tr>
            <tr>
                <td>
                    Libelle :
                </td>
                <td>
                    <input type="text" name="libelle"
                           value="${filiereBean.filiere.libelle}">


                </td>
            </tr>
        </table>
        <input type="submit"
               value="${filiereBean.label}">
    </fieldset>
</form>

<table>
    <tr>
        <td>
            Id :
        </td>
        <td>
            Code :
        </td>
        <td>
            Libelle :
        </td>
        <td>
            Modifier :
        </td>
        <td>
            Supprimer :
        </td>
    </tr>
    <c:forEach items="${filiereBean.filieres}" var="f">
        <tr>
            <td>
                    ${f.idFiliere}
            </td>
            <td>
                    ${f.code}
            </td>
            <td>
                    ${f.libelle}
            </td>
            <td>
                <a href="filiere/modify?id=${f.idFiliere}">edit</a>
            </td>
            <td>
                <a href="filiere/delete?id=${f.idFiliere}">delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
