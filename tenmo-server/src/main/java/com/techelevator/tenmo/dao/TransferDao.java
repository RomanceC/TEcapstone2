package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    public int sendMoney(Transfer transfer); // send/transfer money
    public Transfer getTransferById (int transferId); //view money
    public List<Transfer> getAllTransfer(int userId); //view the money transfer history

}
