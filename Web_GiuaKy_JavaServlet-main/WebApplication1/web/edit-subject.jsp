<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cap Nhat Mon Hoc</title>
</head>
<body>
    <h2>Chinh Sua Mon Hoc</h2>
    <form action="subjects?action=update" method="post">
        Mã môn (Không được sửa): <b>${subject.id}</b>
        <input type="hidden" name="id" value="${subject.id}"/><br/><br/>
        
        Tên môn mới: <input type="text" name="name" value="${subject.name}" required/><br/><br/>
        Số tín chỉ mới: <input type="number" name="credits" value="${subject.credits}" required/><br/><br/>
        
        <button type="submit">Cap Nhat</button>
        <a href="subjects">Quay lai</a>
    </form>
</body>
</html>