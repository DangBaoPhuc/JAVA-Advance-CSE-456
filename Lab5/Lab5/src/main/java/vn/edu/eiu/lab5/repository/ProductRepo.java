package vn.edu.eiu.lab5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.lab5.entity.Product;
import vn.edu.eiu.lab5.infra.JpaUtil;

import java.util.List;

@Repository
public class ProductRepo {

    public static void save(Product  product) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    //2. phuong thuc sua thong tinsinh vien (de trong transaction)

    public static void update(Product  product) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //merge neu sinh vinh da co thi cap nhat tai thong tin sv do k cap nhat khoa chinh
        // new khong co tu tao sinh vien moi
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }
    //3 . Phuong thuc xoa sinh vien theo id ca obj sinh vien

    public static void remove(Product  product) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        em.close();
    }

    //4 . phuong thuc tim sinh vien theo id
    public static Product findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Product.class, id);
    }

    public static List<Product> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("select p from Product p").getResultList();
    }

    public static List<Product> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("Select p from Product  p where p.name like :pname", Product.class)
                .setParameter("pname", "%" + name + "%");
        return q.getResultList();
    }
}
