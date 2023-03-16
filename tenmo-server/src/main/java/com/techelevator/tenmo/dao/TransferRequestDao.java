package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public class TransferRequestDao {

        private int toAccountId;
        private  BigDecimal amountToTransfer;

        public int getToAccountId() {
            return toAccountId;
        }

        public void setToAccountId(int toAccountId) {
            this.toAccountId = toAccountId;
        }

        public BigDecimal getAmountToTransfer() {
            return amountToTransfer;
        }

        public void setAmountToTransfer(BigDecimal amountToTransfer) {
            this.amountToTransfer = amountToTransfer;
        }
    }
