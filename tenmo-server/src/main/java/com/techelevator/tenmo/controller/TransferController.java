package com.techelevator.tenmo.controller;



    import com.techelevator.tenmo.dao.AccountDao;
    import com.techelevator.tenmo.dao.UserDao;
    import com.techelevator.tenmo.model.Account;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;

    import java.security.Principal;

    public class TransferController {
        @PreAuthorize("isAuthenticated()")
        @RestController
        public class AccountController {

            @Autowired
            private AccountDao accountDao;

            @Autowired
            private UserDao userDao;
        }

    }

