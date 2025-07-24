package vn.edu.eiu.testlab.tightcoupling;

/**
 * UI: dang' le~ ra se co form nhap thong tin Account >> goi accountService
 * de xu ly logic tao account va thong bao xac nhan
 */
public class MainTightCoupling {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.registerAccount(new AccountEntity());

    }
}
