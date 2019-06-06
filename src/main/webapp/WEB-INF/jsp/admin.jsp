<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

    <title>
        Admin
    </title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container">

<form method="post">
    <center>
        Seats : <input type="text" name="seats"/>


        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input type="submit" value="Add Table" /> <br>


    </center>
</form>



    <form action="/requests", method="post">
        <center>

            <input type="submit" value="Requests" />

        </center>
    </form>


<center>

    <br><br>

    <H1>Tables</H1>
    <div class="container">
    <table class="table table-striped">
        <thead>
           <tr>

               <th>Id</th>
               <th>Seats</th>

           </tr>
        </thead>

        <tbody>
        <c:forEach items="${tables}" var="table" >
            <tr>
                <td>${table.id}</td>
                <td>${table.seats}</td>
                <td><a type="button" class="btn btn-warning" href="/deleteTable?id=${table.id}">Delete</a> </td>



            </tr>



        </c:forEach>


        </tbody>
    </table>


</center>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</div>

</body>

</html>