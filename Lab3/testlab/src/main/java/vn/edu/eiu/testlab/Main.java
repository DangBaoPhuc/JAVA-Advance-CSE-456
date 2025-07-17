package vn.edu.eiu.testlab;

import vn.edu.eiu.testlab.entity.bidirectional.Major;
import vn.edu.eiu.testlab.entity.bidirectional.School;
import vn.edu.eiu.testlab.service.MajorService;
import vn.edu.eiu.testlab.service.SchoolService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SchoolService schoolService = new SchoolService();
        MajorService majorService = new MajorService();

        // ======= CREATE SCHOOL ==========
        School school = new School("CNT", "Công nghệ thông tin", "TP HCM");
        schoolService.createSchool(school);
        System.out.println("Created School: " + school.getSchoolName());

        // ======= CREATE MAJOR ==========
        Major m1 = new Major("M001", "Khoa học máy tính");
        Major m2 = new Major("M002", "Kỹ thuật phần mềm");

        // Set quan hệ 2 chiều
        school.addMajor(m1);
        school.addMajor(m2);

        // Update school để lưu cả danh sách majors
        schoolService.updateSchool(school);
        System.out.println("Added majors to school.");

        // ======= READ ALL SCHOOLS ==========
        List<School> schools = schoolService.getAllSchools();
        System.out.println("Danh sách tất cả các trường:");
        for (School s : schools) {
            System.out.println("School: " + s.getSchoolName() + " - Location: " + s.getLocation());
            for (Major major : s.getMajors()) {
                System.out.println("  + Major: " + major.getMajorName());
            }
        }

        // ======= UPDATE SCHOOL ==========
        School schoolToUpdate = schoolService.getSchoolById("CNT");
        schoolToUpdate.setLocation("Bình Dương");
        schoolService.updateSchool(schoolToUpdate);
        System.out.println("Updated school location.");

        // ======= DELETE MAJOR ==========
        majorService.deleteMajor("M002");
        System.out.println("Deleted major with ID M002.");

        // ======= DELETE SCHOOL ==========
        School schoolToDelete = schoolService.getSchoolById("CNT");
        schoolService.deleteSchool(schoolToDelete);
        System.out.println("Deleted school with ID CNT.");
    }
}