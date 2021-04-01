<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Online Reservation</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/FinalSpringMvc/url/css/home.css" rel="stylesheet">
<body class="">

<!-- Page Content -->
<div class="w3-padding-large" id="main">
    <!-- Header/Home -->
    <header class="w3-container w3-padding-32 w3-center "
            id="home">
        <!--		<h1 class="w3-jumbo">
                    <span class="w3-hide-small">I'm</span> Sofia Tancredy.
                </h1>
                <p>Sofia School Manager.</p> -->
        <!--		<img src="/FinalSpringMvc/url/images/main.png" alt="boy"
                    class="w3-image" width="992" height="1108"> -->
    </header>
    <div class=" w3-button w3-white w3-padding-large"
         style="position: absolute; left: 0; top: 0;">
        <a href="logout" class="w3-button">Logout</a>
    </div>
    <!-- About Section
    <div class="w3-content w3-justify w3-text-grey w3-padding-64"
        id="about">
        <h2 class="w3-text-light-grey">Sofia Tancredy</h2>
        <hr style="width: 200px" class="w3-opacity">
        <p>Hello, My name is sofia and i am manager of the sofia school,
            and if you want to join our school:
        <p>- You can first sign up on the school
        <p>
        <p>- You can login to your account
        <p>
        <p>- You can make an appointment
        <p>
        <p></p>
    </div>
    -->
    <!-- Signup & Login Section -->
    <div class="w3-content w3-justify w3-text-grey w3-padding-64"
         id="login-signup-section">
        <!-- Grid for pricing tables -->
        <div class="w3-row-padding" style="margin: 0 -16px">
            <div class="w3-half w3-margin-bottom">
                <ul
                        class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
                    <form method="POST" action="/FinalSpringMvc/signup">
                        <div class="w3-blue w3-xlarge">Sign Up</div>

                        <input class="w3-padding-16" style="width: 100%"
                               placeholder="Enter your firstname" name="firstName"
                               autocomplete="off" type="text" required>

                        <input style="width: 100%"
                               class="w3-padding-16" placeholder="Enter your lastname"
                               name="lastName" autocomplete="off" type="text" required>

                        <input style="width: 100%"
                               class="w3-padding-16" placeholder="Enter your email"
                               name="email" autocomplete="off" type="email" required>

                        <input style="width: 100%"
                               class="w3-padding-16" placeholder="Enter your password"
                               name="password" type="password" required>
                        <li class="w3-blue">

                            <button
                                    class="w3-button w3-white w3-hover-black">Sign
                                Up</button>
                        </li>
                    </form>

                </ul>
            </div>
            <div class="w3-half">
                <ul
                        class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
                    <form method="POST" action="login">
                        <div class="w3-blue w3-xlarge">Login</div>

                        <input style="width: 100%" class="w3-padding-16"
                               placeholder="Enter your email" autocomplete="off" type="email"
                               name="email" required>

                        <input style="width: 100%" class="w3-padding-16"
                               placeholder="Enter your password" type="password"
                               name="password" required>

                        <div class="w3-blue" style="    height: 57px; display: flex; justify-content: center;align-items: center;">
                            <button
                                    class="w3-button w3-white w3-padding-large w3-hover-black"
                                    type="submit">Login</button>
                        </div>
                    </form>
                </ul>
            </div>
        </div>

        <!-- Appointment Section -->
        <div class="w3-padding-64 w3-content w3-text-grey"
             id="ask-for-appointment" style="margin-top: 200px">

            <c:if test="${isAppointmentMade != null}">
                <c:if test="${isAppointmentMade eq 'true'}">
                    <div class="w3-panel w3-green w3-padding-16">Your appointment
                        booked successfully</div>
                </c:if>

                <c:if test="${isAppointmentMade eq 'false'}">
                    <div class="w3-panel w3-red w3-padding-16">You can't make an
                        appointment</div>
                </c:if>
            </c:if>

            <!-- Get next day: LocalDate.parse("2021-02-20").plusDays(1).toString() -->
            <form action="appointment" method="POST">

                <div class="w3-padding-16">
                    <select class="w3-select w3-padding-16" name="appointmentDate">
                        <option class="w3-padding-16" value="" disabled selected>Choose
                            date appointment</option>

                        <c:forEach var="date" items="${datesList}">
                            <option class="w3-padding-16" value="${date.appointmentDate}, ${date.id}">${date.appointmentDate}</option>
                        </c:forEach>

                    </select>

                    <select class="w3-select w3-padding-16" name="appointmentTime">
                        <option class="w3-padding-16" value="" disabled selected>Choose
                            time appointment</option>

                        <c:forEach var="date" items="${datesList}">
                            <option class="w3-padding-16" value="${date.appointmentTime}">${date.appointmentTime}</option>
                        </c:forEach>

                    </select>

                    <select class="w3-select w3-padding-16" name="seatsNumber">
                        <option class="w3-padding-16" value="" disabled selected>Choose
                            number of seats</option>

                        <c:forEach var="date" items="${datesList}">
                            <option class="w3-padding-16" value="${date.seatsNumber}">${date.seatsNumber}</option>
                        </c:forEach>
                    </select>
                </div>
                <button
                        class="w3-margin-top w3-block w3-button w3-blue w3-padding-large"
                        type="submit">make an appointment</button>
            </form>
            <!-- End Appointment Section -->
        </div>
    </div>
</body>
</html>