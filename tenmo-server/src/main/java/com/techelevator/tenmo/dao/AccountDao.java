package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import java.math.BigDecimal;
import java.security.Principal;

public interface AccountDao {


    Account viewBalance(int userId);
    Account addToBalance(BigDecimal amtToAdd, int id);
    Account subtractFromBalance(BigDecimal amtToSubtract, int id);
    Account findUserById(int userId);
    Account findAccountById(int id);

}