package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


    @Component
    public class JdbcTransferDao implements TransferDao {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired
        private AccountDao accountDao;

        @Override
        public int sendMoney(Transfer transfer) {

         String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, amount,account_from, account_to)\n" +
                 "VALUES (?, ?, ?, ?, ?) returning transfer_id";
           return jdbcTemplate.queryForObject(sql, Integer.class, transfer.getTransferTypeId(), transfer.getTransferStatusId(),transfer.getAmount(), transfer.getAccountFrom(), transfer.getAccountTo());


        }

        @Override

        public Transfer getTransferById(int transferId) {


                String sql = "SELECT * FROM transfer WHERE transfer_id = ?;";
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
                Transfer transfer = new Transfer();
                while(results.next()){
                    transfer = mapRowToTransfer(results);
                }
                return transfer;
        }

        @Override
        public List<com.techelevator.tenmo.model.Transfer> getAllTransfer(int userId) {
            return null;

        }

        private Transfer mapRowToTransfer(SqlRowSet rs) {
            Transfer transfer = new Transfer();
            transfer.setTransferStatusId(rs.getInt("transfer_status_id"));
            transfer.setTransferId(rs.getInt("transfer_Id"));
            transfer.setAmount(rs.getBigDecimal("amount"));
            transfer.setTransferTypeId(rs.getInt("transfer_typeId"));
            transfer.setAccountFrom(rs.getInt("account_from"));
            transfer.setAccountTo(rs.getInt("account_to"));

            return transfer;
        }


    }

