package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

public class JdbcTransferDao {

    @Component
    public class jdbcTransferDao implements TransferDao{
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired

        private AccountDao accountDao;

        @Override
        public String sendMoney (int accountFrom, int accountTo, BigDecimal amount) {


            return "";
        }

        @Override

           public Transfer getTransferById (int transferId) {
            return null;
        }
        @Override
        public List <Transfer> getAllTransfer (int userId){
            return null;

        }

