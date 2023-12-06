<%--
  Created by IntelliJ IDEA.
  User: Luannv
  Date: 11/10/2023
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <table class="table">
                <thead>
                <tr>
                    <th>Mã sinh viên</th>
                    <th>Họ và Tên</th>
                    <th>Giới tính</th>
                    <th>Ngày sinh</th>
                    <th>Địa chỉ</th>
                    <th>Lớp</th>
                    <th>Học bổng</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="st">
                    <tr>
                        <td>${st.student_id}</td>
                        <td>${st.student_name}</td>
                        <td>${st.gender}</td>
                        <td>${st.birth_day}</td>
                        <td>${st.address}</td>
                        <td>${st.course_id}</td>
                        <td>${st.scholarship}</td>
                        <td>
                                <%--                            <a class="btn btn-primary" href="StudentServlet?action=edit&id=${st.studentCode}">Edit</a>--%>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
            <a href="views/student-add.jsp">The moi sinh vien</a>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>