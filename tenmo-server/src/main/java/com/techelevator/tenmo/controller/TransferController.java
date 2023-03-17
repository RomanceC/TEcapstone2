package com.techelevator.tenmo.controller;



    import com.techelevator.tenmo.dao.AccountDao;
    import com.techelevator.tenmo.dao.TransferDao;
    import com.techelevator.tenmo.dao.UserDao;
    import com.techelevator.tenmo.model.Account;
    import com.techelevator.tenmo.model.Transfer;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;

    import java.security.Principal;
    @RestController
@PreAuthorize("isAuthenticated()")

    public class TransferController {



            @Autowired
            private AccountDao accountDao;

            @Autowired
            private UserDao userDao;

            @Autowired
            private TransferDao transferDao;


            @RequestMapping(path = "/transfer" ,method = RequestMethod.POST)
            public int transfer(@RequestBody Transfer transfer){
                //call transferDao to do the transfer
                return transferDao.sendMoney(transfer);
            }
        }



