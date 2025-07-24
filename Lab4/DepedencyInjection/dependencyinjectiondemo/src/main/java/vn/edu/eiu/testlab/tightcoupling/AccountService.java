package vn.edu.eiu.testlab.tightcoupling;


/**
 * Class nay co nhiem vu
 * nhan du lieu tu UI (form dang ki)
 * Xu ly logic dang ky thanh vien => dua cho repo ghi xuong database
 * Gui thong tin xac nhan dang ki( gia dinh qua Email)
 * Cac depedency cua no:
 * 1 Repo
 * 2 EmailSender
 *
 */
public class AccountService {
    //1 . Da xu ly dang ki thanh vien
    private AccountRepo accountRepo;
    private EmailSender emailSender = new EmailSender();

    // thuc hien dang ki
    public void registerAccount( AccountEntity account ) {
        //Goi repo ghi xuong database( gia? xu~ da~ goi.)
    }

}
