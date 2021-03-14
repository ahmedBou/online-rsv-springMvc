<html>
<head>
    <title>Reservation Query</title>
</head>

<body>
<form method="post">
    Court Name
    <input type="text" name="courtName" value="${courtName}"/>
    <input type="submit" value="Query"/>
</form>

${reservation.nomSalle}
<table border="1">
    <tr>
        <th>Nom de salle</th>
        <th>Date</th>
        <th>Hour</th>
        <th>Student</th>
    </tr>

    <c:forEach items="${reservations}" var="reservation">
        <tr>
            <td>${reservation.nomSalle}</td>

            <td><fmt:formatDate value="${reservation.dateAsUtilDate}" pattern="yyyy-MM-dd"/></td>
            <td>${reservation.hour}</td>
            <td>${reservation.student.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>