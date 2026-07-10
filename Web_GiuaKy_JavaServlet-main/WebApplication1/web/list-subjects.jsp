<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quan Ly Mon Hoc</title>
</head>
<body>
    <h2>Danh Sach Mon Hoc Dang Ky</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Ma Mon</th>
            <th>Ten Mon Hoc</th>
            <th>So Tin Chi</th>
            <th>Hanh Dong</th>
        </tr>
        <c:forEach items="${subjectList}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.credits}</td>
                <td>
                    <a href="subjects?action=edit&id=${s.id}">Sua</a> | 
                    <a href="subjects?action=delete&id=${s.id}" onclick="return confirm('Xoa mon nay?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Them Mon Hoc Moi</h3>
    <form action="subjects?action=add" method="post">
        Ma mon: <input type="text" name="id" required/><br/>
        Ten mon: <input type="text" name="name" required/><br/>
        Tin chi: <input type="number" name="credits" required/><br/><br/>
        <button type="submit">Them Mon</button>
    </form>
</body>
</html>