package vn.edu.eiu.lab2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.lab2.entity.Student;

import java.util.List;

public class Main {
    private static        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
    public static void main(String[] args) {
//insertStudent();
        getStudentById();
        getAllStudent();
        updateStudentById();
        deleteStudentById("CSE2025003");
        getStudentsByConditions("Dang Phuc",8);
    }
    public static void insertStudent() {

        //tao nguười quản lý tương tác đatabase
        EntityManager em = emf.createEntityManager();

        //2. chuẩn bi data insert
//        Student student1 = new Student("CSE2025001","Lan Le",2000, 8.5);
        Student student2 = new Student("CSE2025002","Lan Le",2000, 8.5);
        Student student3 = new Student("CSE2025003","Lan Le",2000, 8.5);
        //3 Người quản lý tực hện viec insert
        /*
        Khi thuc hien cac cau lenh dang DML ( Data MAnipulation Language: co thay doi du lieu thi
        bat buoc dat trong 1 transaction de dam bao tinh ACID  : Atomy ConsistencyIsIsolation Durability
        Mot la thuc thi cau lenh tu dau den cuoi 2 la khong lamf gi ca rollback
         */
        em.getTransaction().begin();
//        em.persist(student1); //ghi xuong database nhung chua thuc thi
        em.persist(student2); em.persist(student3);
        em.getTransaction().commit(); // da ghi xuong database neuu khong thanh cong thi huy rollback
        em.close(); //cho quan ly nghi
    }

    public static void getStudentById(){
        EntityManager em = emf.createEntityManager();
        Student student1 = em.find(Student.class, "CSE2025001");
        System.out.println("Student found: " + student1.toString());
    }
    public static void getAllStudent(){
        EntityManager em = emf.createEntityManager();
        List<Student> listStudent;
        listStudent = em.createQuery("Select s from Student s", Student.class).getResultList();
        for (int i = 0; i < listStudent.size() ; i++) {
            System.out.println("Student found: " + listStudent.get(i).toString());
        }
    }
    public  static void getStudentsByConditions (String name, double gpa){
        EntityManager em = emf.createEntityManager();
        List<Student> listStudent;
        listStudent= em.createQuery("Select s from Student s where s.name = :name and s.gpa > :gpa", Student.class).setParameter("name",name).setParameter("gpa",gpa).getResultList();

        for (int i = 0; i < listStudent.size() ; i++) {
            System.out.println("Student found: " + listStudent.get(i).toString());
        }}
    public static void	updateStudentById(){
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();

            // Tìm sinh viên có ID = "CSE2025001"
            Student student2 = em.find(Student.class, "CSE2025002");

            if (student2 != null) {
                // Cập nhật thông tin
                student2.setName("Dang Phuc");
                student2.setYob(2002);
                student2.setGpa(9);

                // Hibernate sẽ tự hiểu là bạn đang cập nhật, không cần gọi em.merge() nếu entity đang được quản lý
            } else {
                System.out.println("Không tìm thấy sinh viên có ID: CSE2025002");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public static void getStudentsByGpa(){
        EntityManager em = emf.createEntityManager();
        List<Student> listStudent;
        listStudent = em.createQuery("Select s from Student s where s.gpa> 8.5", Student.class).getResultList();
        for (int i = 0; i < listStudent.size() ; i++) {
            System.out.println("Student found: " + listStudent.get(i).toString());
        }
    }

    public static void deleteStudentById (String studentId){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Tìm sinh viên theo ID
            Student student = em.find(Student.class, studentId);

            if (student != null) {
                em.remove(student); // Xoá khỏi DB
                System.out.println("Đã xoá sinh viên có ID: " + studentId);
            } else {
                System.out.println("Không tìm thấy sinh viên với ID: " + studentId);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}