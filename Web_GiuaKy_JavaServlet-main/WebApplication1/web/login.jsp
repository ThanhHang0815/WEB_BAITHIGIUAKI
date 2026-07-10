<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dang Nhap</title>
</head>
<body>
    <h2>Form Dang Nhap (Mat khau bam SHA-256)</h2>
    <p style="color:red;">${error}</p>
    <form action="login" method="post">
        Tai khoan: <input type="text" name="username" required/><br/><br/>
        Mat khau: <input type="password" name="password" required/><br/><br/>
        <button type="submit">Dang Nhap</button>
    </form>
    <p style="color: gray;">Tài khoản test: admin / 123456</p>
</body>
</html>