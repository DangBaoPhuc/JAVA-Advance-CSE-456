package vn.edu.eiu.lab5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.infra.JpaUtil;

import java.util.List;

@Repository
public class InvoiceRepo {

    public static void save(Invoice invoice) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(invoice);
        em.getTransaction().commit();
        em.close();
    }

    //2. phuong thuc sua thong tinsinh vien (de trong transaction)

    public static void update(Invoice  invoice) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //merge neu sinh vinh da co thi cap nhat tai thong tin sv do k cap nhat khoa chinh
        // new khong co tu tao sinh vien moi
        em.merge(invoice);
        em.getTransaction().commit();
        em.close();
    }
    //3 . Phuong thuc xoa sinh vien theo id ca obj sinh vien

    public static void remove(Invoice  invoice) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.remove(invoice);
        em.getTransaction().commit();
        em.close();
    }

    //4 . phuong thuc tim sinh vien theo id
    public static Invoice findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Invoice.class, id);
    }

    public static List<Invoice> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("select i from Invoice i").getResultList();
    }

    public static List<Invoice> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("Select p from Invoice  p where p.name like :pname", Invoice.class)
                .setParameter("pname", "%" + name + "%");
        return q.getResultList();
    }
}
