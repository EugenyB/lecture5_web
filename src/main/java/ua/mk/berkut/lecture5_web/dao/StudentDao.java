package ua.mk.berkut.lecture5_web.dao;

import jakarta.annotation.Resource;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;
import ua.mk.berkut.lecture5_web.data.Book;
import ua.mk.berkut.lecture5_web.data.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentDao {

    @Resource(name = "java:app/jdbc/nuos")
    private DataSource ds;


    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student")){
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double rating = rs.getDouble("rating");
                students.add(new Student(id, name, age, rating));
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Student student) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into student (age, name, rating) values (?,?,?)")
        ) {
            ps.setInt(1, student.getAge());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getRating());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from student where id = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student find(int id) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from student where id = ?")
        ) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                double rating = resultSet.getDouble("rating");
                return new Student(id, name, age, rating);
            }
            return new Student();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void findBooks(Student student) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from books where student_id = ?")
        ) {
            ps.setInt(1, student.getId());
            student.getBooks().clear();
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int pages = resultSet.getInt("pages");
                student.getBooks().add(new Book(id, title, pages));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
