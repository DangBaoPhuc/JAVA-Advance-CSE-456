package vn.edu.eiu.testlab.unionemany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import vn.edu.eiu.testlab.Gender;
import vn.edu.eiu.testlab.Infra.JpaUtil;

import java.time.LocalDate;

public class MainUniOneMany {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Create major
            Major major = new Major();
            major.setMajorId("CSE");
            major.setMajorName("Computer Science and Engineering");

            // Create students
            Student student1 = new Student();
            student1.setFullName("Alice Nguyen");
            student1.setGender(Gender.FEMALE);
            student1.setDob(LocalDate.of(2003, 5, 10));
            student1.setEnrollmentYear(2021);

            Student student2 = new Student();
            student2.setFullName("Bob Tran");
            student2.setGender(Gender.MALE);
            student2.setDob(LocalDate.of(2002, 11, 15));
            student2.setEnrollmentYear(2020);

            // Add students to major
            major.addStudent(student1);
            major.addStudent(student2);

            // Persist major (students will be persisted too due to cascade)
            em.persist(major);

            em.getTransaction().commit();

            System.out.println("Data saved successfully!");
        } finally {
            em.close();

        }
    }
}
