package vn.edu.eiu.testlab.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.eiu.testlab.Infra.JpaUtil;
import vn.edu.eiu.testlab.entity.bidirectional.Major;

import java.util.List;

public class MajorRepository {

    // 1. Thêm mới một major
    public static void save(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    // 2. Cập nhật major
    public static void update(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }

    // 3. Xoá major
    public static void remove(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(major) ? major : em.merge(major)); // đảm bảo entity được quản lý
        em.getTransaction().commit();
        em.close();
    }

    // 4. Tìm major theo ID
    public static Major findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Major.class, id);
    }

    // 5. Tìm tất cả majors
    public static List<Major> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT m FROM Major m", Major.class).getResultList();
    }

    // 6. Tìm major theo tên
    public static List<Major> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("SELECT m FROM Major m WHERE m.majorName LIKE :pname", Major.class)
                .setParameter("pname", "%" + name + "%");
        return q.getResultList();
    }
}