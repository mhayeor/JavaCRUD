import model.Student;
import model.StudentDao;

import java.util.Scanner;

/**
 * Created by User on 10/12/2018.
 */
public class StudentRegistration{


    public static void main(String[] args) {

        /**Instantiate StudentDao**/
        StudentDao studentDao = new StudentDao();

        /**Create table. Note that you can always run this
         * method. Table will be created only once (if it doesn't exist)**/
        studentDao.createStudentTable();

        /**Save Student Record**/
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your firstname: ");
//        String fname = scanner.next();
//        System.out.println("Enter your lastname: ");
//        String lname = scanner.next();
//        Student student = new Student(fname,lname);
//        studentDao.save(student);

        /**Get Student Record by ID**/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your user id: ");
        long userId = scanner.nextLong();
        Student studentSelect = studentDao.getById(userId);
        System.out.println(studentSelect.getId()+", "+studentSelect.getFirstName()+", "+studentSelect.getLastName());

        /**Get All Student Records**/
//        List<Student> students= studentDao.list();
//        /**To retrieve values, you will have to use "for each" loop
//         * to iterate through list**/
//        for(Student p : students) {
//            System.out.println(p.getId()+", "+p.getFirstName()+", "+p.getLastName());
//        }

        /**Delete Student Record by ID**/
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter user id to delete: ");
//        long userId = scanner.nextLong();
//        studentDao.delete(userId);
//        System.out.println("Student deleted.");

        /**Update Student Record by ID**/
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter user id to update: ");
//        long userId = scanner.nextLong();
//        System.out.println("Enter firstname to update: ");
//        String fname = scanner.next();
//        System.out.println("Enter lastname to update: ");
//        String lname = scanner.next();
//        Student studentUpdate = new Student(fname,lname);
//        studentDao.update(studentUpdate,userId);
//        System.out.println("Student updated.");


    }

}
