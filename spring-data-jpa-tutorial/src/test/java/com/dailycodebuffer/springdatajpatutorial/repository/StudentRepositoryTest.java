package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entitiy.Guardian;
import com.dailycodebuffer.springdatajpatutorial.entitiy.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("raghav@gmail.com")
                .firstName("Raghav")
                .lastName("MJ")
//                .guardianName("Keshav")
//                .guardianEmail("keshav@gmail.com")
//                .guardianMobile("123345533")
                .build();
        studentRepository.save(student);
    }


    @Test
    public void saveStudentWithGuardianDetails() {

        Guardian guardian = Guardian.builder()
                .email("paramesh@gmail.com")
                .name("paramesh")
                .mobile("456231542")
                .build();

        Student student = Student.builder()

                .emailId("thilak@gmail.com")
                .firstName("thilak")
                .lastName("Anand")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void listAllStudents() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("thilak");
        System.out.println("Starting with 'thilak' : " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("th");
        System.out.println("Starting with 'thilak' : " + studentList);
    }


    @Test
    public void printStudentBasedOnGuradianName() {
        List<Student> studentList = studentRepository.findByGuardianName("paramesh");
        System.out.println("Having guardian name as 'paramesh' : " + studentList);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("raghav@gmail.com");
        System.out.println("Getting student via email address is : " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("raghav@gmail.com");
        System.out.println("Getting student first name via email address is : " + studentName);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("raghav@gmail.com");
        System.out.println("Getting student via email address - native sql query is : " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("raghav@gmail.com");
        System.out.println("Getting student via email address - native sql query named param is : " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Raghavendra", "raghav@gmail.com");
    }
}