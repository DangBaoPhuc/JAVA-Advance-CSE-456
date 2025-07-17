package vn.edu.eiu.testlab.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.eiu.testlab.Infra.JpaUtil;
import vn.edu.eiu.testlab.entity.bidirectional.Student;

import java.util.List;

public class StudentRepository {


    //1. phuong thuc them sinh vien moi (de trong transaction de dam bao tinh ACID)
    public static void save(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    //2. phuong thuc sua thong tinsinh vien (de trong transaction)

    public static void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //merge neu sinh vinh da co thi cap nhat tai thong tin sv do k cap nhat khoa chinh
        // new khong co tu tao sinh vien moi
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }
    //3 . Phuong thuc xoa sinh vien theo id ca obj sinh vien

    public static void remove(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    //4 . phuong thuc tim sinh vien theo id
    public static Student findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Student.class, id);
    }

    public static List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("select s from Student s").getResultList();
    }

    public static List<Student> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("Select s from Student  s where s.fullName like :pname", Student.class)
                .setParameter("pname", "%" + name + "%");
        return q.getResultList();
    }

}