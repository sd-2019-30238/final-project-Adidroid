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



<center>

    <br><br>

    <H1>Tables</H1>
    <div class="container">
    <table class="table table-striped">
        <thead>
           <tr>

               <th>Id</th>
               <th>User</th>
               <th>Table Id</th>
               <th>Start Hour</th>
               <th>End Hour</th>



           </tr>
        </thead>

        <tbody>
        <c:forEach items="${reservations}" var="reservation" >
            <tr>


                <td>${reservation.id}</td>
                <td>${reservation.user}</td>
                <td>${reservation.table}</td>
                <td>${reservation.startHour}</td>
                <td>${reservation.endHour}</td>
                <td><a type="button" class="btn-success" href="/approveReservation?id=${reservation.id}">Approve</a> </td>
                <td><a type="button" class="btn-danger" href="/rejectReservation?id=${reservation.id}">Reject</a> </td>



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