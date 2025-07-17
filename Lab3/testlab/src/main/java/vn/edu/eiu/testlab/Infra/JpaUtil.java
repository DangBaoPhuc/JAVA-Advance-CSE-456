package vn.edu.eiu.testlab.Infra;



import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


/**Lop nay dung de thuc hien cac tac vu sau
 * 1. Khoi tao ket noi Database bang cach
 *
 */
public class JpaUtil {
    private static  final EntityManagerFactory emf;


    // doan code static khong ten   chi chay mot lan ngay khi lop JpaUtil duoc cham den

    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1_lab3");
        }
        catch (Exception e) {
            System.out.println("Can not create entity pu1_lab3.");
            throw new RuntimeException(e);
        }
    }


    //de doan code static() tren chay duoc thi can phai vo hieu hoa tat ca constructor. Mac dinh khong khai bao constructor
    // thi class se ke thua constructror rong cua class object
    private JpaUtil(){}
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();

    }
}
