package ua.mk.berkut.lecture5_web.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import ua.mk.berkut.lecture5_web.dao.StudentDao;
import ua.mk.berkut.lecture5_web.data.Student;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class StudentBean implements Serializable {

    @EJB
    StudentDao studentDao;

    private Student student = new Student();

    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    public Student getStudent() {
        return student;
    }

    public void add() {
        studentDao.save(student);
        student = new Student();
    }

    public void delete(int id) {
        studentDao.deleteById(id);
    }

    public String showBooks(int id) {
        student = studentDao.find(id);
        studentDao.findBooks(student);
        return "show_books";
    }
}
