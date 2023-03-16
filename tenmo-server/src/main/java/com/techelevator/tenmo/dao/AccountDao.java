package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;

public interface AccountDao {


    Account viewBalance(int userId);
    Account addToBalance(BigDecimal amToAdd, int id);
    Account subtractFromBalance(BigDecimal amtToSubtract, int id);
    Account findUserById(int userId);
    Account findAccountById(int id);
}

