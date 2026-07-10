package controller;

import dao.SubjectDao;
import model.User;
import util.PasswordUtil;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        // BĂM MẬT KHẨU người dùng nhập vào
        String hashedPassword = PasswordUtil.hashPassword(pass);
        
        SubjectDao dao = new SubjectDao();
        User account = dao.checkLogin(user, hashedPassword);
        
        if (account != null) {
            // Đúng mật khẩu băm -> Lưu Session và sang trang quản lý
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("subjects");
        } else {
            // Sai mật khẩu
            request.setAttribute("error", "Sai tai khoan hoac mat khau!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}