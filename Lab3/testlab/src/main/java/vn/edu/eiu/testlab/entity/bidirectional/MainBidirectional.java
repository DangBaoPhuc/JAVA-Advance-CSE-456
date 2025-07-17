package vn.edu.eiu.testlab.entity.bidirectional;


import jakarta.persistence.EntityManager;

import vn.edu.eiu.testlab.Gender;
import vn.edu.eiu.testlab.Infra.JpaUtil;

import java.time.LocalDate;

public class MainBidirectional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Create a school with correct constructor: (schoolId, schoolName, location)
            School school = new School("S01", "Engineering School", "EIU Campus");

            // Create a major
            Major major = new Major();
            major.setMajorId("M01");
            major.setMajorName("Software Engineering");
            school.addMajor(major); // Automatically sets major.setSchool(school)

            // Create a student
            Student student = new Student();
            student.setFullName("John Doe");
            student.setGender(Gender.MALE);
            student.setDob(LocalDate.of(2003, 5, 14));
            student.setGpa(3.7);
            student.setEnrollmentYear(2021);
            student.setSchool(school);
            major.addStudent(student); // Automatically sets student.setMajor(major)

            // Persist the root object (School) – with CascadeType.ALL it saves everything
            em.persist(school);

            em.getTransaction().commit();
            System.out.println("✅ Data saved successfully!");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}
