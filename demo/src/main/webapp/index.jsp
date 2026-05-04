<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
    <title>Distance Calculator</title>
</head>
<body>

<h2>Calculating the distance between two points</h2>

<form method="post">
    <label>Latitude 1:</label>
    <input type="text" name="lat1"><br><br>

    <label>Longitude 1:</label>
    <input type="text" name="lon1"><br><br>

    <label>Latitude 2:</label>
    <input type="text" name="lat2"><br><br>

    <label>Longitude 2:</label>
    <input type="text" name="lon2"><br><br>

    <input type="submit" value="Calculate">
</form>

<hr>

<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        try {
            double R = 6371000; // радіус Землі

            double lat1 = Math.toRadians(Double.parseDouble(request.getParameter("lat1")));
            double lon1 = Math.toRadians(Double.parseDouble(request.getParameter("lon1")));
            double lat2 = Math.toRadians(Double.parseDouble(request.getParameter("lat2")));
            double lon2 = Math.toRadians(Double.parseDouble(request.getParameter("lon2")));

            double dLat = lat2 - lat1;
            double dLon = lon2 - lon1;

            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                       Math.cos(lat1) * Math.cos(lat2) *
                       Math.sin(dLon / 2) * Math.sin(dLon / 2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            double distance = R * c;
%>

<h3>Distance: <%= String.format("%.2f", distance) %> m</h3>

<%
        } catch (Exception e) {
%>

<p style="color:red;">Error! Please enter correct numeric values.</p>

<%
        }
    }
%>

</body>
</html>