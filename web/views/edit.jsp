<%--
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
    <title>Edit client</title>
</head>
<body>
<div class="container">
<h1>Редактирование данных клиента</h1>
    <hr>
    <div class="card">
        <div class="card-body">
            <form method="post">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Фамилия:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="lastName" value="<%= request.getParameter("lN")%>" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Имя:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="name" value="<%= request.getParameter("n")%>" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Отчество:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="middleName" value="<%= request.getParameter("mN")%>">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email:</label>
                    <div class="col-sm-7">
                        <input type="email" class="form-control" name="email" value="<%= request.getParameter("e")%>">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Номер телефона:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="telNumber" value="<%= request.getParameter("t")%>">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
