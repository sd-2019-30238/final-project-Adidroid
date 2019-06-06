<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

    <title>
        Table Details
    </title>


</head>

<body>

<div class="container">
    <center>

        <br><br>
        <H1>Reservations on this table</H1> <br>
        <div class="container">
            <table class="table table-striped">
                <thead>
                <tr>

                    <th>Start Hour</th>
                    <th>End Hour</th>


                </tr>
                </thead>

                <tbody>
                <c:forEach items="${reservations}" var="reservation" >
                    <tr>
                        <td>${reservation.startHour}</td>
                        <td>${reservation.endHour}</td>




                    </tr>



                </c:forEach>


                </tbody>
            </table>


    </center>
    <br><br><br>

    <div class="container">

        <form method="post">
            <center>
                Start Hour : <input type="text" name="startHour"/> <br>
                End Hour   :&nbsp <input type="text" name="endHour"/>
                 <br><br>

                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <input type="submit" value="Make reservation" /> &nbsp&nbsp&nbsp

            </center>
        </form>

    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</div>
</body>

</html>