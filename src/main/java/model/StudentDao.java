package model;

import interfaces.InterfaceDao;
import util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10/12/2018.
 */
public class StudentDao implements InterfaceDao<Student> {
    public StudentDao() {

    }

    public void createStudentTable () {

        try (Connection connection = ConnectionConfiguration.getConnection();
        Statement statement = connection.createStatement()) {
        statement.execute("CREATE TABLE IF NOT EXISTS student (id int primary key unique auto_increment," +
                "first_name varchar(55), last_name varchar(55))");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void save(Student student) {

        try (Connection connection = ConnectionConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (first_name,last_name)" +
                    "VALUES (?, ?)")) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("Thank you "+student.getFirstName()+". Your record has been stored.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student, long id) {

        try (Connection connection = ConnectionConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET " +
                     "first_name = ?, last_name = ? WHERE id = ?")) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> list() {
        List<Student> students = new ArrayList<Student>();

        try (Connection connection = ConnectionConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM student")) {


            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getById(long userId) {

        Student student = new Student();

        try (Connection connection = ConnectionConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id = ?")){
             preparedStatement.setLong(1, userId);
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public void delete(long id) {

        try (Connection connection = ConnectionConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?")){
             preparedStatement.setLong(1, id);
             preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
