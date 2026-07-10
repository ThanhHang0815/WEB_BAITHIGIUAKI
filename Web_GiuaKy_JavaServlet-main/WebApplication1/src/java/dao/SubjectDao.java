package dao;

import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.User;
import util.PasswordUtil;

public class SubjectDao {
    private static List<User> users = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();

    static {
        // Tài khoản mặc định: admin / 123456 (Mật khẩu được băm trực tiếp khi lưu)
        users.add(new User("admin", PasswordUtil.hashPassword("123456")));
        
        // Dữ liệu môn học mẫu ban đầu
        subjects.add(new Subject("IT001", "Lap trinh Java", 3));
        subjects.add(new Subject("IT002", "Co so du lieu", 3));
        subjects.add(new Subject("AI001", "Tri tue nhan tao", 4));
    }

    // Kiểm tra đăng nhập bằng mật khẩu băm
    public User checkLogin(String username, String hashedPassword) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(hashedPassword)) {
                return u;
            }
        }
        return null;
    }

    // Lấy toàn bộ danh sách môn học
    public List<Subject> getAllSubjects() {
        return subjects;
    }

    // Thêm môn học mới
    public void addSubject(Subject sub) {
        subjects.add(sub);
    }

    // Lấy môn học theo mã ID
    public Subject getSubjectById(String id) {
        for (Subject s : subjects) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    // Sửa thông tin môn học
    public void updateSubject(Subject updatedSub) {
        for (Subject s : subjects) {
            if (s.getId().equals(updatedSub.getId())) {
                s.setName(updatedSub.getName());
                s.setCredits(updatedSub.getCredits());
                break;
            }
        }
    }

    // Xóa môn học
    public void deleteSubject(String id) {
        subjects.removeIf(s -> s.getId().equals(id));
    }
}