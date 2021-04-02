<%@ page import="app.model.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: maksimsavelchev
  Date: 31.03.2021
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<head>
    <title>Client list</title>
</head>
<body>
<div class="container">
    <h1>Клиент</h1>
    <hr>
    <table class="table table-hover">
        <thead class="thead-light">
        <tr><th scope="col">Id</th><th scope="col">Фамилия</th><th scope="col">Имя</th><th scope="col">Отчество</th><th scope="col">Email</th><th scope="col">Телефон</th><th scope="col">Изменить</th><th scope="col">Удалить</th></tr>
        </thead>
        <tbody>
        <%
            List<Client> list = (List<Client>) request.getAttribute("clientsList");
            if (list!=null || !list.isEmpty()) {
                for (Client e : list) {
                    out.print("<tr><td class=\"text-center\">" + e.getId() + "</td><td class=\"text-center\">" + e.getLastName() + "</td><td class=\"text-center\">" + e.getName() + "</td>" + "<td class=\"text-center\">" + e.getMiddleName() + "</td> " +
                            "<td class=\"text-center\">" + e.getEmail() + "</td><td class=\"text-center\">" + e.getTelNumber() + String.format("</td><td class=\"text-center\"><a href='/edit?id=%d&lN=%s&n=%s&mN=%s&e=%s&t=%s",e.getId(),e.getLastName(),e.getName(),e.getMiddleName(),e.getEmail(),e.getTelNumber()) + "'>изменить</a></td> " +
                            "<td class=\"text-center\"><a href='/delete?id=" + e.getId() + "'>удалить</a></td></tr>");
                }
            }
            else {
                out.println("<p>Клиент не найден!</p>");
            }

        %>
        </tbody>
    </table>
    <div align="right">
        <a class="btn btn-primary" href='/' role="button">Назад к списку</a>
    </div>
</div>
</body>
</html>
