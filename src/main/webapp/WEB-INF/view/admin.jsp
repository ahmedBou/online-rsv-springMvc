<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Online Reservation</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="/FinalSpringMvc/url/css/home.css">
</head>
<body>
<div class="w3-row-padding" style="margin: 0 auto">
    <div class="w3-margin-bottom">
        <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
            <form method="POST" action="createDate">
                <div class="w3-blue w3-xlarge w3-padding-16">Create new
                    date</div>

                <div style="display: flex;    justify-content: space-between;">
                    <div>
                        <label id="appointmentDate">Enter appointment date:</label>
                        <input
                                class="w3-input w3-padding-16" name="appointmentDate"
                                autocomplete="off" type="date" id="appointmentDate" required>
                    </div>

                    <div>
                        <label
                                id="appointmentTime">Enter appointment time:</label>

                        <input
                                class="w3-input w3-padding-16" name="appointmentTime"
                                id="appointmentTime" autocomplete="off" type="time" required>

                    </div>
                    <div>
                        <input
                                class="w3-input w3-padding-16" autocomplete="off"
                                placeholder="Enter number os seats" name="seatsNumber"
                                type="number" required>
                    </div>
                </div>
                <li class="w3-light-grey w3-padding-24">
                    <button class="w3-button w3-white w3-padding-large w3-hover-black">Create
                        new date</button>
                </li>
            </form>

        </ul>
    </div>
</div>

<div style="display: flex">
    <div class="w3-container">
        <h2 class="w3-large">Users want you to approve their registration</h2>
        <table class="w3-table-all">
            <tr>
                <th class="w3-center w3-small">First Name</th>
                <th class="w3-center w3-small">Last Name</th>
                <th class="w3-center w3-small">Email</th>
                <th class="w3-center w3-small">Approve</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td class="w3-center w3-tiny">${user.firstName}</td>
                    <td class="w3-center w3-tiny">${user.lastName}</td>
                    <td class="w3-center w3-tiny">${user.email}</td>
                    <td class="w3-center w3-row"
                        style="display: flex; width: fit-content; margin: 0 auto;">
                        <form action="accept" method="post">
                            <input type="hidden" name="id" value="${user.id}"> <input
                                type="hidden" name="email" value="${user.email}">
                            <button type="submit" class="w3-button w3-tiny">Accept</button>
                        </form>
                        <form action="reject" method="post">
                            <input type="hidden" name="id" value="${user.id}"> <input
                                type="hidden" name="email" value="${user.email}">
                            <button type="submit" class="w3-button w3-tiny">Reject</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="w3-container">
        <h2 class="w3-large">Users want you to approve their appointments</h2>
        <table class="w3-table-all">
            <tr>
                <th class="w3-center w3-small">First Name</th>
                <th class="w3-center w3-small">Last Name</th>
                <th class="w3-center w3-small">Email</th>
                <th class="w3-center w3-small">Appointment Date</th>
                <th class="w3-center w3-small">Appointment Time</th>
                <th class="w3-center w3-small">Seats Number</th>
                <th class="w3-center w3-small">Approve</th>
            </tr>

            <c:forEach var="appointment" items="${appointmentsList}">
                <tr>
                    <td class="w3-center w3-tiny">${appointment.user.firstName}</td>
                    <td class="w3-center w3-tiny">${appointment.user.lastName}</td>
                    <td class="w3-center w3-tiny">${appointment.user.email}</td>
                    <td class="w3-center w3-tiny">${appointment.appointmentDate}</td>
                    <td class="w3-center w3-tiny">${appointment.appointmentTime}</td>
                    <td class="w3-center w3-tiny">${appointment.seatsNumber}</td>
                    <td class="w3-center w3-row"
                        style="display: flex; width: fit-content; margin: 0 auto;">
                        <form action="acceptAppointment" method="post">
                            <input type="hidden" name="dateId" value="${appointment.dateId}">
                            <input type="hidden" name="id" value="${appointment.id}">
                            <input type="hidden" name="user.email"
                                   value="${appointment.user.email}">
                            <button type="submit" class="w3-button w3-tiny">Accept</button>
                        </form>
                        <form action="rejectAppointment" method="post">
                            <input type="hidden" name="id" value="${appointment.id}">
                            <input type="hidden" name="user.email"
                                   value="${appointment.user.email}">
                            <button type="submit" class="w3-button w3-tiny">Reject</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>



</div>
</body>
</html>