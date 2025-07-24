package vn.edu.eiu.testlab.loosecoupling.ver3inteface;

import vn.edu.eiu.testlab.tightcoupling.AccountRepo;

public class AccountService {

    AccountRepo accountRepo;


    private NotiService notiService;

    //1 khai bao tiem bang constructor
    public AccountService(NotiService notiService) {
        this.notiService = notiService;
    }
    //2 Khai bao tiem bang Setter
    public void setNotiService(NotiService notiService) {
        this.notiService = notiService;
    }

    public void registerAccount(AccountEntity account) {


    }
}
