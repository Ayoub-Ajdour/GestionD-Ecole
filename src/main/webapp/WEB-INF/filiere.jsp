<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filiere</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            background-image: url('./back2.jpg');
            background-size:cover;
            background-position: center;
            background-repeat: no-repeat;
            font-size: 13px;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            min-width: 1000px;
            box-shadow: 0 1px 1px rgba(0,0,0,.05);
        }
        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            min-width: 100%;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .table-title .btn-group {
            float: right;
        }
        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }
        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }
        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }
        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }
        table.table tr th:first-child {
            width: 60px;
        }
        table.table tr th:last-child {
            width: 100px;
        }
        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }
        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }
        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }
        table.table td a:hover {
            color: #2196F3;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #F44336;
        }
        table.table td i {
            font-size: 19px;
        }
        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }
        .pagination {
            float: right;
            margin: 0 0 5px;
        }
        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }
        .pagination li a:hover {
            color: #666;
        }
        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }
        .pagination li.active a:hover {
            background: #0397d6;
        }
        .pagination li.disabled i {
            color: #ccc;
        }
        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }
        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }
        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }
        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }
        .custom-checkbox label:before{
            width: 18px;
            height: 18px;
        }
        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }
        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }
        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }
        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }
        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }
        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }
        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }
        .modal .modal-content {
            border-radius: 3px;
            font-size: 14px;
        }
        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }
        .modal .modal-title {
            display: inline-block;
        }
        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }
        .modal textarea.form-control {
            resize: vertical;
        }
        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }
        .modal form label {
            font-weight: normal;
        }
        .section {
            flex: 1; /* Each section takes up equal space */
            box-sizing: border-box;
            padding: 5px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <a class="nav-link" href="index.jsp">  Ecole Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="etudiant">Etudiant</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand"><b>Filiere</b></a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-xl" >
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Gestion <b>Filiere</b></h2>
                    </div>

                </div>
            </div>
            <div class="container-fluid">
                <div id="alert" ng-class="alert.class" ng-bind="alert.message" class="alert font-weight-bold text-center" role="alert">
                </div>
                <div class="row">
                    <div class="section">

                        <form method="post" action="filiere/save">
                            <div class="col-sm-12 col-md-6 col-lg-4  mx-auto">
                                <div class="form-group">
                                    <label>ID :</label>
                                    <input type="text" name="id" disabled="true" class="form-control" autocomplete="off" ng-disabled="submitted"
                                           value="${filiereBean.filiere.idFiliere}">
                                </div>
                            </div>

                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6 mx-auto">
                                        <div class="form-group">
                                            <label>Code :</label>
                                            <input type="text" name="code" class="form-control " required value="${filiereBean.filiere.code}">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6 mx-auto">
                                        <div class="form-group">
                                            <label>Libelle :</label>
                                            <input type="text" name="libelle" class="form-control " required value="${filiereBean.filiere.libelle}">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group text-center">
                                <br>
                                <input type="submit" class="btn btn-dark"
                                       value="${filiereBean.label}">
                            </div>



                        </form>

                    </div>
                    <div class="section">
                        <table class="table table-striped table-hover"   id="eeee">
                            <thead>
                            <tr>
                                <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                                </th>
                                <th>Id</th>
                                <th>Code</th>

                                <th>Libelle</th>


                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${filiereBean.filieres}" var="f">
                            <tr>
                                <td>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                    <label for="checkbox1"></label>
                                </span>
                                </td>
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
                                    <a href="filiere/modify?id=${f.idFiliere}" class="edit" data-toggle="modal" ><i class="material-icons" data-toggle="tooltip" title="Edit" style="color: #FFD700;">&#xE254;</i></a>
                                </td>
                                <td>
                                    <a href="#" class="delete" onclick="confirmDelete('${f.idFiliere}')">
                                        <i class="material-icons" data-toggle="tooltip" title="Delete" style="color: #ff0000;">&#xE872;</i>
                                    </a>            </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div></div></div></div>

<script>
    function confirmDelete(fId) {
        var confirmed = window.confirm("Êtes-vous sûr de le supprimer??");
        if (confirmed) {
            window.location.href = "filiere/delete?id=" + fId;
        }
    }
</script>
</body>
</html>


