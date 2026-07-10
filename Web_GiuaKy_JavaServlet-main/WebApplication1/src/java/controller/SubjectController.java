package controller;

import dao.SubjectDao;
import model.Subject;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/subjects")
public class SubjectController extends HttpServlet {
    private SubjectDao dao = new SubjectDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // BẢO MẬT: Kiểm tra Đăng nhập
        HttpSession session = request.getSession();
        if (session.getAttribute("account") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "delete":
                String idDel = request.getParameter("id");
                dao.deleteSubject(idDel);
                response.sendRedirect("subjects");
                break;
                
            case "edit":
                String idEdit = request.getParameter("id");
                Subject sub = dao.getSubjectById(idEdit);
                request.setAttribute("subject", sub);
                request.getRequestDispatcher("edit-subject.jsp").forward(request, response);
                break;
                
            case "list":
            default:
                List<Subject> list = dao.getAllSubjects();
                request.setAttribute("subjectList", list);
                request.getRequestDispatcher("list-subjects.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int credits = Integer.parseInt(request.getParameter("credits"));
            
            dao.addSubject(new Subject(id, name, credits));
            response.sendRedirect("subjects");
            
        } else if ("update".equals(action)) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int credits = Integer.parseInt(request.getParameter("credits"));
            
            dao.updateSubject(new Subject(id, name, credits));
            response.sendRedirect("subjects");
        }
    }
}