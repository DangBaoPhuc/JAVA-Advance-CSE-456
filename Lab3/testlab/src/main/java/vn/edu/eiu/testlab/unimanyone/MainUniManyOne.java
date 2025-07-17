package vn.edu.eiu.testlab.unimanyone;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.testlab.Gender;
import vn.edu.eiu.testlab.Infra.JpaUtil;


import java.time.LocalDate;

/**de anh'  xa xuong database  ta can lam cac buoc sau
 * 1 tao moi object  major
 * 2. tao moi object student
 *
 */

public class MainUniManyOne {
    public static void main(String[] args) {
// test anh' xa theo huong nhieu mot
        //generate
        Major cseMajor = new Major("CSE","Software Engineering");
        Student std1 = new Student("Nhat Truong", Gender.MALE, LocalDate.parse("2000-10-10"),8.9);
        Student std2 = new Student("Nhi Nguyen", Gender.FEMALE, LocalDate.parse("2001-12-15"),9.6);
        std1.setMajor(cseMajor);
        std2.setMajor(cseMajor);


        // anh xa xuong  database
        EntityManager em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(cseMajor);
        em.persist(std1);
        em.persist(std2);
        em.getTransaction().commit();
        em.close();

    }

}
