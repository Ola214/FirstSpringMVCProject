<%-- 
    Document   : AdmissionSuccess
    Created on : 2015-06-28, 00:12:32
    Author     : Olaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admission Success JSP Page</title>
    </head>
    <body>
        <h1>${headerMessage}</h1>
        <h3>Congratulation!! the Engineering college has processed your Application successfully</h3>
        <h2>Details submitted by you: </h2>
        <table>
            <tr>
                <td>Student Name: </td>
                <td>${student.studentName}</td>
            </tr>
            <tr>
                <td>Student Hobby: </td>
                <td>${student.studentHobby}</td>
            </tr>
            <tr>
                <td>Student Mobile: </td>
                <td>${student.studentMobile}</td>
            </tr>
            <tr>
                <td>Student DOB: </td>
                <td>${student.studentDOB}</td>
            </tr>
            <tr>
                <td>Student Skills: </td>
                <td>${student.studentSkills}</td>
            </tr>
            <tr>
                <td>Student Address</td>
                <td>
                    country: ${student.studentAddress.country}
                    city: ${student.studentAddress.city}
                    street: ${student.studentAddress.street}
                    pincode: ${student.studentAddress.pincode}
                </td>
            </tr>
        </table>
    </body>
</html>
