package vn.edu.eiu.testlab.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.eiu.testlab.Infra.JpaUtil;
import vn.edu.eiu.testlab.entity.bidirectional.School;

import java.util.List;

public class SchoolRepository {

    // 1. Thêm mới trường học
    public static void save(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    // 2. Cập nhật trường học
    public static void update(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    // 3. Xoá trường học
    public static void remove(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(school) ? school : em.merge(school)); // Đảm bảo entity được quản lý
        em.getTransaction().commit();
        em.close();
    }

    // 4. Tìm theo ID
    public static School findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(School.class, id);
    }

    // 5. Tìm tất cả
    public static List<School> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    // 6. Tìm theo tên
    public static List<School> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("SELECT s FROM School s WHERE s.name LIKE :pname", School.class)
                .setParameter("pname", "%" + name + "%");
        return q.getResultList();
    }
}