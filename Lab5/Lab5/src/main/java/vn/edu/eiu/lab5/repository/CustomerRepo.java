package vn.edu.eiu.lab5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.infra.JpaUtil;

import java.util.List;

@Repository
public class CustomerRepo {

    public static void save(Customer customer) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
    }

    //2. phuong thuc sua thong tinsinh vien (de trong transaction)

    public static void update(Customer customer) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //merge neu sinh vinh da co thi cap nhat tai thong tin sv do k cap nhat khoa chinh
        // new khong co tu tao sinh vien moi
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }
    //3 . Phuong thuc xoa sinh vien theo id ca obj sinh vien

    public static void remove(Customer customer) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(customer);
        em.getTransaction().commit();
        em.close();
    }

    //4 . phuong thuc tim sinh vien theo id
    public static Customer findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Customer.class, id);
    }

    public static List<Customer> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("select c from Customer c").getResultList();
    }

    public static List<Customer> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("Select c from Customer  c where c.name like :pname", Customer.class)
                .setParameter("pname", "%" + name + "%");
        return q.getResultList();
    }
}
