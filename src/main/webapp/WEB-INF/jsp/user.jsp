<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

    <title>
        Reservation System
    </title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <center>

        <br><br>
        <H1>Tables</H1> <br>
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

                        <td><a type="button" class="btn btn-warning" href="/tableDetails?id=${table.id}">Details</a> </td>


                    </tr>



                </c:forEach>


                </tbody>
            </table>


    </center>

    <br><br>


        <center>

            <br><br>
            <H1> My Reservations</H1> <br>
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Table</th>
                        <th>StartHour</th>
                        <th>EndHour</th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${myReservations}" var="reservation" >
                        <tr>

                            <td>${reservation.table}</td>
                            <td>${reservation.startHour}</td>
                            <td>${reservation.endHour}</td>


                            <td><a type="button" class="btn btn-danger"  href="/cancelReservation?id=${reservation.id}">Cancel</a> </td>

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