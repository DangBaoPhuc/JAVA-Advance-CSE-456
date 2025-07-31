package vn.edu.eiu.lab5.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("lab5");
        } catch (Exception e) {
            System.out.println("Can not create lab5 " );
            throw new RuntimeException(e);
        }
    }

    private JpaUtil() {
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
