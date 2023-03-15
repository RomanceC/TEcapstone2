package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao{

    Account account = new Account();
    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account viewBalance(int id) {
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        Account account = new Account();
        while(results.next()){
            account = mapRowToAccount(results);
        }
        return account;

    }

    @Override
    public Account addToBalance(BigDecimal amtToAdd, int id) {

        account = findAccountById(id);
        BigDecimal newBalance = account.getBalance().add(amtToAdd);
        System.out.println("This is the new balance:" + newBalance);
        String sql = "UPDATE account SET balance = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, newBalance,id);
        return  account;

    }

    @Override
    public Account subtractFromBalance(BigDecimal amtToSubtract, int id) {

        account = findAccountById(id);
        BigDecimal newBalance = account.getBalance().subtract(amtToSubtract);
        String sql = "UPDATE accounts SET balance = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, newBalance, id);
        return account;
    }

    @Override
    public Account findUserById(int userId) {

        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?";
        account = null;
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        account = mapRowToAccount(result);
        return account;
    }

    @Override
    public Account findAccountById(int id) {

        account = null;
        String sql ="SELECT account_id, user_id, balance FROM accounts WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            account = mapRowToAccount(results);
        }
        return account;
    }


    private Account mapRowToAccount(SqlRowSet rs) {
        account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }


}